package br.com.josenildo.conferencedemo.repositories;

import br.com.josenildo.conferencedemo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}