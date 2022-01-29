package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Categorie;
import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.Stili;
import it.barbato.poseidonRecord.entity.dto.NewRecordDto;
import it.barbato.poseidonRecord.entity.dto.RecordDto;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/records")
    public List<RecordDto> getRecords();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/stili")
    public List<Stili> getStili();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/metri")
    public List<Integer> getMetri();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/categorie")
    public List<Categorie> getCategorie();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/tipologiche")
    public Map<String, List<String>> getTipologiche();

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/new")
    public ResponseEntity<?> addRecord(@RequestBody() NewRecordDto rec);

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/record-societari")
    public ResponseEntity<?> getRecordSocietari();

}
