package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Utenti;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public interface UtentiController {

    @CrossOrigin(origins = {"http://localhost:80", "http://localhost:4200"})
    @GetMapping("/utente/{id}")
    public Utenti findByIdUtente(@PathVariable("id") Integer id);

    @CrossOrigin(origins = {"http://localhost:80", "http://localhost:4200"})
    @GetMapping("/utenti")
    public List<Utenti> getUtenteUnoById();
}
