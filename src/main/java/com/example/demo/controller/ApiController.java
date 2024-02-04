package com.example.demo.controller;

import com.example.demo.domain.StatusTicketB;
import com.example.demo.domain.Ticket;
import com.example.demo.domain.TicketA;
import com.example.demo.domain.TicketB;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/teste")
@RestController
public class ApiController {


    @PostMapping
    public ScheduleDTO processarTickets(@RequestBody String ticketsTexto) {
        var tickets = gerarTickets(ticketsTexto);
        var scheduleDTO = new ScheduleDTO();
        scheduleDTO.setTicketsA(ticketsA(tickets));
        scheduleDTO.setTicketsB(ticketsB(tickets));
        return scheduleDTO;
    }

    private List<Ticket> gerarTickets(String ticketsTexto) {
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

    private <T extends Ticket> T createTicket(String texto, Class<T> type) {
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

    private List<Ticket> ticketsA(List<Ticket> tickets) {
        return tickets.stream().filter(ticket -> ticket instanceof TicketA).collect(Collectors.toList());
    }

    private List<Ticket> ticketsB(List<Ticket> tickets) {
        return tickets.stream().filter(ticket -> ticket instanceof TicketB).collect(Collectors.toList());
    }
}
