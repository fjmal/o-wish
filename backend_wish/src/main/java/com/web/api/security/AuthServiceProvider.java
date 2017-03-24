package com.web.api.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService loginService;

	private UserDetails connectedUserDetails;

	public boolean isAuthenticated() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication != null && !(authentication instanceof AnonymousAuthenticationToken)
				&& authentication.isAuthenticated();

	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();

		if (authorizedUser(userName, password)) {

			Authentication auth = new UsernamePasswordAuthenticationToken(userName, password,
					connectedUserDetails.getAuthorities());
			
			System.out.println(auth.getAuthorities());
			return auth;
		} else {
			throw new AuthenticationCredentialsNotFoundException("Invalid Credentials!");
		}
	}

	private boolean authorizedUser(String userName, String password) {
		// check user in data base
		UserDetails user = loginService.loadUserByUsername(userName);
		if (user != null) {

			if (user.getPassword().equals(password)) {
				connectedUserDetails = user;
				return true;
			}
		}
		return false;

	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}