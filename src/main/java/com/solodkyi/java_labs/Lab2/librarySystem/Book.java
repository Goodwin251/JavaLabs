package com.solodkyi.java_labs.Lab2.librarySystem;

public class Book extends Item
{
	private String author;
	
	public String getAuthor() {
		return author;
	}

	public Book(String title, String uniqueID, String author) 
	{
		super(title, uniqueID);
		this.author = author;
	}
	@Override
	protected void borrowItem() 
	{
		isBorrowed = true;
	}

	@Override
	protected void returnItem() 
	{
		isBorrowed = false;
	}
	
	@Override
	public String toString() 
	{
		return "Item [uniqueID=" + getUniqueID() + ", title=" + getTitle() +  ", isBorrowed=" + isBorrowed + ", author= " + author + "]";
	}
	
	@Override
	public boolean equals(Object o) 
	{
		if(!(o instanceof Book)) 
		{
			return false;
		}
		
		Book book = (Book) o;
		
		return book.getTitle().equals(this.getTitle()) && book.getUniqueID().equals(this.getUniqueID()) 
				&& book.author.equals(this.author) && book.isBorrowed == this.isBorrowed;
	}
}
