package com.vijay.rnd.web.MyLibrary.persistence.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.vijay.rnd.web.MyLibrary.persistence.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByTitle(String title);
}
