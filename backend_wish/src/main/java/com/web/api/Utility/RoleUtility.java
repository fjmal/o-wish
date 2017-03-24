package com.web.api.Utility;

import com.web.api.Dto.RoleDTO;
import com.web.api.Entities.RoleEntity;

public final class RoleUtility {
	/**
	 * Constructeur de la classe RoleUtility.
	 */
	private RoleUtility() {
		super();
	}

	public static RoleEntity convertDtoToEntity(RoleDTO dto) {
		RoleEntity entity = new RoleEntity();
		if (dto.getId() != null) {
			entity.setRoleId(dto.getId());
		}
		if (dto.getDescription() != null) {
			entity.setDescription(dto.getDescription());
		}
		if (dto.getAbrev() != null) {
			entity.setAbrev(dto.getAbrev());
		}

		return entity;
	}

	public static RoleDTO convertEntityToDTO(RoleEntity entity) {
		RoleDTO dto = new RoleDTO();
		if (entity.getRoleId() != null) {
			dto.setId(entity.getRoleId());
		}
		if (entity.getDescription() != null) {
			dto.setDescription(entity.getDescription());
		}
		if (entity.getAbrev() != null) {
			dto.setAbrev(entity.getAbrev());
		}
		return dto;
	}

}
