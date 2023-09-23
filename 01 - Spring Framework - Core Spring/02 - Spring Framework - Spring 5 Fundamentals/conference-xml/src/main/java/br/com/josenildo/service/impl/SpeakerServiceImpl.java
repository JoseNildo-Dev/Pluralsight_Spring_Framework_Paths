package br.com.josenildo.service.impl;

import br.com.josenildo.model.Speaker;
import br.com.josenildo.repository.SpeakerRepository;
import br.com.josenildo.repository.impl.HibernateSpeakerRepositoryImpl;
import br.com.josenildo.service.SpeakerService;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {
    
    private SpeakerRepository repo;

    public SpeakerServiceImpl() {
    }

    public SpeakerServiceImpl(SpeakerRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Speaker> findAll(){
        return repo.findAll();
    }

    public void setSpeakerRepository(SpeakerRepository repo) {
        this.repo = repo;
    }
}