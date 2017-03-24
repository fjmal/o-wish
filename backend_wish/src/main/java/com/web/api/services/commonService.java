package com.web.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.web.api.Dao.WishDAO;
import com.web.api.Dto.WishDTO;

@Service("commonService")
@EnableTransactionManagement
public class commonService {
	@Autowired
	private WishDAO wishDAO;

	public commonService() {
	}

	@Transactional
	public List<WishDTO> loadWish() {
		return wishDAO.loadWish();
	}

}
