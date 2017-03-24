package com.web.api.elastic.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.web.api.Entities.Wish;


public interface WishRepository extends ElasticsearchRepository<Wish, String> {

	 
	  Page<Wish> findByName(String name,Pageable pageable);
}