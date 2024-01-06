package com.solodkyi.java_labs.Lab2Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solodkyi.JavaLab2.LibrarySystem.Book;
import com.solodkyi.JavaLab2.LibrarySystem.DVD;
import com.solodkyi.JavaLab2.LibrarySystem.Library;
import com.solodkyi.JavaLab2.LibrarySystem.Patron;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestLibrary 
{
	Patron patron;
	Book book;
	DVD dvd;
	Library lib;
	
	@BeforeEach
	void setup() 
	{
		patron = new Patron("TestPatron", "TestPatronID");
		book = new Book("TestBook", "1", "TestAuthor");
		dvd = new DVD("TestDVD", "2", 10);
		lib = new Library();
		
		lib.add(book);
		lib.add(dvd);
		lib.registerPatron(patron);
	}
	
	@Test
	void testAvaibleList() 
	{
		lib.lendItem(patron, book);
		assertTrue(lib.listAvailable().contains(dvd) && !dvd.getIsBorrowed());
	}
	@Test 
	void testBorrowedList() 
	{
		lib.lendItem(patron, book);
		assertTrue(lib.listBorrowed().contains(book) && book.getIsBorrowed());
	}	
	@Test
	void testAddItem() 
	{
		Book newBook = new Book("NewBook", "TestBookID", "TestAuthor");
		DVD newDVD = new DVD("NewDVD", "TestDVDID", 3);
		
		lib.add(newBook);
		lib.add(newDVD);
		
		assertTrue(lib.listAvailable().contains(newDVD) && lib.listAvailable().contains(newBook));
	}
	@Test
	void testAddItemWithSameID() 
	{		
		assertThrows
		(
				IllegalArgumentException.class, 
				() -> 
				{
					lib.add(book);
				}
		);	
	}
	@Test
	void testAddBorrowedItem() 
	{
		assertThrows
		(
				IllegalArgumentException.class, 
				() -> 
				{
					lib.lendItem(patron, book);
					Library lib2 = new Library();
					lib2.add(book);
				}
		);
	}
	@Test
	void testRemoveItem() 
	{
		assertTrue(lib.remove(book));
		assertTrue(!lib.listAvailable().contains(book));
	}
	@Test
	void testRemoveNotExistedItem() 
	{
		assertTrue(!lib.remove(new Book("TestRemoveBook","Remove","TestAuthor")));
	}
	@Test
	void testRegisterPatron() 
	{
		Patron newPatron = new Patron("NewPatron", "NewPatronID");
		lib.registerPatron(newPatron);
		assertTrue(lib.getPatronList().contains(newPatron));
	}
	@Test
	void testRegisterPatronWithBorrowedItems() 
	{
		lib.lendItem(patron, book);
		Library newLib = new Library();
		assertThrows
		(
				IllegalArgumentException.class,
				() ->
				{
					newLib.registerPatron(patron);
				}
		);
		
	}
	void testRegisterPatronWithSameID() 
	{
		Patron newPatron = new Patron("NewPatron", "TestPatronID");
		assertThrows
		(
				IllegalArgumentException.class, 
				()->
				{
					lib.registerPatron(newPatron);
				}
		);
	}
	@Test 
	void testLendItem() 
	{
		lib.lendItem(patron, book);
		assertTrue(lib.listBorrowed().contains(book));
		assertTrue(!lib.listAvailable().contains(book));
		assertTrue(lib.getPatronList().contains(patron));
		assertTrue(patron.getBorrowedItems().contains(book));
		assertTrue(book.getIsBorrowed());
	}
	@Test 
	void testLendBorrowedItem() 
	{
		lib.lendItem(patron, book);
		assertThrows
		(
				IllegalArgumentException.class,
				()->
				{
					lib.lendItem(patron, book);
				}
		);
	}
	@Test
	void testLendToUnRegistredPatron() 
	{
		Patron newPatron = new Patron("NewPatron", "TestPatronID");
		
		assertThrows
		(
				IllegalArgumentException.class,
				()->
				{
					lib.lendItem(newPatron, book);
				}
		);
	}
	@Test
	void testLendUnRegisteredItem() 
	{
		Book newBook = new Book("TestBook", "BookTestID", "TestBookAuthor");
		assertThrows
		(
				IllegalArgumentException.class,
				()->
				{
					lib.lendItem(patron, newBook);
				}
		);
	}
	@Test 
	void testReturnItem()
	{
		lib.lendItem(patron, book);
		lib.returnItem(patron, book);
		assertTrue(!lib.listBorrowed().contains(book));
		assertTrue(lib.listAvailable().contains(book));
		assertTrue(lib.getPatronList().contains(patron));
		assertTrue(!patron.getBorrowedItems().contains(book));
		assertTrue(!book.getIsBorrowed());
	}
	@Test
	void testReturnAvaibleItem() 
	{
		assertThrows
		(
				IllegalArgumentException.class,
				() ->
				{
					lib.returnItem(patron, book);
				}
		);
	}
	@Test
	void testReturnBorrowedItemFromWrongPatron() 
	{
		lib.lendItem(patron, book);
		Patron newPatron = new Patron("PatronTestName","PatronTestID");
		lib.registerPatron(newPatron);
		assertThrows
		(
				IllegalArgumentException.class,
				() ->
				{
					lib.returnItem(newPatron, book);
				}
		);
	}
}
