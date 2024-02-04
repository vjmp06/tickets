package com.example.demo.controller;

import com.example.demo.domain.Ticket;
import com.example.demo.domain.TicketA;
import com.example.demo.domain.TicketB;

import java.util.List;

public class ScheduleDTO {
    private List<Ticket> ticketsA;
    private List<Ticket> ticketsB;

    public List<Ticket> getTicketsA() {
        return ticketsA;
    }

    public void setTicketsA(List<Ticket> ticketsA) {
        this.ticketsA = ticketsA;
    }

    public List<Ticket> getTicketsB() {
        return ticketsB;
    }

    public void setTicketsB(List<Ticket> ticketsB) {
        this.ticketsB = ticketsB;
    }
}
