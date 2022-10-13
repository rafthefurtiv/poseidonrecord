package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.Utenti;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/macchine")
public interface MacchineController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping()
    public Macchine findMacchine();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/macchine/passeggerp")
    public List<Utenti> addPasseggero();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/login")
    public ResponseEntity<?> getAuth(@RequestParam("user") String user, @RequestParam("pass") String password) throws Exception;
}
