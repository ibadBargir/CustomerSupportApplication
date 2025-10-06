package com.customersupportspplication.repository;

import com.customersupportspplication.entity.Ticket;
import com.customersupportspplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    List<Ticket> findByEmail(String email);
}
