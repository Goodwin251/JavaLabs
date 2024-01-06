package com.solodkyi.JavaLab2.LibrarySystem;
import java.util.ArrayList;

public class Patron {
	private String name;
	private String ID;
	private ArrayList<Item> borrowedItems;
	
	public Patron(String name, String iD) 
	{
		this.name = name;
		ID = iD;
		borrowedItems = new ArrayList<Item>();
	}
	
	public String getName() 
	{
		return name;
	}
	public String getID() 
	{
		return ID;
	}
	public ArrayList<Item> getBorrowedItems() 
	{
		return borrowedItems;
	}
	
	void borrow(Item item) 
	{
		borrowedItems.add(item);
	}
	void returned(Item item) 
	{
		borrowedItems.remove(item);
	}
	
	@Override
	public String toString() 
	{
		return "Patron [name= " + name + ", ID= " + ID + ", borrowedItems: " + borrowedItems.toString() + "]";
	}
	@Override
	public boolean equals(Object o) 
	{
		if(!(o instanceof Patron)) 
		{
			return false;
		}
		
		Patron patron = (Patron) o;
		if(patron.name.equals(this.name) && patron.ID.equals(this.ID) && patron.borrowedItems.size() == this.borrowedItems.size()) 
		{
			for(int i = 0; i < patron.borrowedItems.size(); i++) 
			{
				if(!(patron.borrowedItems.get(i).equals(this.borrowedItems.get(i)))) 
				{
					return false;
				}
			}
			
			return true;
		}
		return false;		
	}
}
