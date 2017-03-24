package com.web.api.Dao;

import java.util.List;

import com.web.api.Dto.WishDTO;

public interface WishDAO {

	WishDTO add(WishDTO wish);

	List<WishDTO> loadWish();

	void deleteWish(WishDTO wish);

}
