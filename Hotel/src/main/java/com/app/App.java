package com.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        ArrayList <Room> rooms = new ArrayList();
        ArrayList <Client> clients = new ArrayList();

        ReservationManager reservationManager = new ReservationManager();
        PaymentManager paymentManager = new PaymentManager();


        for(int i=0;i<5;i++){
            rooms.add(new Room(rooms.size(),300.0,3));
        }

        for(int i=0;i<5;i++){
            rooms.add(new Room(rooms.size(),320.0,4));
        }

        for(int i=0;i<5;i++){
            rooms.add(new Room(rooms.size(),340.0,5));
        }


        clients.add(new Client("Mateusz", "Skowronek",clients.size(),131244));
        clients.add(new Client("Oliwier", "Salamon",clients.size(),131322));


        boolean endOfProject=false;
        int number=0;
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("---------- Wybierz uzytkownika ---------");
            System.out.println("1. Zwykly uzytkownik");
            System.out.println("2. Administrator");
            number = sc.nextInt();
            sc.nextLine();
            System.out.println();
            switch(number){
                case 1:
                    do {
                        System.out.println("---------- Menu ---------");
                        System.out.println("1. Pokaz wszystkie pokoje");
                        System.out.println("2. Znajdz pokoj po cenie");
                        System.out.println("3. Znajdz pokoj po rozmiarze");
                        System.out.println("4. Znajdz wolny pokoj");
                        System.out.println("5. Stworz uzytkownika");
                        System.out.println("6. Dokonaj rezerwacji");
                        System.out.println("7. Dokonaj platnosci");
                        System.out.println("8. Stworz reklamacje");
                        System.out.println("9. Wyjscie");
                        System.out.print("Wybierz opcje: ");
                        number = sc.nextInt();
                        sc.nextLine();
                        System.out.println();
                        switch(number){
                            case 1:
                                if(rooms.size()>0){
                                    System.out.println("----- Wyswietlanie wszystkich pokojow -----");
                                    for(int i=0; i<rooms.size();i++){
                                        System.out.println("---------");
                                        System.out.println("Numer pokoju: "+ rooms.get(i).getRoomNumber());
                                        System.out.println("Cena pokoju: "+ rooms.get(i).getPrice());
                                        System.out.println("Rozmiar pokoju: "+ rooms.get(i).getSize());
                                    }
                                    System.out.println("---------");
                                }else {
                                    System.out.println("----- Brak pokojow w hotelu -----");
                                }
                                break;
                            case 2:
                                if(rooms.size()>0){
                                    System.out.println("----- Wyswietlanie pokoi po cenie -----");
                                    System.out.print("Podaj cene, do ktorej szukac pokoi: ");
                                    int filterPrice = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println();
                                    rooms.get(0).searchRoomPrice(rooms,filterPrice);
                                } else {
                                    System.out.println("----- Brak pokojow w hotelu -----");
                                }
                                break;
                            case 3:
                                if(rooms.size()>0){
                                    System.out.println("----- Wyswietlanie pokoi po rozmiarze -----");
                                    System.out.print("Podaj rozmiar pokoju: ");
                                    int filterSize = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println();
                                    rooms.get(0).searchRoomSize(rooms,filterSize);
                                } else {
                                    System.out.println("----- Brak pokojow w hotelu -----");
                                }
                                break;
                            case 4:
                                if(rooms.size()>0){
                                    System.out.println("----- Wyszukiwanie wolnych pokoi -----");
                                    System.out.print("Podaj dzien zakwaterowania: ");
                                    int dayIn = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Podaj miesiac zakwaterowania: ");
                                    int monthIn = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Podaj rok zakwaterowania: ");
                                    int yearIn = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Podaj dzien wykwaterowania: ");
                                    int dayOut = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Podaj miesiac wykwaterowania: ");
                                    int monthOut = sc.nextInt();
                                    sc.nextLine();
                                    System.out.print("Podaj rok wykwaterowania: ");
                                    int yearOut = sc.nextInt();
                                    sc.nextLine();

                                    Date checkIn = new Date(yearIn, monthIn, dayIn);
                                    Date checkOut = new Date(yearOut, monthOut, dayOut);


                                    rooms.get(0).searchFreeRoom(rooms,checkIn,checkOut);
                                }
                                break;
                            case 5:
                                String firstName,lastName;
                                int phoneNumber;
                                System.out.println("----- Tworzenie uzytkownika -----");
                                System.out.print("Podaj imię: ");
                                firstName= sc.nextLine();
                                System.out.println();

                                System.out.print("Podaj nazwisko: ");
                                lastName= sc.nextLine();
                                System.out.println();

                                System.out.print("Podaj numer: ");
                                phoneNumber= sc.nextInt();
                                sc.nextLine();
                                System.out.println();

                                clients.add(new Client(firstName,lastName,clients.size(),phoneNumber));

                                System.out.println("Uzytkownik zostal stworzony.");
                                break;


                            case 6:
                                if(clients.size()>0 && rooms.size()>0){
                                    System.out.println("----- Rezerwacja pokoju -----");
                                    boolean reserve=true;
                                    int reservationRoomNumber;
                                    do{
                                        System.out.print("Podaj numer pokoju: ");
                                        reservationRoomNumber = sc.nextInt();
                                        sc.nextLine();
                                        for(int i=0;i<rooms.size();i++){
                                            if(rooms.get(i).getRoomNumber()==reservationRoomNumber){
                                                reserve=false;
                                            }
                                        }
                                    }while(reserve);
                                    Date checkIn, checkOut;

                                    do{
                                        System.out.print("Podaj dzien zakwaterowania: ");
                                        int dayIn = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Podaj miesiac zakwaterowania: ");
                                        int monthIn = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Podaj rok zakwaterowania: ");
                                        int yearIn = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Podaj dzien wykwaterowania: ");
                                        int dayOut = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Podaj miesiac wykwaterowania: ");
                                        int monthOut = sc.nextInt();
                                        sc.nextLine();
                                        System.out.print("Podaj rok wykwaterowania: ");
                                        int yearOut = sc.nextInt();
                                        sc.nextLine();

                                        checkIn = new Date(yearIn, monthIn, dayIn);
                                        checkOut = new Date(yearOut, monthOut, dayOut);
                                    }while(checkOut.before(checkIn));

                                    System.out.println("Dokonuje rezerwacji...");
                                    if(clients.get(0).addReservation(rooms, checkIn, checkOut, reservationRoomNumber)){
                                        System.out.println("Rezerwacja zostala pomyslnie zrealizowana.");
                                    } else {
                                        System.out.println("Rezerwacja nie powiodla sie!");
                                    }
                                } else {
                                    if(rooms.size()>0){
                                        System.out.println("Stworz klienta!");
                                    } else {
                                        System.out.println("Stworz pokoj!");
                                    }
                                }
                                break;
                            case 7:
                                if(clients.size()>0 && rooms.size()>0){
                                    clients.get(0).makePayment();
                                }
                                break;
                            case 8:
                                if(clients.size()>0){
                                    System.out.println("----- Tworzenie reklamacji -----");
                                    clients.get(0).makeComplaint();
                                }
                                break;
                            default:
                                endOfProject=true;
                                break;

                        }



                    }while(!endOfProject);
                    endOfProject=false;
                    break;
                case 2:
                    do{
                        System.out.println("---------- Menu ---------");
                        System.out.println("1. Dodaj pokoj");
                        System.out.println("2. Edytuj pokoj");
                        System.out.println("3. Usun pokoj");
                        System.out.println("4. Wyswietl wszystkich uzytkownikow");
                        System.out.println("5. Wyjscie z programu");
                        System.out.print("Wybierz opcje: ");
                        number = sc.nextInt();
                        sc.nextLine();
                        System.out.println();

                        switch(number){
                            case 1:
                                int newRoomSize, newRoomPrice, newRoomNumber;
                                System.out.println("----- Dodawanie pokoju -----");
                                System.out.print("Podaj cene pokoju: ");
                                newRoomPrice=sc.nextInt();
                                sc.nextLine();
                                System.out.println();
                                System.out.print("Podaj rozmiar pokoju: ");
                                newRoomSize=sc.nextInt();
                                sc.nextLine();
                                System.out.println();
                                boolean checkNumber;
                                do{
                                    checkNumber=true;
                                    System.out.print("Podaj numer pokoju: ");
                                    newRoomNumber=sc.nextInt();
                                    sc.nextLine();
                                    for(int i=0;i<rooms.size();i++){
                                        if(rooms.get(i).getRoomNumber()==newRoomNumber){
                                            System.out.println("Podany numer pokoju juz istnieje..");
                                            checkNumber=false;
                                        }
                                    }
                                }while(!checkNumber);
                                Room room = new Room();
                                rooms.add(room.addRoom(newRoomNumber,newRoomPrice,newRoomSize));
                                System.out.println("Dodales pokoj.");
                                System.out.println("Numer: "+rooms.get(rooms.size()-1).getRoomNumber());
                                System.out.println("Rozmiar: "+rooms.get(rooms.size()-1).getSize());
                                System.out.println("Cena: "+rooms.get(rooms.size()-1).getPrice());

                                break;
                            case 2:
                                int roomNumber;
                                System.out.println("----- Edycja pokoju -----");
                                if(rooms.size()>0){
                                    String newNumber,newPrice,newSize;
                                    System.out.print("Podaj numer pokoju, ktory chcesz edytowac: ");
                                    roomNumber=sc.nextInt();
                                    sc.nextLine();
                                    boolean check=false;
                                    for(int i=0;i<rooms.size();i++){
                                        if(rooms.get(i).getRoomNumber()==roomNumber){
                                            check=true;
                                        }
                                    }

                                    if(check){
                                        do{
                                            check=false;
                                            System.out.print("Nowy numer pokoju: ");
                                            newNumber = sc.nextLine();
                                            System.out.println();
                                            for(int i=0;i<rooms.size();i++){
                                                if(rooms.get(i).getRoomNumber()== Integer.parseInt(newNumber)){
                                                    System.out.println("Podany numer juz istnieje..");
                                                    i=rooms.size();
                                                    System.out.println("Podaj nowy numer..");
                                                    check=true;
                                                }
                                            }
                                        }while (check);

                                        System.out.print("Nowa cena pokoju: ");
                                        newPrice = sc.nextLine();
                                        System.out.println();
                                        System.out.print("Nowy rozmiar pokoju: ");
                                        newSize = sc.nextLine();
                                        System.out.println();
                                        String []data={newNumber,newPrice,newSize};
                                        for(int i=0;i<rooms.size();i++){
                                            if(rooms.get(i).getRoomNumber()==roomNumber){
                                                rooms.get(i).editRoom(data,rooms);
                                                i=rooms.size();
                                            }
                                        }

                                    } else {
                                        System.out.println("Nie ma takiego pokoju...");
                                    }

                                } else {
                                    System.out.println("Stworz najpierw pokoje...");
                                }


                                break;

                            case 3:
                                System.out.println("----- Usuwanie pokoju -----");
                                boolean check=true;
                                int deleteNumber;
                                do{
                                    System.out.print("Podaj numer pokoju do usuniecia: ");
                                    deleteNumber = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println();
                                    for(int i=0;i<rooms.size();i++){
                                        if(rooms.get(i).getRoomNumber() == deleteNumber){
                                            System.out.println("Usuwam pokoj..");
                                            rooms.get(i).deleteRoom(rooms,deleteNumber);
                                            System.out.println("Pokoj zostal usuniety.");
                                            check=false;
                                        }
                                    }
                                    if(check){
                                        System.out.println("Podales zly numer...");
                                    }
                                }while (check);
                                break;
                            case 4:
                                if(clients.size()>0){
                                    System.out.println("----- Wyswietlanie uzytkownikow -----");
                                    for(int i=0;i<clients.size();i++){
                                        System.out.println("---------");
                                        System.out.println("Imie klienta: "+ clients.get(i).getFirstName());
                                        System.out.println("Nazwisko klienta: "+ clients.get(i).getLastName());
                                        System.out.println("ID klienta : "+ clients.get(i).getId());
                                        System.out.println("Numer telefonu klienta : "+ clients.get(i).getPhoneNumber());
                                    }
                                    System.out.println("---------");
                                } else {
                                    System.out.println("Brak klientow.");
                                }
                                break;

                            default:
                                endOfProject=true;
                                break;
                        }

                    }while(!endOfProject);
                    endOfProject=false;
                    break;
                default:
                    endOfProject=true;
                    break;
            }

        }while(!endOfProject);
    }
}