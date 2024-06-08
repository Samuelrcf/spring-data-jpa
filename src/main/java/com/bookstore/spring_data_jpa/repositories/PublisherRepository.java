package com.bookstore.spring_data_jpa.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.spring_data_jpa.models.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, UUID>{

}
