package com.web.api.Dao;

import java.util.List;

import com.web.api.Dto.RoleDTO;
import com.web.api.Dto.UserDTO;

public interface UserDAO {

	public UserDTO loadUserByUsername(String username);

	public List<RoleDTO> loadRolesByUserId(Integer userId);

	
}
