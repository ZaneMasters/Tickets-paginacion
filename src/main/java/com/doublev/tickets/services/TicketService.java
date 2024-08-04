package com.doublev.tickets.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.doublev.tickets.entities.Ticket;
import com.doublev.tickets.repositories.TicketRepository;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(Ticket ticket) {
        ticket.setFechaCreacion(LocalDateTime.now());
        ticket.setFechaActualizacion(LocalDateTime.now());
        return ticketRepository.save(ticket);
    }

    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public Page<Ticket> getAllTickets(PageRequest pageRequest) {
        List<Ticket> tickets = (List<Ticket>) ticketRepository.findAll();
        int total = tickets.size();
        int start = Math.min((int) pageRequest.getOffset(), total);
        int end = Math.min((start + pageRequest.getPageSize()), total);
        return new PageImpl<>(tickets.subList(start, end), pageRequest, total);
    }

    public Ticket updateTicket(Long id, Ticket updatedTicket) {
        return ticketRepository.findById(id).map(ticket -> {
            ticket.setUsuario(updatedTicket.getUsuario());
            ticket.setFechaActualizacion(LocalDateTime.now());
            ticket.setEstatus(updatedTicket.getEstatus());
            return ticketRepository.save(ticket);
        }).orElseThrow();
    }

    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}