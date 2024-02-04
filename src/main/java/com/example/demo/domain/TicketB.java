package com.example.demo.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class TicketB extends Ticket{
    @Enumerated(EnumType.STRING)
    StatusTicketB statusTicketB;
    public TicketB(){
        super();
        System.out.println("Ticket B");
    }

    public StatusTicketB getStatusTicketB() {
        return statusTicketB;
    }

    public void setStatusTicketB(StatusTicketB statusTicketB) {
        this.statusTicketB = statusTicketB;
    }

    @Override
    public String toString() {
        return "TicketB{" +
                "ticketNumberB=" + getTicketNumber() +
                "statusTicketB=" + statusTicketB +
                '}';
    }
}
