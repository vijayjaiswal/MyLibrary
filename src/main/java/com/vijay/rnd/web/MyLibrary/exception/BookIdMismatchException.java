package com.vijay.rnd.web.MyLibrary.exception;

public class BookIdMismatchException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long oldBookId;
	private Long currentBookId;

	public Long getOldBookId() {
		return oldBookId;
	}

	public Long getCurrentBookId() {
		return currentBookId;
	}

	public BookIdMismatchException(Long oldId, Long curId) {
		super("Old book# " + oldId + " is not matching with current book#"
				+ curId);
		this.oldBookId = oldId;
		this.currentBookId = curId;
	}
}
