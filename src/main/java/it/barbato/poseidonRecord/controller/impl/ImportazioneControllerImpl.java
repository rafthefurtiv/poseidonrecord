package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.ImportazioneController;
import it.barbato.poseidonRecord.converter.Converter;
import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.service.ImportazioneService;
import it.barbato.poseidonRecord.service.UtentiService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ImportazioneControllerImpl implements ImportazioneController {

    @Autowired
    private UtentiService utentiService;

    @Autowired
    private ImportazioneService importazioneService;

    @Override
    public List<Record> importUser(String jsonFile){

        importazioneService.convertiUtenti(jsonFile);

        return  null;
    }

    @Override
    public ResponseEntity backup() {
        importazioneService.backUp();

        return new ResponseEntity(null, HttpStatus.OK);
    }


}
