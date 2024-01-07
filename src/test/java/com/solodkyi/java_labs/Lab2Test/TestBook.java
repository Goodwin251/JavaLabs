package com.solodkyi.java_labs.Lab2Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solodkyi.java_labs.Lab2.librarySystem.Book;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestBook 
{
	Book book;
	
	@BeforeEach
	void setup()
	{
		book = new Book("TestName", "TestID", "TestAuthor");
	}
	
	@Test
	void testBookIsEqual() 
	{
		Book book2 = book;
		assertTrue(book.equals(book2));
	}
	@Test
	void testBookIsUnequal() 
	{
		Book book2 = new Book("DifferentName", "DifferentID", "DifferentAuthor");
		assertTrue(!book.equals(book2));
	}
}
