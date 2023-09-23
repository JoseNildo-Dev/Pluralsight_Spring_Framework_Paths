package br.com.josenildo.trackzilla.repository;

import br.com.josenildo.trackzilla.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
