package it.barbato.poseidonRecord.service;

import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.repository.RecordRepository;
import it.barbato.poseidonRecord.specification.RecordSpecification;
import it.barbato.poseidonRecord.utils.RecordFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
