package com.solodkyi.JavaLab2.LibrarySystem;

import java.util.ArrayList;

public class Library implements IManageable
{
	private ArrayList<Item> items;
	private ArrayList<Patron> patrons;

	public Library() 
	{
		items = new ArrayList<Item>();
		patrons = new ArrayList<Patron>();
	}
	
	@Override
	public void add(Item item) 
	{
		if(item.getIsBorrowed()) 
		{
			throw new IllegalArgumentException("You can't add borrowed item in Library!"); 
		}
		
		for(Item existItem : items) 
		{
			if(existItem.getUniqueID().equals(item.getUniqueID())) 
			{
				throw new IllegalArgumentException("ID of item already exist in Library!"); 
			}
		}

		items.add(item);
	}

	@Override
	public Boolean remove(Item item) 
	{
		Boolean removed = items.remove(item);;
		if(removed) 
		{
			for(Patron patron : patrons) 
			{
				for(Item borrowedItem : patron.getBorrowedItems()) 
				{
					if(borrowedItem.equals(item)) 
					{
						patron.getBorrowedItems().remove(borrowedItem);
						return removed;
					}
				}
			}
		}
		return removed;
	}

	@Override
	public ArrayList<Item> listAvailable() 
	{
		ArrayList<Item> avaibleItems = new ArrayList<Item>();
		for(Item item : items) 
		{
			if(!item.getIsBorrowed()) 
			{
				avaibleItems.add(item);
			}
		}
		return avaibleItems;
	}

	@Override
	public ArrayList<Item> listBorrowed() 
	{
		ArrayList<Item> borrowedItems = new ArrayList<Item>();
		for(Item item : items) 
		{
			if(item.getIsBorrowed()) 
			{
				borrowedItems.add(item);
			}
		}
		return borrowedItems;
	}
	
	public ArrayList<Patron> getPatronList() 
	{
		return patrons;
	}
	
	public void printLibrary() 
	{
		System.out.println();
		for(Item item : items) 
		{
			System.out.println(item.toString());
		}
		for(Patron patron : patrons) 
		{
			System.out.println(patron.toString());
		}
	}	
	
	public void registerPatron(Patron newPatron) 
	{
		if(!newPatron.getBorrowedItems().isEmpty()) 
		{
			throw new IllegalArgumentException("New Patron couldn't have borrowed items before registration!");
		}
		for(Patron existPatron : patrons) 
		{
			if(existPatron.getID().equals(newPatron.getID()))
			{
				throw new IllegalArgumentException("Patron with this ID already exist!");
			}
		}		
		patrons.add(newPatron);
	}
	
	private int checkLendingPatron(Patron lendPatron) 
	{
		for(int i = 0; i < patrons.size(); i++) 
		{
			if(patrons.get(i).equals(lendPatron)) 
			{
				return i;
			}
		}
		
		throw new IllegalArgumentException("This Patron doesn't exist in register of Library!");
	}
	
	private int checkLendingItem(Item lendItem) 
	{
		for(int i = 0; i < items.size(); i++) 
		{
			if(items.get(i).equals(lendItem)) 
			{
				return i;
			}
		}
		throw new IllegalArgumentException("This Item doesn't exist in register of Library!");
	}
	
	public void lendItem(Patron lendPatron, Item lendItem) 
	{
		if(lendItem.getIsBorrowed()) 
		{
			throw new IllegalArgumentException("This Item is already borrowed!");
		}
		int patronIndex = checkLendingPatron(lendPatron);
		int itemIndex = checkLendingItem(lendItem);
		
		items.get(itemIndex).borrowItem();
		patrons.get(patronIndex).borrow(items.get(itemIndex));
	}
	
	public void returnItem(Patron lendPatron, Item lendItem) 
	{
		if(!lendItem.getIsBorrowed()) 
		{
			throw new IllegalArgumentException("This Item is already avaible!");
		}
		int patronIndex = checkLendingPatron(lendPatron);
		int itemIndex = checkLendingItem(lendItem);
		if(!lendPatron.getBorrowedItems().contains(lendItem)) 
		{
			throw new IllegalArgumentException("This Patron doesn't have this Item!");
		}
		
		
		items.get(itemIndex).returnItem();
		patrons.get(patronIndex).returned(items.get(itemIndex));		
	}
}
