package com.web.api.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.web.api.constants.CommonURIConstants;

public class WSAuthServiceFilter extends UsernamePasswordAuthenticationFilter {

	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		if (!CommonURIConstants.LOGIN_URI.equals(request.getPathInfo() )
				|| (CommonURIConstants.LOGIN_URI.equals(request.getPathInfo())
						&& !HttpMethod.GET.toString().equals(request.getMethod()))) {
			try {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
						"Unauthorized");
			} catch (IOException e) {
				System.out.println(	"Unauthorized");
			}
			return null;
		}

		String username = obtainUsername(request);
		String password = obtainPassword(request);

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		username = username.trim();

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		Authentication auth = getAuthenticationManager().authenticate(authRequest);

		return auth;
	}

	@Override
	protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
		// add headers for cross-domain requests
		String origin = request.getHeader("Origin");
		if (origin != null ) {
			response.addHeader("Access-Control-Allow-Origin", origin);
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			return false;
		}
		return true;
	}

}
