package it.barbato.poseidonRecord.service;
import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.repository.MacchineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MacchineService {

    @Autowired
    private MacchineRepository macchineRepository;

    @Transactional
    public List<Macchine> findAll() {
        return macchineRepository.findAll();
    }

    @Transactional
    public Macchine findByIdProprietario(Integer proprietario) {
        return macchineRepository.findByProprietario(proprietario);
    }

    @Transactional
    public Macchine findById(Integer macchina) {
        return macchineRepository.findById(macchina).get();
    }

    @Transactional
    public Macchine save(Macchine macchine){
        return macchineRepository.save(macchine);
    }

    @Transactional
    public void elimina(Macchine macchine){
        macchineRepository.delete(macchine);
    }

}
