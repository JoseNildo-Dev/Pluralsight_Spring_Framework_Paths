package br.com.josenildo.service;

import br.com.josenildo.model.Speaker;

import java.util.List;

public interface SpeakerService {
    List<Speaker> findAll();
}