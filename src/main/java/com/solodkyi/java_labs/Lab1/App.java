package com.solodkyi.java_labs.Lab1;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		Library lib = new Library();
		lib.addBook("Basic Math", "Jake M", "9006003005100", 1993);
		lib.addBook("Quantum Physics for dummies", "Peter D", "1234567891033", 2022);
		lib.addBook("Astronomy", "Lisa J", "0987654321123", 2017);
		lib.printBooks();
		/*
		 * Book [Name=Basic Math, Author=Jake M, ISBN=9006003005100, Year=1993]
		 * Book [Name=Quantum Physics for dummies, Author=Peter D, ISBN=1234567891033, Year=2022] 
		 * Book [Name=Astronomy, Author=Lisa J, ISBN=0987654321123, Year=2017]
		*/
		
		lib.searchBookByName("Quantum Physics for dummies");
		/*
		 * Search:
		 * Book [Name=Quantum Physics for dummies, Author=Peter D, ISBN=1234567891033, Year=2022]
		*/
		
		lib.removeBookByISBN("0987654321123");
		/*Removing:
		 * Book succsesfull removed.*/
		
		lib.printBooks();
		/*
		 * Book [Name=Basic Math, Author=Jake M, ISBN=9006003005100, Year=1993]\
		 * Book [Name=Quantum Physics for dummies, Author=Peter D, ISBN=1234567891033, Year=2022]
		 * */
	}
}
