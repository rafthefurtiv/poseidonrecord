package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.RecordController;
import it.barbato.poseidonRecord.controller.UtentiController;
import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.service.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecordControllerImpl implements RecordController {

    @Autowired
    private UtentiService utentiService;

    @Override
    public Utenti findByIdUtente(Integer id) {
        return utentiService.findByIdUtente(id);
    }

    @Override
    public List<Record> getAllRecord() {
        return utentiService.findAll();
    }
}
