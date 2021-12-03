package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.RecordController;
import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.service.RecordService;
import it.barbato.poseidonRecord.service.UtentiService;
import it.barbato.poseidonRecord.utils.RecordFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecordControllerImpl implements RecordController {

    @Autowired
    private UtentiService utentiService;

    @Autowired
    private RecordService recordService;

    @Override
    public List<Record> getAllRecord() {
        return recordService.findAll();
    }

    @Override
    public List<Record> getRecordByFilter(
            Integer categoria,
            Integer corta
    ) {
        RecordFilter recordFilter = new RecordFilter();
        recordFilter.setCategoria(categoria);
        recordFilter.setFlag_vasca_corta(corta);

        return recordService.findByFilter(recordFilter);
    }
}
