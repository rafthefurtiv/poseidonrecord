package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.RecordController;
import it.barbato.poseidonRecord.converter.Converter;
import it.barbato.poseidonRecord.entity.*;
import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.dto.NewRecordDto;
import it.barbato.poseidonRecord.entity.dto.RecordDto;
import it.barbato.poseidonRecord.repository.CategoriaRepository;
import it.barbato.poseidonRecord.repository.StiliRepository;
import it.barbato.poseidonRecord.service.RecordService;
import it.barbato.poseidonRecord.service.UtentiService;
import it.barbato.poseidonRecord.utils.RecordFilter;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Map;

@RestController
public class RecordControllerImpl implements RecordController {

    Logger logger = LoggerFactory.getLogger(RecordControllerImpl.class);

    @Autowired
    private UtentiService utentiService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private StiliRepository stiliRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Record> getAllRecord() {
        return recordService.findAll();
    }

    @Override
    public List<Record> getRecordByFilter(
            Integer categoria,
            Integer corta,
            Integer utente,
            Integer metri,
            Integer stile
    ) {
        RecordFilter recordFilter = new RecordFilter();
        recordFilter.setCategoria(categoria);
        recordFilter.setFlagVascaCorta(corta);
        recordFilter.setUtente(utente);
        recordFilter.setMetri(metri);
        recordFilter.setStile(stile);

        return recordService.findByFilter(recordFilter);
    }


    public List<RecordDto> getRecords(){
        logger.debug("getrecords");
        List<Utenti> utentiList = utentiService.findAll();
        List<Record> recordList = recordService.findAll();

        List<RecordDto> recordDtoList = recordService.getAllRecordDtoList(utentiList, recordList);


        return recordDtoList;
    }

    @Override
    public List<Stili> getStili() {
        //logger.debug("getStili");
        System.out.println("getStili");
        return stiliRepository.findAll();
    }

    @Override
    public List<Integer> getMetri() {
        return null;
    }

    @Override
    public List<Categorie> getCategorie() {
        logger.debug("getCategorie");
        return categoriaRepository.findAll();
    }

    @Override
    public Map<String, List<String>> getTipologiche() {

        // TODO
        return null;
    }

    @Override
    public ResponseEntity<?> addRecord(NewRecordDto rec){
        System.out.println(rec);
        Esito esito = new Esito();

        Record newRecord = Converter.newRecordDtoToRecord(rec);

        Record oldrecord = recordService.findByFilter(newRecord);
        if(oldrecord != null && newRecord.getTempo() <= oldrecord.getTempo()){
            oldrecord.setTempo(newRecord.getTempo());
            recordService.save(oldrecord);

            esito.setMessage("Il record  stato aggiornato.");
            esito.setEsito(true);
            return new ResponseEntity<Esito>(esito, HttpStatus.OK);
        }
        else if (oldrecord == null){
            recordService.save(newRecord);

            esito.setMessage("Nuovo record inserito.");
            esito.setEsito(true);
            return new ResponseEntity<Esito>(esito, HttpStatus.OK);
        }

        esito.setMessage("Il record presenta gi� un tempo p� basso.");
        esito.setEsito(false);
        return new ResponseEntity<Esito>(esito, HttpStatus.NOT_MODIFIED);
    }

    @Override
    public ResponseEntity<?> getRecordSocietari() {
        List<RecordDto> recordDtoList = getRecords();

        /*
        select u.username , min(tempo), s.descrizione , metri, flag_vasca_corta, c.codice_categoria
from poseidonrecord.record r
inner join poseidonrecord.utenti u on r.utente = u.id_utente
inner join poseidonrecord.categorie c on c.id_categoria = r.categoria
inner join poseidonrecord.stili s on s.id_stile = r.stile
group by stile, metri, flag_vasca_corta, categoria
;

        */



        return null;
    }

}
