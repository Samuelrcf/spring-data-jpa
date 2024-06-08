package com.bookstore.spring_data_jpa.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.spring_data_jpa.dtos.BookDto;
import com.bookstore.spring_data_jpa.models.Book;
import com.bookstore.spring_data_jpa.services.BookService;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody BookDto bookDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookDto));
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks(){
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable UUID id){
		bookService.deleteBook(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
