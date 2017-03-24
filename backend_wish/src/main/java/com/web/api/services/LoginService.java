package com.web.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.api.Dao.UserDAO;
import com.web.api.Dto.RoleDTO;
import com.web.api.Dto.UserDTO;

@Service("loginService")
public class LoginService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;

	public LoginService() {
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		UserDTO user =  userDAO.loadUserByUsername(username);
		if (user == null) {
			return null;
		}
		List<RoleDTO> roles =userDAO.loadRolesByUserId(user.getId());
		user.setRoles(roles);
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = buildSimpleGrantedAuthorities(user);
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(),
				user.getPassword(), user.isActive(), true, true, true, simpleGrantedAuthorities);
		return userDetails;

	}

	private List<SimpleGrantedAuthority> buildSimpleGrantedAuthorities(final UserDTO user) {
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
		if (user.getRoles() != null) {
			for (RoleDTO role : user.getRoles()) {
				simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getAbrev()));
			}
		}
		return simpleGrantedAuthorities;
	}
}