package com.web.api.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.api.Dto.WishDTO;
import com.web.api.Entities.Wish;
import com.web.api.Utility.WishUtility;

@Repository
public class WishDAOImpl implements WishDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public WishDTO add(WishDTO wish) {
		wish.setDate(new Date());
		Wish entity = WishUtility.convertDtoToEntity(wish);
		sessionFactory.getCurrentSession().merge(entity);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WishDTO> loadWish() {

		String query = "from Wish";
		List<WishDTO> dtos = new ArrayList<WishDTO>();
		List<Wish> wishs = sessionFactory.getCurrentSession().createQuery(query).list();
		for (Wish wish : wishs) {
			WishDTO dto = WishUtility.convertEntityToDTO(wish);
			dtos.add(dto);
		}
		return dtos;
	}

	@Override
	public void deleteWish(WishDTO wish) {

		Wish entity = WishUtility.convertDtoToEntity(wish);
		sessionFactory.getCurrentSession().delete(entity);

	}

}
