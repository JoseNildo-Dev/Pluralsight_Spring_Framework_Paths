package br.com.josenildo.repository;

import br.com.josenildo.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();
}