package com.example.demo.domain;

import jakarta.persistence.Embeddable;

@Embeddable
public class TicketA extends Ticket{

    public TicketA(){
        super();
        System.out.println("Ticket A");
    }

    @Override
    public String toString() {
        return "TicketA{" +
                "ticketNumberA=" + getTicketNumber() + "}";
    }
}
