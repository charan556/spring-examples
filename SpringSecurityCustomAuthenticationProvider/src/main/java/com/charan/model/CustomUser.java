package com.charan.model;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class CustomUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;

	/* Spring Security related fields */
	private List<Role> authorities;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;

}
