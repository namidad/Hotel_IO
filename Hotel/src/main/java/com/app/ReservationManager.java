package com.app;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class ReservationManager {

    private double priceForReservation;
    private boolean paid = false;
    private boolean acceptedReservation;


    public boolean isRoomFree(ArrayList<Room> rooms, int roomNumber,Date checkIn, Date checkOut){

        boolean isFree=true;
        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i).getRoomNumber()==roomNumber){
                for(int j=0;j<rooms.get(i).getCheckIn().size();j++){
                    if( (checkIn.before(rooms.get(i).getCheckIn().get(j))
                            && checkOut.before(rooms.get(i).getCheckIn().get(j)) )
                            || (checkIn.after(rooms.get(i).getCheckOut().get(j))
                            && checkOut.after(rooms.get(i).getCheckOut().get(j)))
                    ){
                        isFree=true;
                    } else {
                        j=rooms.get(i).getCheckIn().size();
                        isFree=false;
                    }
                }
            }
        }



        if(isFree){
            System.out.println("Jest wolny pokoj w tym terminie.");
            addReservation(rooms,roomNumber,checkIn,checkOut);
            System.out.println("Rezerwacja zostala utworzona.");
            return true;
        } else {
            System.out.println("Nie ma wolnego pokoju w tym terminie.");
            acceptedReservation=false;
            return false;
        }

    }

    public void addReservation(ArrayList<Room> rooms, int roomNumber,Date checkIn, Date checkOut){

            for(int i=0;i<rooms.size();i++){
                if(rooms.get(i).getRoomNumber()==roomNumber){

                    rooms.get(i).getCheckIn().add(checkIn);
                    rooms.get(i).getCheckOut().add(checkOut);

                    long diff = checkOut.getTime()-checkIn.getTime();

                    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

                    priceForReservation = rooms.get(i).getPrice()*days;
                    System.out.println("Kwota do zaplaty za rezerwacje: "+priceForReservation);
                    acceptedReservation=true;
                }
            }
    }

}
