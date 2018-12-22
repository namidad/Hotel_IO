package com.app;

import java.util.ArrayList;
import java.util.Date;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Room {
    private int roomNumber;
    private double price;
    private int size;
    private ArrayList<Date> checkIn = new ArrayList();
    private ArrayList<Date> checkOut = new ArrayList();

    public Room(int roomN, double roomPrice, int roomSize) {
        roomNumber = roomN;
        price = roomPrice;
        size = roomSize;
    }

    public Room addRoom (int roomN, double roomPrice, int roomSize){
        Room room=new Room();
        room.setRoomNumber(roomN);
        room.setSize(roomSize);
        room.setPrice(roomPrice);
        return room;
    }



    public boolean deleteRoom(ArrayList<Room> rooms, int roomNumber) {

        if(rooms.size()<=0){
            return false;
        }


        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getRoomNumber() == roomNumber) {
                rooms.remove(i);
                return true;
            }
        }
        return false;
    }



    public boolean editRoom(String[] data,ArrayList<Room> rooms) {

        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i).getRoomNumber()==Integer.parseInt(data[0])){
                return false;
            }
        }

        if(Integer.parseInt(data[0])<0){
            return false;
        }


        if(Double.parseDouble(data[1])<0){
            return false;
        }

        if(Integer.parseInt(data[2])<0){
            return false;
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i] != "") {
                if (i == 0) {
                    this.setRoomNumber(Integer.parseInt(data[i]));
                } else if (i == 1) {
                    this.setPrice(Double.parseDouble(data[i]));
                } else {
                    this.setSize(Integer.parseInt(data[i]));
                }
            }
        }
        return true;
    }


    public void searchRoomSize(ArrayList<Room> rooms, int size) {
        boolean avaiable = false;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getSize() == size) {
                System.out.println("---------");
                System.out.println("Numer pokoju: " + rooms.get(i).getRoomNumber());
                System.out.println("Cena pokoju: " + rooms.get(i).getPrice());
                System.out.println("Rozmiar pokoju: " + rooms.get(i).getSize());
                avaiable = true;
            }
        }

        if (!avaiable) {
            System.out.println("Brak pokoju o podanej wielkosci...");
        }

    }

    public void searchRoomPrice(ArrayList<Room> rooms, int price) {
        boolean avaiable = false;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).getPrice() <= price) {
                System.out.println("---------");
                System.out.println("Numer pokoju: " + rooms.get(i).getRoomNumber());
                System.out.println("Cena pokoju: " + rooms.get(i).getPrice());
                System.out.println("Rozmiar pokoju: " + rooms.get(i).getSize());
                avaiable = true;
            }
        }

        if (!avaiable) {
            System.out.println("Brak pokoju o podanej cenie...");
        }

    }

    public void searchFreeRoom(ArrayList<Room> rooms, Date dateIn, Date dateOut) {

        boolean isFree = true;
        for (int i = 0; i < rooms.size(); i++) {
                for (int j = 0; j < rooms.get(i).getCheckIn().size(); j++) {
                    if ((dateIn.before(rooms.get(i).getCheckIn().get(j))
                            && dateOut.before(rooms.get(i).getCheckIn().get(j)))
                            || (dateIn.after(rooms.get(i).getCheckOut().get(j))
                            && dateOut.after(rooms.get(i).getCheckOut().get(j)))
                    ) {
                        isFree = true;
                    } else {
                        j = rooms.get(i).getCheckIn().size();
                        isFree = false;
                    }
                }
                if(isFree){
                    System.out.println("----- Znaleziono pokoj -----");
                    System.out.println("Numer pokoju:" + rooms.get(i).getRoomNumber());
                    System.out.println("Rozmiar pokoju:" + rooms.get(i).getSize());
                    System.out.println("Cena pokoju:" + rooms.get(i).getPrice());
                    System.out.println();

                }
            }
    }

}
