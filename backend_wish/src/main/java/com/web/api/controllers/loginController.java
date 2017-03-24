package com.web.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.api.constants.CommonURIConstants;

@RestController
public class loginController {
	@RequestMapping(value = CommonURIConstants.LOGIN_URI, method = RequestMethod.GET)
	public @ResponseBody String login() {
		System.out.println("Welcome");
		return "welcome";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public @ResponseBody String logout() {
		System.out.println("logout");
		return "logout";
	}
}
