package br.com.josenildo.trackzilla.service;

import br.com.josenildo.trackzilla.entity.Ticket;
import br.com.josenildo.trackzilla.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public Iterable<Ticket> listTickets() {
        return ticketRepository.findAll();
    }

}
