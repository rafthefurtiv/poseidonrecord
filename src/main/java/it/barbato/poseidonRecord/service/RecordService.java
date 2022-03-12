package it.barbato.poseidonRecord.service;

import it.barbato.poseidonRecord.converter.Converter;
import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.entity.dto.RecordDto;
import it.barbato.poseidonRecord.entity.dto.RecordSocietarioDto;
import it.barbato.poseidonRecord.repository.RecordRepository;
import it.barbato.poseidonRecord.specification.RecordSpecification;
import it.barbato.poseidonRecord.utils.RecordFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    public List<Record> findByFilter(RecordFilter recordFilter) {

        RecordSpecification recordSpecification = new RecordSpecification(recordFilter);

        return recordRepository.findAll(recordSpecification);
    }

    public List<RecordDto> getAllRecordDtoList(List<Utenti> utentiList, List<Record> recordList) {

        List<RecordDto> recordDtoList = new ArrayList<>();

        utentiList.forEach(utente -> {
            RecordDto recordDto = new RecordDto();
            List<Record> gare = recordList.stream().filter(r -> r.getUtente().equals(utente)).collect(Collectors.toList());
            recordDto = Converter.recordToRecordDto(utente, gare);
            recordDtoList.add(recordDto);
        });

        return recordDtoList;
    }

    public Record save(Record record){
        return recordRepository.save(record);
    }

    public Record findByFilter(Record record){
        return recordRepository.findByFilter(record.getUtente().getId(), record.getCategoria().getId()
                , record.getStile().getId(), record.getMetri(),
                record.getFlagVascaCorta());
    }

    public List<RecordSocietarioDto> findRecordSocietari(){

        return Converter.recordListToRecordDtoList(recordRepository.findSocietariAll());
    }
}
