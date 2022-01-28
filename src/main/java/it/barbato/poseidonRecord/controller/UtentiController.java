package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Utenti;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/utenti")
public interface UtentiController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/utente/{id}")
    public Utenti findByIdUtente(@PathVariable("id") Integer id);

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/utenti")
    public List<Utenti> getUtenteUnoById();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/login")
    public ResponseEntity<?> getAuth(@RequestParam("user") String user, @RequestParam("pass") String password) throws Exception;
}
