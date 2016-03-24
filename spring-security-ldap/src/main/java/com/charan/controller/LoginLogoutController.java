package com.charan.controller;

import org.apache.log4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class LoginLogoutController {

	protected static Logger logger = Logger.getLogger("controller");

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(@RequestParam(value = "error", required = false) boolean error, ModelMap model) {
		logger.debug("Received request to show login page");

		if (error == true) {
			model.put("error", "You have entered an invalid username or password!");
		} else {
			model.put("error", "");
		}

		return "loginpage";
	}

	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String getDeniedPage() {
		logger.debug("Received request to show denied page");

		// This will resolve to /WEB-INF/jsp/deniedpage.jsp
		return "deniedpage";
	}

}