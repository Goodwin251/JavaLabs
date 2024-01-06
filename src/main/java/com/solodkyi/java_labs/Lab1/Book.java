package com.solodkyi.java_labs.Lab1;


public class Book 
{
	private String Name;
	private String Author;
	private String ISBN;
	private int Year;
	
	public Book(String name, String author, String iSBN, int year) 
	{
		super();
		
		if(year < 1966) throw new IllegalArgumentException("Year coudn't be before 1966 because ISBN wasn't introduced yet!");
		
		Name = name;
		Author = author;
		ISBN = iSBN;
		Year = year;
	}

	public String getName() 
	{
		return Name;
	}

	public String getAuthor() 
	{
		return Author;
	}

	public String getISBN() 
	{
		return ISBN;
	}

	public int getYear() 
	{
		return Year;
	}

	@Override
	public String toString() 
	{
		return "Book [Name=" + Name + ", Author=" + Author + ", ISBN=" + ISBN + ", Year=" + Year + "]";
	}	
}
