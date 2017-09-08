package com.vijay.rnd.web.MyLibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.rnd.web.MyLibrary.exception.BookIdMismatchException;
import com.vijay.rnd.web.MyLibrary.exception.BookNotFoundException;
import com.vijay.rnd.web.MyLibrary.persistence.model.Book;
import com.vijay.rnd.web.MyLibrary.persistence.repo.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public Iterable<Book> findAll() {
		return bookRepository.findAll();
	}

	@GetMapping("/title/{bookTitle}")
	public List<Book> findByTitle(@PathVariable String bookTitle) {
		return bookRepository.findByTitle(bookTitle);
	}

	@GetMapping("/{id}")
	public Book findOne(@PathVariable Long id) {
		Book book = bookRepository.findOne(id);
		if (book == null)
			throw new BookNotFoundException(id);
		return book;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book create(@RequestBody Book book) {
		System.out.println(book);
		return bookRepository.save(book);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Book book = bookRepository.findOne(id);
		if (book == null)
			throw new BookNotFoundException(id);
		bookRepository.delete(id);
	}

	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
		if (book.getId() != id) {
			throw new BookIdMismatchException(book.getId(), id);
		}
		Book old = bookRepository.findOne(id);
		if (old == null) {
			throw new BookNotFoundException(id);
		}
		return bookRepository.save(book);
	}
}
