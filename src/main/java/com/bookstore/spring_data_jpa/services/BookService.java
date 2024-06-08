package com.bookstore.spring_data_jpa.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.spring_data_jpa.dtos.BookDto;
import com.bookstore.spring_data_jpa.models.Book;
import com.bookstore.spring_data_jpa.models.Review;
import com.bookstore.spring_data_jpa.repositories.AuthorRepository;
import com.bookstore.spring_data_jpa.repositories.BookRepository;
import com.bookstore.spring_data_jpa.repositories.PublisherRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@Transactional
	public Book saveBook(BookDto bookDto) {
		Book book = new Book();
		book.setTitle(bookDto.title());
		book.setPublisher(publisherRepository.findById(bookDto.publisherId()).get());
		book.setAuthors(authorRepository.findAllById(bookDto.authorsIds()).stream().collect(Collectors.toSet()));
		
		Review review = new Review();
		review.setComment(bookDto.reviewComment());
		review.setBook(book);
		
		book.setReview(review);
		
		return bookRepository.save(book);
	}
}
