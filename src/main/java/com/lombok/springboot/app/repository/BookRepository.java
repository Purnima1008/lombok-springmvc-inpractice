package com.lombok.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lombok.springboot.app.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
