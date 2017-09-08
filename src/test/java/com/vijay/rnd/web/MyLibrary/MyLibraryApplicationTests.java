package com.vijay.rnd.web.MyLibrary;

import io.restassured.RestAssured;

import org.apache.coyote.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vijay.rnd.web.MyLibrary.persistence.model.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { MyLibraryApplication.class }, webEnvironment = WebEnvironment.DEFINED_PORT)
public class MyLibraryApplicationTests {
	private static final String API_ROOT = "http://localhost:8081/api/books";

	@Test
	public void contextLoads() {
	}

	@Before
	public void setUp() {
		//RestAssured.authentication = preemptive().basic("john", "123");
	}

	private Book createRandomBook() {
		Book book = new Book();
	/*	book.setTitle(randomAlphabetic(10));
		book.setAuthor(randomAlphabetic(15));*/
		return book;
	}

	/*private String createBookAsUri(Book book) {
		Response response = RestAssured.given()
				.contentType(MediaType.APPLICATION_JSON_VALUE).body(book)
				.post(API_ROOT);
		return API_ROOT + "/" + response.jsonPath().get("id");
	}*/
}
