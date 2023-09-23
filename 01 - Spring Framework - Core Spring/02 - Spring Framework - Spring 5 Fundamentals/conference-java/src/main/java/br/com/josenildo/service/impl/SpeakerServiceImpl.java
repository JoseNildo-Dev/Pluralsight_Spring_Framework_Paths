package br.com.josenildo.service.impl;

import br.com.josenildo.model.Speaker;
import br.com.josenildo.repository.SpeakerRepository;
import br.com.josenildo.service.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service("speakerService")
@Profile("dev")
public class SpeakerServiceImpl implements SpeakerService {
    
    private SpeakerRepository repo;

    public SpeakerServiceImpl() {
        System.out.println("SpeakerServiceImpl no args constructor");
    }

    public SpeakerServiceImpl(SpeakerRepository repo) {
        System.out.println("SpeakerServiceImpl repository constructor");
        this.repo = repo;
    }
    
    @PostConstruct
    private void initialize() {
        System.out.println("We're called after the constructors");
    }

    @Override
    public List<Speaker> findAll(){
        return repo.findAll();
    }

    @Autowired
    public void setRepo(SpeakerRepository repo) {
        System.out.println("SpeakerServiceImpl setter");
        this.repo = repo;
    }
}