package com.app;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

// klasa do testowania scenariuszy metody deleteRoom klasy Room

public class RoomDeleteRoomTest {
    ArrayList<Room> rooms = new ArrayList();

    @Before
    public void setUp(){
        for(int i=0;i<5;i++){
            rooms.add(new Room(rooms.size(),300.0,3));
        }
    }

    @Test
    public void deleteRoom(){
        assertEquals(5,rooms.size());
        assertTrue(rooms.get(0).deleteRoom(rooms,0));
        assertEquals(4,rooms.size());
    }

    @Test
    public void deleteRoomWithWrongRoomNumber(){
        assertEquals(5,rooms.size());
        assertFalse(rooms.get(0).deleteRoom(rooms,33));
        assertEquals(5,rooms.size());
    }
}