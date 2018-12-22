package com.app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class ReservationManagerIsRoomFreeTest {
    ArrayList<Room> rooms = new ArrayList();
    ReservationManager res = new ReservationManager();


    @Before
    public void setUp(){
        for(int i=0;i<5;i++){
            rooms.add(new Room(rooms.size(),300.0,3));
        }
    }


    @Test
    public void isRoomFreeTrue(){
        Date checkIn = new Date(2018, 12, 20);
        Date checkOut = new Date(2018, 12, 24);
        assertTrue(res.isRoomFree(rooms,2,checkIn,checkOut));
    }

    @Test
    public void isRoomFreeFalse(){
        Date checkIn = new Date(2018, 12, 20);
        Date checkOut = new Date(2018, 12, 24);
        assertTrue(res.isRoomFree(rooms,2,checkIn,checkOut));
    }

    @Test
    public void isRoomFreePriceCheck(){
        Date checkIn = new Date(2018, 12, 20);
        Date checkOut = new Date(2018, 12, 24);
        res.isRoomFree(rooms,2,checkIn,checkOut);
        assertEquals(1200.0,res.getPriceForReservation(),0);
    }

    @Test
    public void isRoomFreePaidCheckFalse(){
        Date checkIn = new Date(2018, 12, 20);
        Date checkOut = new Date(2018, 12, 24);
        res.isRoomFree(rooms,2,checkIn,checkOut);
        assertEquals(false, res.isPaid());
    }

    @Test
    public void isRoomFreePaidCheckTrue(){
        Date checkIn = new Date(2018, 12, 20);
        Date checkOut = new Date(2018, 12, 24);
        res.isRoomFree(rooms,2,checkIn,checkOut);
        assertEquals(false, res.isPaid());
        res.setPaid(true);
        assertEquals(true, res.isPaid());
    }
}