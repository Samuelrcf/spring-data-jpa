package com.bookstore.spring_data_jpa.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstore.spring_data_jpa.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID>{

	Book findBookByTitle(String title);
	
	@Query("SELECT b FROM Book b WHERE b.publisher.id = :id")
	List<Book> findBookByPublisherId(@Param("id") UUID id);
}
