package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.utils.RecordFilter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("record")
public interface RecordController {

    @GetMapping()
    public List<Record> getAllRecord();

    @GetMapping("/filtered")
    public List<Record> getRecordByFilter(
            @RequestParam(name="categoria", required = false) Integer categoria,
            @RequestParam(name="corta", required = false) Integer corta
    );
}
