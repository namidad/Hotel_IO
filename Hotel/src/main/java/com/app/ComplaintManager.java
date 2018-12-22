package com.app;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor

public class ComplaintManager {

    private boolean accepted;

    public boolean consideration (String message) {
        System.out.println("----- Manager reklamacji -----");
        System.out.println("Tresc reklamacji:");
        System.out.println(message);
        System.out.print("Czy zatwierdzasz rezerwacje? t/n : ");
        Scanner sc = new Scanner(System.in);
        String choice=sc.nextLine();
        System.out.println();
        if(choice.equals("t")){
            accepted=true;
            return true;
        } else {
            accepted=false;
            return false;
        }
    }

}
