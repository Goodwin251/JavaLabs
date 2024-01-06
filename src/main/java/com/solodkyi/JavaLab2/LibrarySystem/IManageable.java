package com.solodkyi.JavaLab2.LibrarySystem;
import java.util.ArrayList;

public interface IManageable 
{
	void add(Item item);
	Boolean remove(Item item);
	ArrayList<Item> listAvailable();
	ArrayList<Item> listBorrowed();
}
