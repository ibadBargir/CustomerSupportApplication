package com.customersupportspplication.service;

import com.customersupportspplication.entity.Ticket;
import com.customersupportspplication.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public List<Ticket> getTicketsByEmail(String email){
        return ticketRepository.findByEmail(email);
    }

    public void saveTicket(Ticket ticket){
        ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id){
        ticketRepository.deleteById(id);
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id).orElse(null);
    }
}