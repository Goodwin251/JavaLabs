package com.solodkyi.java_labs.Lab2.librarySystem;

public class DVD extends Item
{
	private int duration;

	public int getDuration() 
	{
		return duration;
	}

	public DVD(String title, String uniqueID, int duration) 
	{
		super(title, uniqueID);
		if(duration < 1) 
		{
			throw new IllegalArgumentException("Duration of DVD must be longer than 0 minute!");
		}
		this.duration = duration;
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
		return "Item [uniqueID=" + getUniqueID() + ", title=" + getTitle() +  ", isBorrowed=" + isBorrowed + ", duration= " + duration + "]";
	}
	
	@Override
	public boolean equals(Object o) 
	{
		if(!(o instanceof DVD)) 
		{
			return false;
		}
		
		DVD book = (DVD) o;
		
		return book.getTitle().equals(this.getTitle()) && book.getUniqueID().equals(this.getUniqueID()) 
				&& book.duration == this.duration && book.isBorrowed == this.isBorrowed;
	}
}
