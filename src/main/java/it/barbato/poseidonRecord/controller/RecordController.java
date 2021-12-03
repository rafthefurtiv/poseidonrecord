package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.Utenti;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("record/")
public interface RecordController {

    @GetMapping("utente/{id}")
    public Utenti findByIdUtente(@PathVariable("id") Integer id);

    @GetMapping("")
    public List<Record> getAllRecord();
}
