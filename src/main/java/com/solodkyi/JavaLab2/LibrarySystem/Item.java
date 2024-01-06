package com.solodkyi.JavaLab2.LibrarySystem;

public abstract class Item 
{
	private String title;
	private String uniqueID;
	protected boolean isBorrowed = false;
	
	public boolean getIsBorrowed() { return isBorrowed; }
	public String getTitle() { return title; }
	public String getUniqueID() { return uniqueID; }
		
	abstract protected void borrowItem();
	abstract protected void returnItem();
	
	public Item(String title, String uniqueID) 
	{
		this.title = title;
		this.uniqueID = uniqueID;
	}
	
	@Override
	public String toString() 
	{
		return "Item [uniqueID=" + uniqueID + ", title=" + title +  ", isBorrowed=" + isBorrowed + "]";
	}
	@Override
	abstract public boolean equals(Object o);
}
