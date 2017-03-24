package com.web.api.Utility;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.web.api.Dto.WishDTO;
import com.web.api.Entities.Wish;

public class WishUtility {
	/**
	 * Constructeur de la classe WishUtility.
	 */
	private WishUtility() {
		super();
	}

	public static Wish convertDtoToEntity(WishDTO dto) {
		Wish entity = new Wish();
		if (dto.getName() != null) {
			entity.setName(dto.getName());
		}
		if (dto.getDescription() != null) {
			entity.setDescription(dto.getDescription());
		}
		if (dto.getDate() != null) {
			entity.setDate(dto.getDate());
		}
		if (dto.getId() != null) {
			entity.setId(dto.getId());
		}

		return entity;
	}

	public static WishDTO convertEntityToDTO(Wish entity) {
		WishDTO dto = new WishDTO();
		if (entity.getName() != null) {
			dto.setName(entity.getName());
		}
		if (entity.getDescription() != null) {
			dto.setDescription(entity.getDescription());
		}
		if (entity.getDate() != null) {
			dto.setDate(entity.getDate());
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			dto.setLabelDate(df.format(entity.getDate()));
		}
		if (entity.getId() != null) {
			dto.setId(entity.getId());
		}
		return dto;
	}
}
