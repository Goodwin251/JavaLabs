package com.solodkyi.java_labs.Lab1;
import java.util.ArrayList;

public class Library {
	private ArrayList<Book> books  = new ArrayList<Book>();
	
	public Boolean addBook(String name, String author, String isbn, int year) {
		books.add(new Book(name, author, isbn, year));
		return true;
	}
	public Boolean removeBookByISBN(String isbn) {
		System.out.println("\nRemoving:");
		for(Book book : books) {
			if(book.getISBN().equals(isbn)) {
				books.remove(book);
				System.out.println("Book succsesfull removed.\n");
				return true;
			}
		}
			System.out.println("Book for remove is not found.\n");
			return false;
	}
	public Boolean searchBookByName(String name) {
		System.out.println("\nSearch:");
		for(Book book : books) {
			if(book.getName().equals(name)) {
				System.out.println(book.toString());
				return true;
			}
		}
		System.out.println("Book is not found.\n");	
		return false;
	}
	
	public void printBooks() {
		for(Book book : books) {
			System.out.println(book.toString());
		}
	}
	public Library() {
	}
}
