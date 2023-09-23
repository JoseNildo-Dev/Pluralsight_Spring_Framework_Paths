package br.com.josenildo.trackzilla.service;

import br.com.josenildo.trackzilla.entity.Ticket;

public interface TicketService {
    Iterable<Ticket> listTickets();
}


