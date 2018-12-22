package com.app;

import org.junit.Test;

import static org.junit.Assert.*;

// klasa do testowania scenariuszy metody acceptedPayment klasy PaymentManager
public class PaymentManagerAcceptedPaymentTest {
    PaymentManager payment = new PaymentManager();

    @Test
    public void acceptedPayment() {
        assertTrue(payment.acceptedPayment(300,300));
    }

    @Test
    public void acceptedPaymentWithWrongPrice() {
        assertFalse(payment.acceptedPayment(300,100));
    }

    @Test
    public void acceptedPaymentWithPaidReservation() {
        payment.setPaid(true);
        assertFalse(payment.acceptedPayment(300,100));
    }

}