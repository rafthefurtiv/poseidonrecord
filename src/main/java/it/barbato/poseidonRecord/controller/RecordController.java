package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Categorie;
import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.Stili;
import it.barbato.poseidonRecord.entity.dto.NewRecordDto;
import it.barbato.poseidonRecord.entity.dto.RecordDto;
import org.json.JSONObject;
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

    @CrossOrigin(origins = {"http://localhost:80", "http://localhost:4200"})
    @GetMapping("/stili")
    public List<Stili> getStili();

    @CrossOrigin(origins = {"http://localhost:80", "http://localhost:4200"})
    @GetMapping("/metri")
    public List<Integer> getMetri();

    @CrossOrigin(origins = {"http://localhost:80", "http://localhost:4200"})
    @GetMapping("/categorie")
    public List<Categorie> getCategorie();

    @CrossOrigin(origins = {"http://localhost:80", "http://localhost:4200"})
    @GetMapping("/tipologiche")
    public Map<String, List<String>> getTipologiche();

    @CrossOrigin(origins = {"http://localhost:80", "http://localhost:4200"})
    @PostMapping("/new")
    public ResponseBody addRecord(@RequestBody() NewRecordDto rec);


}
