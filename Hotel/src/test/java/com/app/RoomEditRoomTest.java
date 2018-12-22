package com.app;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.ArrayList;

import static org.junit.Assert.*;

// klasa do testowania scenariuszy metody editRoom klasy Room
public class RoomEditRoomTest {
    ArrayList<Room> rooms = new ArrayList();

    @Before
    public void setUp(){
        for(int i=0;i<5;i++){
            rooms.add(new Room(rooms.size(),300.0,3));
        }
    }


    @Test
    public void editRoom(){
        String [] newData = {"33","340","5"};
        assertTrue(rooms.get(0).editRoom(newData,rooms));
        assertEquals(33,rooms.get(0).getRoomNumber());
        assertEquals(340,rooms.get(0).getPrice(),0);
        assertEquals(5,rooms.get(0).getSize());

    }

    @Test
    public void editRoomWithWrongRoomNumber(){
        String [] newData = {"3","340","5"};
        assertFalse(rooms.get(0).editRoom(newData,rooms));
        assertEquals(0,rooms.get(0).getRoomNumber());
        assertEquals(300,rooms.get(0).getPrice(),0);
        assertEquals(3,rooms.get(0).getSize());

    }


    @Test
    public void editRoomWithWrongPrice(){
        String [] newData = {"3","-340","5"};
        assertFalse(rooms.get(0).editRoom(newData,rooms));
        assertEquals(0,rooms.get(0).getRoomNumber());
        assertEquals(300,rooms.get(0).getPrice(),0);
        assertEquals(3,rooms.get(0).getSize());
    }

    @Test
    public void editRoomWithWrongSize(){
        String [] newData = {"3","340","-5"};
        assertFalse(rooms.get(0).editRoom(newData,rooms));
        assertEquals(0,rooms.get(0).getRoomNumber());
        assertEquals(300,rooms.get(0).getPrice(),0);
        assertEquals(3,rooms.get(0).getSize());
    }


}