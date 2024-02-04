package com.example.demo;

import com.example.demo.domain.StatusTicketB;
import com.example.demo.domain.Ticket;
import com.example.demo.domain.TicketA;
import com.example.demo.domain.TicketB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        gerarTickets("B1UNKONW,A1").forEach(ticket -> System.out.println(ticket));
    }

    public static List<Ticket> gerarTickets(String ticketsTexto) {
        List<Ticket> tickets = new ArrayList<>();
        List<String> ticketsTextoAux = Arrays.asList(ticketsTexto.split(","));
        for (String ticketTexto : ticketsTextoAux) {
            if (ticketTexto.contains("UNKONW")) {
                tickets.add(createTicket(ticketTexto, TicketB.class));
            } else {
                tickets.add(createTicket(ticketTexto, TicketA.class));
            }
        }
        return tickets;
    }

    public static <T extends Ticket> T createTicket(String texto, Class<T> type) {
        if (type.equals(TicketA.class)) {
            var ticket = new TicketA();
            ticket.setTicketNumber(1L);
            return type.cast(ticket);
        }
        if (type.equals(TicketB.class)) {
            var ticket = new TicketB();
            ticket.setTicketNumber(1L);
            ticket.setStatusTicketB(StatusTicketB.UNKNOW);
            return type.cast(ticket);
        }
        throw new RuntimeException("Falha ao serializar ticket");
    }
}
