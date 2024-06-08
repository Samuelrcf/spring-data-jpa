package com.bookstore.spring_data_jpa.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.spring_data_jpa.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	ReviewRepository reviewRepository;
	
	public void deleteReview(UUID id){
		reviewRepository.deleteById(id);;
	}
}
