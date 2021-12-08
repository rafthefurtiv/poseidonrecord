package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Categorie;
import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.Stili;
import it.barbato.poseidonRecord.entity.dto.RecordDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/record")
public interface RecordController {

    @GetMapping()
    public List<Record> getAllRecord();

    @GetMapping("/filtered")
    public List<Record> getRecordByFilter(
            @RequestParam(name="categoria", required = false) Integer categoria,
            @RequestParam(name="corta", required = false) Integer corta,
            @RequestParam(name="utente", required = false) Integer utente,
            @RequestParam(name="metri", required = false) Integer metri,
            @RequestParam(name="stile", required = false) Integer stile
    );

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/records")
    public List<RecordDto> getRecords();

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/stili")
    public List<Stili> getStili();

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/metri")
    public List<Integer> getMetri();

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/categorie")
    public List<Categorie> getCategorie();

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/tipologiche")
    public Map<String, List<String>> getTipologiche();


}
