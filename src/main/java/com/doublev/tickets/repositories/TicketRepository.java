package com.doublev.tickets.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doublev.tickets.entities.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
    
}