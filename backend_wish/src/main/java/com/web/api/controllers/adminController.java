package com.web.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.api.Dto.WishDTO;
import com.web.api.constants.AdminURIConstants;
import com.web.api.constants.CommonURIConstants;
import com.web.api.services.adminService;
import com.web.api.services.commonService;

@RestController
@Secured("ROLE_ADMIN")
@RequestMapping(value = AdminURIConstants.ADMIN_URI)
public class adminController {
	@Autowired
	private adminService serviceAdmin;

	@Autowired
	private commonService serviceCommon;

	@RequestMapping(value = AdminURIConstants.ADD_WISH_URL, method = RequestMethod.POST)
	public @ResponseBody WishDTO addWish(@RequestBody WishDTO wish) {
		return serviceAdmin.addWish(wish);
	}

	@RequestMapping(value = AdminURIConstants.DELETE_WISH_URL, method = RequestMethod.POST)
	public @ResponseBody void deleteWish(@RequestBody WishDTO wish) {
		serviceAdmin.deleteWish(wish);
	}

	@RequestMapping(value = CommonURIConstants.LOAD_WISH_URL, method = RequestMethod.GET)
	public @ResponseBody List<WishDTO> loadWish() {
		return serviceCommon.loadWish();
	}

	@RequestMapping(value = CommonURIConstants.IS_AUTH_URL, method = RequestMethod.GET)
	public @ResponseBody String isAuth() {
		return "auth ok";
	}

}
