package com.bookstore.spring_data_jpa.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.spring_data_jpa.services.ReviewService;

@RestController
@RequestMapping("/bookstore/reviews")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteReview(@PathVariable UUID id){
		reviewService.deleteReview(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
