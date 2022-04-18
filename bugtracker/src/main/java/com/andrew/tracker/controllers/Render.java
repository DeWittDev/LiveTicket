package com.andrew.tracker.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.andrew.tracker.model.Bug;
import com.andrew.tracker.model.LoginUser;
import com.andrew.tracker.model.User;
import com.andrew.tracker.services.BugService;
import com.andrew.tracker.services.UserService;

@Controller
public class Render {
	@Autowired
    private UserService userService;
    
    @Autowired
    private BugService bugService;
    
	@Autowired 
	private HttpSession session;
	
	//Login and Registration
    @GetMapping("/")
    public String HomeRegister(@ModelAttribute("newUser") User newUser, @ModelAttribute("newLogin") LoginUser newLogin) {
    	if(session.getAttribute("currentUser") != null) {
    		return "redirect:/dash";
    	}
    	return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User user, BindingResult result, @ModelAttribute("newLogin") LoginUser newLogin) {
    	userService.validation(user, result);
    	if(result.hasErrors()) {
    		return "index.jsp";
    	}
		userService.register(user);
		session.setAttribute("currentUser", user);
    	return "redirect:/dash";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, @ModelAttribute("newUser") User user, Model model) {
    	userService.authenticate(newLogin, result);
    	if(result.hasErrors()) {
    		return "index.jsp";
    	}
    	User currentUser = userService.findByEmail(newLogin.getUserEmail());
    	
    	session.setAttribute("currentUser", currentUser);
    	return "redirect:/dash";
    }
    
    @GetMapping("/logout")
    public String logOut() {
    	session.invalidate();
    	return "redirect:/";
    }
    
    //Dashboard 
    @GetMapping("/dash")
    public String dashboard(Model model){
    	if(session.getAttribute("currentUser") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("bug", bugService.findAll());
    	return "dash.jsp";
    }
    
    //Create Report
    @GetMapping("/bug/report")
    public String reportForm(@ModelAttribute("bug") Bug bug) {
    	if(session.getAttribute("currentUser") == null) {
    		return "redirect:/";
    	}
    	return "repform.jsp";
    }
    
    @PostMapping("/bug/submit")
    public String report(@Valid @ModelAttribute("newBug") Bug bug, BindingResult result) {
    	if(session.getAttribute("currentUser") == null) {
    		return "redirect:/";
    	}
    	bugService.addBug(bug);
    	return "redirect:/";
    }
    
    //View Report
    @GetMapping("/bug/{id}") 
    public String info(@PathVariable("id") Long id, Model model) {
    	if(session.getAttribute("currentUser") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("bug", bugService.findById(id));
    	return "info.jsp";
    }
    
    
    //Edit Report
    @GetMapping("/edit/bug/{id}")
    public String editReport(@PathVariable("id") Long id, Model model) {
    	if(session.getAttribute("currentUser") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("bug", bugService.findById(id));
    	return "editBug.jsp";
    }
    
    @PutMapping("/edit/{id}")
    public String editBug(@Valid @PathVariable("id") Long id, @ModelAttribute("bug") Bug bug) {
    	if(session.getAttribute("currentUser") == null) {
    		return "redirect:/";
    	}
    	bugService.editBug(bug);
    	return "redirect:/";
    }
    
    
    //Delete Report
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
    	if(session.getAttribute("currentUser") == null) {
    		return "redirect:/";
    	}
    	bugService.delete(id);
    	return "redirect:/";
    }
}
