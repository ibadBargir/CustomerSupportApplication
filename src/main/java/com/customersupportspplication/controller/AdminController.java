package com.customersupportspplication.controller;

import com.customersupportspplication.entity.Ticket;
import com.customersupportspplication.entity.User;
import com.customersupportspplication.service.TicketService;
import com.customersupportspplication.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    // Admin dashboard
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        User admin = (User) session.getAttribute("loggedInUser");
        if (admin == null || !admin.getRole().equals("ADMIN")) {
            return "redirect:/login"; // Prevent unauthorized access
        }
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "admin-dashboard";
    }

    // Delete user
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id, HttpSession session) {
        User admin = (User) session.getAttribute("loggedInUser");
        if (admin == null || !admin.getRole().equals("ADMIN")) {
            return "redirect:/login";
        }
        userService.deleteUser(id);
        return "redirect:/admin/dashboard";
    }

    // Delete ticket
    @GetMapping("/ticket/delete/{id}")
    public String deleteTicket(@PathVariable Long id, HttpSession session) {
        User admin = (User) session.getAttribute("loggedInUser");
        if (admin == null || !admin.getRole().equals("ADMIN")) {
            return "redirect:/login";
        }
        ticketService.deleteTicket(id);
        return "redirect:/admin/dashboard";
    }

    // Show edit ticket form
    @GetMapping("/ticket/edit/{id}")
    public String editTicket(@PathVariable Long id, Model model, HttpSession session) {
        User admin = (User) session.getAttribute("loggedInUser");
        if (admin == null || !admin.getRole().equals("ADMIN")) {
            return "redirect:/login";
        }

        Ticket ticket = ticketService.getTicketById(id);
        if (ticket == null) {
            return "redirect:/admin/dashboard"; // Ticket not found
        }

        model.addAttribute("ticket", ticket);
        return "edit-ticket"; // Thymeleaf form to edit ticket
    }

    // Update ticket
    @PostMapping("/ticket/update")
    public String updateTicket(@ModelAttribute Ticket ticket, HttpSession session) {
        User admin = (User) session.getAttribute("loggedInUser");
        if (admin == null || !admin.getRole().equals("ADMIN")) {
            return "redirect:/login";
        }

        ticketService.saveTicket(ticket); // Save updated ticket
        return "redirect:/admin/dashboard";
    }

    // Optional: Create new ticket from admin panel
    @GetMapping("/ticket/add")
    public String addTicketForm(Model model, HttpSession session) {
        User admin = (User) session.getAttribute("loggedInUser");
        if (admin == null || !admin.getRole().equals("ADMIN")) {
            return "redirect:/login";
        }

        model.addAttribute("ticket", new Ticket());
        return "add-ticket";
    }

    @PostMapping("/ticket/save")
    public String saveTicket(@ModelAttribute Ticket ticket, HttpSession session) {
        User admin = (User) session.getAttribute("loggedInUser");
        if (admin == null || !admin.getRole().equals("ADMIN")) {
            return "redirect:/login";
        }

        ticketService.saveTicket(ticket);
        return "redirect:/admin/dashboard";
    }
}
