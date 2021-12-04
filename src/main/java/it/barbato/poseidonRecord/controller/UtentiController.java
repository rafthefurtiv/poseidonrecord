package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Utenti;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public interface UtentiController {

    @GetMapping("/utente/{id}")
    public Utenti findByIdUtente(@PathVariable("id") Integer id);

    @GetMapping("/utenti")
    public List<Utenti> getUtenteUnoById();
}
