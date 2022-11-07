package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.MacchineController;
import it.barbato.poseidonRecord.converter.Converter;
import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.entity.dto.AddMacchinaDto;
import it.barbato.poseidonRecord.entity.dto.MacchineUtentiDto;
import it.barbato.poseidonRecord.service.MacchineService;
import it.barbato.poseidonRecord.service.MacchineUtentiService;
import it.barbato.poseidonRecord.service.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class MacchineControllerImpl implements MacchineController {

    @Autowired
    private MacchineService macchineService;

    @Autowired
    private MacchineUtentiService macchineUtentiService;

    @Autowired
    private UtentiService utentiService;

    @Override
    public ResponseEntity<?> findMacchineUtenti() {
        List<MacchineUtentiDto> macchineUtentiDtoList = macchineUtentiService.findAllMacchineUtenti();
        return new ResponseEntity<>(macchineUtentiDtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> findMacchine() {
        List<Macchine> macchineList = macchineService.findAll();

        return new ResponseEntity<>(macchineList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> addMacchina(AddMacchinaDto macchina) throws Exception {

        Utenti utente = utentiService.findByIdUtente(macchina.getIdProprietario());
        if(utente == null){
            return new ResponseEntity<>(new String("Utente non esistente"), HttpStatus.NOT_FOUND);
        }

        Macchine macchine = macchineService.findByIdProprietario(utente);
        if(macchine != null){
            return new ResponseEntity<>(new String("Macchina esistente"), HttpStatus.CONFLICT);
        }

        Macchine macchinaToSave = Converter.convertAddMacchineDtoToMacchine(macchina);

        macchineService.save(macchinaToSave);
        List<Macchine> macchineList = macchineService.findAll();
        return new ResponseEntity<>(macchineList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateMacchina(AddMacchinaDto macchina) throws Exception {

        Utenti utente = utentiService.findByIdUtente(macchina.getIdProprietario());
        if(utente == null){
            return new ResponseEntity<>(new String("Utente non esistente"), HttpStatus.NOT_FOUND);
        }

        Macchine macchine = macchineService.findByIdProprietario(utente);
        if(macchine == null){
            return new ResponseEntity<>(new String("Macchina non esistente"), HttpStatus.CONFLICT);
        }

        macchine = Converter.convertAddMacchineDtoToMacchine(macchina, macchine);

        macchineService.update(macchine);

        return null;
    }

    @Override
    public ResponseEntity<?> deleteMacchina(Integer utente) throws Exception {

        Utenti u = utentiService.findByIdUtente(utente);
        if(u == null){
            return new ResponseEntity<>(new String("Utente non esistente"), HttpStatus.NOT_FOUND);
        }

        Macchine macchine = macchineService.findByIdProprietario(u);
        if(macchine == null){
            return new ResponseEntity<>(new String("Macchina non esistente"), HttpStatus.NOT_FOUND);
        }

        macchineUtentiService.eliminaMacchineUtenti(macchine);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updatePasseggero(Integer user, Integer idMacchina, Boolean andata, Boolean ritorno) throws Exception {

        // Funziona anche da UPDATE

        Utenti u = utentiService.findByIdUtente(user);
        if(u == null){
            return new ResponseEntity<>(new String("Utente non esistente"), HttpStatus.NOT_FOUND);
        }

        Macchine macchine = macchineService.findByIdProprietario(u);
        if(macchine == null){
            return new ResponseEntity<>(new String("Macchina non esistente"), HttpStatus.NOT_FOUND);
        }

        if(!andata && !ritorno){
            macchineUtentiService.eliminaMacchineUtente(u);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }

        macchineUtentiService.save(user, idMacchina, andata, ritorno);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deletePasseggero(Integer user, Integer idMacchina, Boolean andata, Boolean ritorno) {
        // Forse da eliminare

        Utenti u = utentiService.findByIdUtente(user);
        if(u == null){
            return new ResponseEntity<>(new String("Utente non esistente"), HttpStatus.NOT_FOUND);
        }

        Macchine macchine = macchineService.findByIdProprietario(u);
        if(macchine == null){
            return new ResponseEntity<>(new String("Macchina non esistente"), HttpStatus.NOT_FOUND);
        }

        macchineUtentiService.eliminaMacchineUtente(u);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
