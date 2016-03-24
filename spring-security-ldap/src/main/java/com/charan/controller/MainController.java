package com.charan.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/main")
public class MainController {

	protected static Logger logger = Logger.getLogger("controller");

	@RequestMapping(value = "/common", method = RequestMethod.GET)
	public String getCommonPage() {
		logger.debug("Received request to show common page");
		String username;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		System.out.println(
				"************************************\n" + username + "\n************************************");
		return "commonpage";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminPage() {
		logger.debug("Received request to show admin page");
		return "adminpage";
	}
}
