package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.importt.UtentiImport;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/import")
public interface ImportazioneController {

    @PostMapping("/utenti")
    public List<Record> importUser(
            @RequestBody String inputData
    );


}
