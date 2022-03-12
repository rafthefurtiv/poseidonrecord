package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.importt.UtentiImport;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/import")
public interface ImportazioneController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/utenti")
    public ResponseEntity importUser(
            @RequestBody String inputData
    );

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/backup")
    public ResponseEntity backup();


}
