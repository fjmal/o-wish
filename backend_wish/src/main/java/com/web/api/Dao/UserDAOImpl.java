package com.web.api.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.api.Dto.RoleDTO;
import com.web.api.Dto.UserDTO;
import com.web.api.Entities.RoleEntity;
import com.web.api.Entities.RoleUserEntity;
import com.web.api.Entities.UserEntity;
import com.web.api.Utility.RoleUtility;
import com.web.api.Utility.UserUtility;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")

	public UserDTO loadUserByUsername(String username) {

		String query = "from UserEntity where username=?";
		List<UserEntity> users = sessionFactory.getCurrentSession().createQuery(query).setParameter(0, username).list();

		if (users.size() > 0) {
			UserEntity userEntity = users.get(0);
			return UserUtility.convertEntityToDTO(userEntity);
		} else {
			return null;
		}
	}

	@Override
	public List<RoleDTO> loadRolesByUserId(Integer userId) {
		List<RoleDTO> roleDtos = new ArrayList<RoleDTO>();
		String query = "from RoleUserEntity userRole  "
				+ " where userRole.user.userId=?";
		@SuppressWarnings("unchecked")
		List<RoleUserEntity> roles = sessionFactory.getCurrentSession().createQuery(query).setParameter(0, userId).list();

		if (roles.size() > 0) {
			for (RoleUserEntity roleUserEntity : roles) {
				roleDtos.add(RoleUtility.convertEntityToDTO(roleUserEntity.getRole()));
			}
		}

		return roleDtos;
	}

}
