package com.customersupportspplication.controller;

import com.customersupportspplication.entity.Ticket;
import com.customersupportspplication.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    private final TicketService ticketService;

    @Autowired
    public MainController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/tickets")
    public String viewTickets(Model model) {
        List<Ticket> tickets = ticketService.getAllTickets();
        model.addAttribute("tickets", tickets);
        return "tickets";
    }

    @GetMapping("/add-ticket")
    public String addTicketForm(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "add-ticket";
    }

    @PostMapping("/save-ticket")
    public String saveTicket(@ModelAttribute Ticket ticket) {
        ticketService.saveTicket(ticket);
        return "redirect:/tickets";
    }
}
