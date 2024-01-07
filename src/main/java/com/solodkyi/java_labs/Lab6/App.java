package com.solodkyi.java_labs.Lab6;
public class App {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(3, 5, 10);
        cinema.initializeSeats();

        try {

			cinema.bookSeats(2, 0, new int[]{1, 4});
			cinema.bookSeats(2, 1, new int[]{0, 9});
			cinema.bookSeats(2, 2, new int[]{1, 2, 3, 6, 7});
			cinema.bookSeats(2, 3, new int[]{1, 2, 3, 7, 9});
			cinema.bookSeats(2, 4, new int[]{0, 1, 2, 3, 6, 7, 8, 9});
		} catch (UnacceptableSeatException e) {
			System.out.println(e.getMessage());
		}
        try {
			cinema.bookSeats(2, 3, new int[]{1, 4, 6});

			cinema.bookSeats(2, 4, new int[]{1, 6});
		} catch (UnacceptableSeatException e) {
			System.out.println(e.getMessage());
		}

        cinema.printSeatingArrangement(2);

        try {
        	cinema.cancelBooking(2, 3, new int[]{3, 2});
			cinema.cancelBooking(2, 3, new int[]{0, 4});
		} catch (UnacceptableSeatException e) {
			System.out.println(e.getMessage());
		}
        

        cinema.printSeatingArrangement(2);
        
        int seatsAvaible = 8;
        int checktHall = 2;
        boolean availability = cinema.checkAvailability(checktHall, seatsAvaible);
        System.out.println("Доступність " + seatsAvaible + " послідовних місць в залі " + checktHall + ": " + availability);
    }
}