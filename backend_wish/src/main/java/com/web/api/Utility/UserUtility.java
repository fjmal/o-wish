package com.web.api.Utility;

import com.web.api.Dto.UserDTO;
import com.web.api.Entities.UserEntity;

public final class UserUtility {

	/**
	 * Constructeur de la classe UserUtility.
	 */
	private UserUtility() {
		super();
	}

	public static UserEntity convertDtoToEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		if (dto.getId() != null) {
			entity.setUserId(dto.getId());
		}
		if (dto.getPassword() != null) {
			entity.setPassword(dto.getPassword());
		}
		if (dto.getUsername() != null) {
			entity.setUsername(dto.getUsername());
		}

		return entity;
	}

	public static UserDTO convertEntityToDTO(UserEntity entity) {
		UserDTO dto = new UserDTO();
		if (entity.getUserId() != null) {
			dto.setId(entity.getUserId());
		}
		if (entity.getPassword() != null) {
			dto.setPassword(entity.getPassword());
		}
		if (entity.getUsername() != null) {
			dto.setUsername(entity.getUsername());
		}
		return dto;
	}

}
