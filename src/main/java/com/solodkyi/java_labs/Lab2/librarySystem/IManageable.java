package com.solodkyi.java_labs.Lab2.librarySystem;
import java.util.ArrayList;

public interface IManageable 
{
	void add(Item item);
	Boolean remove(Item item);
	ArrayList<Item> listAvailable();
	ArrayList<Item> listBorrowed();
}
