package com.vijay.rnd.web.MyLibrary.exception;

public class BookNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private Long bookId;

	public Long getBookId() {
		return bookId;
	}

	private static final long serialVersionUID = 1L;

	public BookNotFoundException(Long id) {
		super("book# " + id + " was not found");
		this.bookId = id;
	}
}
