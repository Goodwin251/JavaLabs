package com.solodkyi.java_labs.Lab2;

import com.solodkyi.java_labs.Lab2.librarySystem.Book;
import com.solodkyi.java_labs.Lab2.librarySystem.DVD;
import com.solodkyi.java_labs.Lab2.librarySystem.Library;
import com.solodkyi.java_labs.Lab2.librarySystem.Patron;

public class App 
{
    public static void main( String[] args )
    {
    	Library lib = new Library();
    	
    	Book book = new Book("Title", "1", "Author");
    	Book book1 = new Book("Title","2","Author");
    	Book book2 = new Book("Title", "3", "Author");
    	
    	DVD dvd1 = new DVD("DVD", "4", 15);
    	DVD dvd2 = new DVD("DVD", "8", 12);
        
        Patron patron1 = new Patron("Name", "1");
        Patron patron2 =  new Patron("Name", "2");

        try 
        {
        	lib.registerPatron(patron1);
        	lib.registerPatron(patron2);
        	
        	lib.add(book);
        	lib.add(book1);
        	lib.add(book2);
        	
        	lib.add(dvd1);
        	lib.add(dvd2);
        	
            lib.printLibrary();
            
//            Item [uniqueID=1, title=Title, isBorrowed=false, author= Author]
//            Item [uniqueID=2, title=Title, isBorrowed=false, author= Author]
//            Item [uniqueID=3, title=Title, isBorrowed=false, author= Author]
//            Item [uniqueID=4, title=DVD, isBorrowed=false, duration= 15]
//            Item [uniqueID=8, title=DVD, isBorrowed=false, duration= 12]
//            Patron [name= Name, ID= 1, borrowedItems: []]
//            Patron [name= Name, ID= 2, borrowedItems: []]
            
            
            
            lib.lendItem(patron1, dvd2);
            lib.lendItem(patron2, book2);
            lib.lendItem(patron2, book1);
            
            System.out.println("\nBorrowed:" + lib.listBorrowed().toString());
            System.out.println("\nAvaiable:" + lib.listAvailable().toString());
            
//            Borrowed:[Item [uniqueID=2, title=Title, isBorrowed=true, author= Author], Item [uniqueID=3, title=Title, isBorrowed=true, author= Author], Item [uniqueID=8, title=DVD, isBorrowed=true, duration= 12]]
//
//            Available:[Item [uniqueID=1, title=Title, isBorrowed=false, author= Author], Item [uniqueID=4, title=DVD, isBorrowed=false, duration= 15]]
            
            lib.returnItem(patron2, book2);
            lib.returnItem(patron2, book1);
            lib.remove(dvd2);
            
            lib.printLibrary();
            
//            Item [uniqueID=1, title=Title, isBorrowed=false, author= Author]
//            Item [uniqueID=2, title=Title, isBorrowed=false, author= Author]
//            Item [uniqueID=3, title=Title, isBorrowed=false, author= Author]
//            Item [uniqueID=4, title=DVD, isBorrowed=false, duration= 15]
//            Patron [name= Name, ID= 1, borrowedItems: []]
//            Patron [name= Name, ID= 2, borrowedItems: []]                    
        }
        catch(Exception e)
        {
        	
        	System.out.println("\n" + e.getMessage());
        }
        
    }
}
