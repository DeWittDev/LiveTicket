package com.andrew.tracker.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
    
	//id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	    
    //Name
    @NotEmpty(message="Name is required!")
    @Size(min=3, max=30, message="Name must be between 3 and 30 characters")
	private String name;
	    
	//Email
    @NotEmpty(message="Email is required!")
    @Email(message="Please enter a valid email!")
    private String email;
    
    //Position
    //@NotEmpty(message = "Select option")
    //private String position
	    
    //Password
    @NotEmpty(message="Password is required!")
    @Size(min=8, max=128, message="Password must be between 8 and 128 characters")
    private String password;
	    
    //Confirm Password
    @Transient
    @NotEmpty(message="Confirm Password is required!")
    @Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
    private String confirm;

    //Bug
    @OneToMany(mappedBy="users",  fetch=FetchType.LAZY)
	private List<Bug> bug;
    
    @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "messages", joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "messageId"))
    private List<Messages> Messages;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public List<Bug> getIdea() {
		return bug;
	}

	public void setIdea(List<Bug> bug) {
		this.bug = bug;
	}

	public List<Messages> getMessages() {
		return Messages;
	}

	public void setMessages(List<Messages> messages) {
		Messages = messages;
	}
	    
}
