package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.ImportazioneController;
import it.barbato.poseidonRecord.service.ImportazioneService;
import it.barbato.poseidonRecord.service.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImportazioneControllerImpl implements ImportazioneController {

    @Autowired
    private UtentiService utentiService;

    @Autowired
    private ImportazioneService importazioneService;

    @Override
    public ResponseEntity importUser(String jsonFile){

        importazioneService.convertiUtenti(jsonFile);

        return new ResponseEntity(null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity backup() {
        importazioneService.backUp();

        return new ResponseEntity(null, HttpStatus.OK);
    }


}
