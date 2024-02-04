package com.example.demo.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

public abstract class Ticket {
    private Long ticketNumber;

    public Long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                '}';
    }
}
