package com.web.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.web.api.Dao.WishDAO;
import com.web.api.Dto.WishDTO;

@Service("adminService")
@EnableTransactionManagement
public class adminService {

	@Autowired
	private WishDAO wishDAO;

	public adminService() {
	}

	@Transactional
	public WishDTO addWish(WishDTO wish) {
		return wishDAO.add(wish);
	}

	@Transactional
	public void deleteWish(WishDTO wish) {
		wishDAO.deleteWish(wish);

	}
}