package com.app;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor

public class Client {
    private String firstName, lastName;
    private int id, phoneNumber;
    ArrayList <ReservationManager> reservations = new ArrayList();
    ArrayList <ComplaintManager> complaints = new ArrayList();
    ArrayList <PaymentManager> payments = new ArrayList();


    public Client (String first, String last, int clientId, int phone){
        firstName=first;
        lastName=last;
        id=clientId;
        phoneNumber=phone;

    }

    public boolean makePayment(){

        boolean check=false;
        if(reservations.size()>0){
            for(int i=0;i<reservations.size();i++){
                if(reservations.get(i).isAcceptedReservation() && reservations.get(i).isPaid()==false){
                    System.out.println("Za rezerwacje wyszlo: "+ reservations.get(i).getPriceForReservation());
                    System.out.print("Zaplac za rezerwacje: ");
                    //Scanner sc = new Scanner(System.in);
                   // double x = sc.nextDouble();
                   // sc.nextLine();

                    if(payments.get(i).acceptedPayment(reservations.get(i).getPriceForReservation(), reservations.get(i).getPriceForReservation())){
                        reservations.get(i).setPaid(true);
                        System.out.println("Rezerwacja oplacona.");
                        return true;
                    } else {
                        reservations.get(i).setPaid(false);
                        System.out.println("Bledna kwota za rezerwacje");
                    }
                }
            }

        }

        System.out.println("Brak rezerwacji.");
        return false;
    }


    public boolean addReservation (ArrayList <Room> rooms, Date checkIn, Date checkOut, int roomNumber){

        reservations.add(new ReservationManager());
        payments.add(new PaymentManager());
        complaints.add(new ComplaintManager());

        boolean check=false;

        for(int i=0;i<rooms.size();i++){
            if(rooms.get(i).getRoomNumber()==roomNumber){
                check = true;
            }
        }

        if(!check){
            return false;
        }

        if(checkOut.before(checkIn)){
            return false;
        }

        if(rooms.size()<=0){
            return false;
        }

        if(reservations.get(reservations.size()-1).isRoomFree(rooms, roomNumber ,checkIn, checkOut)){
            return true;
        } else {
            return false;
        }


    }

    public void makeComplaint (){
        if(reservations.size()>0){
            if(reservations.get(0).isPaid()){
                Scanner sc=new Scanner(System.in);
                System.out.println("Podaj tresc reklamacji: ");
                String complaintMessage = sc.nextLine();

                if(complaints.get(0).consideration(complaintMessage)){
                    System.out.println("---- Wiadomosc od managera reklamacji -----");
                    System.out.println("Reklamacja zostala przyjeta.");
                    System.out.println("Pieniadze zostana zwrocone na konto.");
                    System.out.println(payments.get(0).refund(reservations.get(0).getPriceForReservation()));

                } else {
                    System.out.println("---- Wiadomosc od managera reklamacji -----");
                    System.out.println("Reklamacja zostala odrzucona.");
                }
            } else {
                System.out.println("Rezerwacja nie zostala oplacona.");
            }

        } else {
            System.out.println("Brak rezerwacji.");
        }



    }


}
