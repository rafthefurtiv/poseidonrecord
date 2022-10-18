package it.barbato.poseidonRecord.service;
import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.MacchineUtenti;
import it.barbato.poseidonRecord.repository.MacchineRepository;
import it.barbato.poseidonRecord.repository.MacchineUtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MacchineService {

    @Autowired
    private MacchineRepository macchineRepository;

    @Autowired
    private MacchineUtentiRepository macchineUtentiRepository;

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

    @Transactional
    public void update(Macchine newMacchina) throws Exception {

        Macchine macchina = macchineRepository.findById(newMacchina.getId()).get();

        if(newMacchina == null){
            throw new Exception("macchina non esistente");
        }

        List<MacchineUtenti> macchineUtentiList = macchineUtentiRepository.findByMacchina(newMacchina.getId());


        if(newMacchina.getPosti() < macchineUtentiList.size()){
            throw new Exception("posti gia occupati");
        }

        if(!newMacchina.getAndata() && macchina.getAndata()){
            throw new Exception("posti gia occupati per andata");
        }

        if(!newMacchina.getRitorno() && macchina.getRitorno()){
            throw new Exception("posti gia occupati per ritorno");
        }


        macchineRepository.save(newMacchina);
    }

}
