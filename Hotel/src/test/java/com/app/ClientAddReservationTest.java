package com.app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

// klasa do testowania scenariuszy metody addReservation klasy Client
public class ClientAddReservationTest {

    Client client = new Client("Oliwier", "Salamon",0,667991766);

    ArrayList<Room> rooms = new ArrayList();
    Date checkIn = new Date(2018, 12, 20);
    Date checkOut = new Date(2018, 12, 24);

    @Before
    public void setUp(){
        for(int i=0;i<5;i++){
            rooms.add(new Room(rooms.size(),300.0,3));
        }

    }

    @Test
    public void addReservationWithWrongRoomNumber(){
        assertFalse(client.addReservation(rooms, checkIn, checkOut, 55));
    }

    @Test
    public void addReservationWithGoodRoomNumber(){

        assertTrue(client.addReservation(rooms, checkIn, checkOut, 3));
    }


    @Test
    public void addReservationWithWrongDate(){

        Date checkIn = new Date(2018, 12, 20);
        Date checkOut = new Date(2018, 12, 18);

        assertFalse(client.addReservation(rooms, checkIn, checkOut, 3));
    }

    @Test
    public void addReservationWithGoodDate(){

        assertTrue(client.addReservation(rooms, checkIn, checkOut, 3));
    }

    @Test
    public void addReservationWithOutRooms(){
        ArrayList<Room> rooms2 = new ArrayList();
        assertFalse(client.addReservation(rooms2, checkIn, checkOut, 3));
    }


    @Test
    public void addReservationWithExistedDate(){

        rooms.get(3).getCheckIn().add(checkIn);
        rooms.get(3).getCheckOut().add(checkOut);

        assertFalse(client.addReservation(rooms, checkIn, checkOut, 3));
    }


}