package com.charan.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.charan.model.CustomUser;
import com.charan.model.Role;

@Repository
public class UserDAOImpl {

	public CustomUser loadUserByUsername(final String username) {
		// Write your DB call code to get the user details from DB,But I am just
		// hard coding the user
		CustomUser user = new CustomUser();
		user.setFirstName("Charan");
		user.setLastName("Vallala");
		user.setUsername("charanv");
		user.setPassword("password");
		Role r = new Role();
		r.setName("ROLE_USER");
		List<Role> roles = new ArrayList<Role>();
		roles.add(r);
		user.setAuthorities(roles);
		return user;
	}

}
