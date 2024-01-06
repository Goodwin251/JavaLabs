package com.solodkyi.java_labs.Lab1Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solodkyi.java_labs.Lab1.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookTest
{
	private Book book;
	@BeforeEach
	public void setup() 
	{
		this.book = new Book("NameTest","AuthorTest","1234567891011", 2000);
	}
	
	@Test
	void testName() 
	{
		assertEquals("NameTest", book.getName());
	}
	@Test
	void testAuthorName() 
	{
		assertEquals("AuthorTest", book.getAuthor());
	}
	@Test
	void testISBN() 
	{
		assertEquals("1234567891011", book.getISBN());
	}
	@Test
	void testYear() 
	{
		assertEquals(2000, book.getYear());
	}
	@Test
	void TestExceptionThrow() {
		assertThrows
		(
				IllegalArgumentException.class, 
				() -> 
				{ 
	                new Book("InvalidBookTitle", "InvalidBookAuthor", "14124", 1); 
	            }
		);
	}
		
	
}