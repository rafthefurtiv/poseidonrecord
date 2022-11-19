package it.barbato.poseidonRecord.service;
import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.MacchineUtenti;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.repository.MacchineRepository;
import it.barbato.poseidonRecord.repository.MacchineUtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MacchineService {

    @Autowired
    private MacchineRepository macchineRepository;

    @Autowired
    private MacchineUtentiRepository macchineUtentiRepository;

    @Autowired
    private UtentiService utentiService;

    @Transactional
    public List<Macchine> findAll() {
        return macchineRepository.findAll();
    }

    @Transactional
    public Macchine findByIdProprietario(Utenti proprietario) {
        return macchineRepository.findByProprietario(proprietario);
    }

    @Transactional
    public Macchine findById(Integer macchina) {
        return macchineRepository.findById(macchina).get();
    }

    @Transactional
    public Macchine save(Macchine macchine) throws Exception {

        Utenti passeggero = utentiService.findByUsername(macchine.getProprietario().getUsername());
        if(passeggero == null){
            throw new Exception("Utente inesistente");
        }
        List<MacchineUtenti> macchineUtentiList = macchineUtentiRepository.findByPasseggero(passeggero);

        macchineUtentiList.forEach(mu -> {
            macchineUtentiRepository.delete(mu);
        });

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

        List<MacchineUtenti> macchineUtentiList = macchineUtentiRepository.findByMacchina(macchina);

        List<MacchineUtenti> macchineUtentiAndataList = macchineUtentiList.stream().filter(p -> p.getAndata()).collect(Collectors.toList());
        List<MacchineUtenti> macchineUtentiRitornoList = macchineUtentiList.stream().filter(p -> p.getRitorno()).collect(Collectors.toList());

        Integer postiOccupatiAndata = macchineUtentiAndataList.size();
        Integer postiOccupatiRitorno = macchineUtentiRitornoList.size();


        if(newMacchina.getPostiAndata() < postiOccupatiAndata){
            // TODO capire se necessario introdurre una data per eliminare gli ultimi che si sono aggiunti
            // TODO capire se avvisare tramite mail chi è stato eliminato
            macchineUtentiAndataList.stream().skip(newMacchina.getPostiAndata()).forEach(p -> {macchineUtentiRepository.delete(p);});
            throw new Exception("posti gia occupati");
        }

        if(newMacchina.getPostiRitorno() < postiOccupatiRitorno){

            //Integer postiDaEliminare = postiOccupatiRitorno - newMacchina.getPostiRitorno();
            macchineUtentiRitornoList.stream().skip(newMacchina.getPostiRitorno()).forEach(p -> {macchineUtentiRepository.delete(p);});
            //throw new Exception("posti gia occupati");
        }

        if(!newMacchina.getAndata() && macchina.getAndata()){
            macchineUtentiAndataList.stream().forEach(p -> {macchineUtentiRepository.delete(p);});
        }

        if(!newMacchina.getRitorno() && macchina.getRitorno()){
            macchineUtentiRitornoList.stream().forEach(p -> {macchineUtentiRepository.delete(p);});
        }

        macchineRepository.save(newMacchina);
    }

}
