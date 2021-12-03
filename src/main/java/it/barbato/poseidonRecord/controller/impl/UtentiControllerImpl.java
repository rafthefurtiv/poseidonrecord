package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.UtentiController;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.service.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtentiControllerImpl implements UtentiController {

    @Autowired
    private UtentiService utentiService;

    @Override
    public Utenti findByIdUtente(Integer id) {
        return utentiService.findByIdUtente(id);
    }

    @Override
    public List<Utenti> getUtenteUnoById() {
        return utentiService.findAll();
    }
}
