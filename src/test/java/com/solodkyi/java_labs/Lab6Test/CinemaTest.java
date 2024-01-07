package com.solodkyi.java_labs.Lab6Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.solodkyi.java_labs.Lab6.*;

public class CinemaTest {
    private Cinema cinema;

    @BeforeEach
    void setUp() {
        cinema = new Cinema(3, 6, 10);
    }


    @Test
    void testCinemaSeatsInit() {
        cinema.initializeSeats();        
        assertEquals(0,cinema.getSeatingArrangement()[2][5][9]);
    }

    @Test
    void testBookSeats() throws UnacceptableSeatException{
        cinema.initializeSeats();

        cinema.bookSeats(0, 0, new int[]{0, 1});

        assertEquals(1, cinema.getSeatingArrangement()[0][0][0]);
        assertEquals(1, cinema.getSeatingArrangement()[0][0][1]);
    }

    @Test
    void testBookBookingSeats() throws UnacceptableSeatException{
        cinema.initializeSeats();
        cinema.bookSeats(0, 1, new int[]{1, 2, 3});
        assertThrows(UnacceptableSeatException.class, () -> cinema.bookSeats(0, 1, new int[]{1, 2}));
    }

    @Test
    void testCancelBooking() throws UnacceptableSeatException{
        cinema.initializeSeats();
        cinema.bookSeats(1, 3, new int[]{4, 5, 6});

        assertTrue(cinema.cancelBooking(1, 3, new int[]{5, 6}));
    }
    @Test
    void testCancelUnBookedSeats() throws UnacceptableSeatException{
    	cinema.initializeSeats();
        cinema.bookSeats(1, 3, new int[]{4, 5, 6});
        assertThrows(UnacceptableSeatException.class, () -> cinema.cancelBooking(1, 4, new int[]{1, 2, 3}));
    }
}
