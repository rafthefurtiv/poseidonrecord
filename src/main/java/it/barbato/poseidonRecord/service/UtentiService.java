package it.barbato.poseidonRecord.service;

import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.repository.UtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtentiService {

    @Autowired
    private UtentiRepository utentiRepository;

    public Utenti findByIdUtente(Integer id) {
        return utentiRepository.findByIdUtente(id);
    }

    public Utenti findByUsername(String username) {
        return utentiRepository.findByUsername(username);
    }

    public List<Utenti> findAll() {
        return utentiRepository.findAll();
    }

    public void saveUtente(Utenti utente){
        utentiRepository.save(utente);
    }
}
