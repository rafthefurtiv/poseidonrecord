package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.RecordController;
import it.barbato.poseidonRecord.entity.Categorie;
import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.Stili;
import it.barbato.poseidonRecord.entity.Utenti;
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
    public ResponseBody addRecord(NewRecordDto rec){
        System.out.println(rec);

        // TODO Verificare se esiste già
        // se esiste fare il confronto
        // se non esiste aggiungere
        // se minore fare update tempo

        return null;
    }

}
