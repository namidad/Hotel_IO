package com.app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;


// klasa do testowania sceanriuszy metody makePayment klasy Client
public class ClientMakePaymentTest {
    Client client = new Client("Oliwier", "Salamon",0,667991766);

    ArrayList<Room> rooms = new ArrayList();

    @Before
    public void setUp(){
        for(int i=0;i<5;i++){
            rooms.add(new Room(rooms.size(),300.0,3));
        }
    }

    @Test
    public  void makePaymentWithOutReservation() {
        assertFalse(client.makePayment());
    }

    @Test
    public void makePaymentWithReservationPaid(){

        Date checkIn = new Date(2018, 12, 20);
        Date checkOut = new Date(2018, 12, 24);
        client.addReservation(rooms, checkIn, checkOut, 3);
        client.reservations.get(0).setPaid(true);
        assertFalse(client.makePayment());
    }

    @Test
    public void makePaymentWithReservationNotPaid(){

        Date checkIn = new Date(2018, 12, 20);
        Date checkOut = new Date(2018, 12, 24);
        client.addReservation(rooms, checkIn, checkOut, 3);
        assertTrue(client.makePayment());
    }




}