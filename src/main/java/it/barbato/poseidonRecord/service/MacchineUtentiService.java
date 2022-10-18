package it.barbato.poseidonRecord.service;

import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.MacchineUtenti;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.entity.dto.MacchineUtentiDto;
import it.barbato.poseidonRecord.repository.MacchineUtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MacchineUtentiService {

    @Autowired
    private MacchineUtentiRepository macchineUtentiRepository;

    @Autowired
    private MacchineService macchineService;

    @Autowired
    private UtentiService utentiService;

    @Transactional
    public List<MacchineUtenti> findAll() {
        return macchineUtentiRepository.findAll();
    }

    @Transactional
    public List<MacchineUtentiDto> findAllMacchineUtenti() {

        List<MacchineUtentiDto> macchineUtentiDtoList = new ArrayList<>();

        List<Macchine> macchineList = macchineService.findAll();
        List<MacchineUtenti> macchineUtentiList = this.findAll();

        macchineList.forEach(m -> {
            MacchineUtentiDto macchineUtentiDto = new MacchineUtentiDto();
            macchineUtentiDto.setMacchina(m);
            macchineUtentiDto.setMacchineUtentiList(macchineUtentiList.stream().filter(mu -> mu.getMacchina().equals(m.getId())).collect(Collectors.toList()));
            macchineUtentiDtoList.add(macchineUtentiDto);
        });

        return macchineUtentiDtoList;
    }

    @Transactional
    public MacchineUtenti save(Integer user, Integer idMacchina, Boolean andata, Boolean ritorno) throws Exception {

        MacchineUtenti macchineUtenti = macchineUtentiRepository.findByPasseggero(user);

        if(macchineUtenti == null){
            macchineUtenti = new MacchineUtenti();

            Utenti passeggero = utentiService.findByIdUtente(user);
            if(passeggero == null){
                throw new Exception("Utente inesistente");
            }
            macchineUtenti.setPasseggero(passeggero);
        }


        Macchine macchine = macchineService.findById(idMacchina);
        if(macchine == null){
            throw new Exception("Macchina inesistente");
        }
        macchineUtenti.setMacchina(macchine);

        macchineUtenti.setAndata(andata);
        macchineUtenti.setRitorno(ritorno);

        return macchineUtentiRepository.save(macchineUtenti);
    }

    @Transactional
    public MacchineUtenti addMacchinaUtente(String user, Integer idMacchina, Boolean andata, Boolean ritorno){

        MacchineUtenti macchineUtenti = new MacchineUtenti();

        return macchineUtentiRepository.save(macchineUtenti);
    }

    @Transactional
    public void eliminaMacchineUtenti(Macchine macchina){

        List<MacchineUtenti> macchineUtentiList = macchineUtentiRepository.findByMacchina(macchina.getId());

        macchineUtentiList.forEach(mu -> {
            macchineUtentiRepository.delete(mu);
        });

        macchineService.elimina(macchina);
    }

    @Transactional
    public void eliminaMacchineUtente(Utenti utente){

        MacchineUtenti macchineUtente = macchineUtentiRepository.findByPasseggero(utente.getId());

        macchineUtentiRepository.delete(macchineUtente);

    }

}
