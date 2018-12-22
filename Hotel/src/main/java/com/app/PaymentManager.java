package com.app;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PaymentManager {
    private boolean paid;
    private boolean returned;

    public boolean acceptedPayment(double price, double paidReservation){

        if(this.paid){
            return false;
        }

        if(price == paidReservation){
            System.out.println("----- Manager platnosci -----");
            System.out.println("Platnosc zostala przyjeta.");
            paid=true;
            return true;
        } else {
            System.out.println("----- Manager platnosci -----");
            System.out.println("Platnosc zostala odrzucona.");
            paid = false;
            return false;
        }
    }

    public String refund(double price){
        System.out.println("----- Manager platnosci -----");
        System.out.println("----- Oddaje "+price+" zl za rezerwacje -----");
        returned=true;
    return "Pieniadze zostaly zwrocone.";
    }

}
