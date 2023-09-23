package br.com.josenildo.conferencedemo.repositories;

import br.com.josenildo.conferencedemo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}