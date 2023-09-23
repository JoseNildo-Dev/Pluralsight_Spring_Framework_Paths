package br.com.josenildo.repository.impl;

import br.com.josenildo.model.Speaker;
import br.com.josenildo.repository.SpeakerRepository;

import java.util.ArrayList;
import java.util.List;

public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {
    
    @Override
    public List<Speaker> findAll() {
        List<Speaker> speakers = new ArrayList<>();
        Speaker speaker = new Speaker();
        
        speaker.setFirstName("Steven");
        speaker.setLastName("D'Hondt");
        
        speakers.add(speaker);
        
        return speakers;
    }
}