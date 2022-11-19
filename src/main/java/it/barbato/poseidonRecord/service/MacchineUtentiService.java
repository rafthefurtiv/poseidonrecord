package it.barbato.poseidonRecord.service;

import it.barbato.poseidonRecord.converter.Converter;
import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.MacchineUtenti;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.entity.dto.MacchineUtentiDto;
import it.barbato.poseidonRecord.repository.MacchineUtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
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
            macchineUtentiDto.setMacchina(Converter.convertMacchinaToDto(m));
            macchineUtentiDto.setMacchineUtentiListAndata(new ArrayList<>());
            macchineUtentiDto.setMacchineUtentiListRitorno(new ArrayList<>());

            List<MacchineUtenti> macchineUtentiListTemp = macchineUtentiList.stream().filter(mu -> mu.getMacchina().equals(m)).collect(Collectors.toList());
            macchineUtentiListTemp = macchineUtentiListTemp.stream().filter(mu -> mu.getAndata().equals(true)).collect(Collectors.toList());

            macchineUtentiListTemp.forEach(mu -> {
                if(mu.getAndata()){
                    macchineUtentiDto.getMacchineUtentiListAndata().add(mu.getPasseggero().getNome().concat(" ").concat(mu.getPasseggero().getCognome()));
                }
            });

            macchineUtentiListTemp = macchineUtentiList.stream().filter(mu -> mu.getMacchina().equals(m)).collect(Collectors.toList());
            macchineUtentiListTemp = macchineUtentiListTemp.stream().filter(mu -> mu.getRitorno().equals(true)).collect(Collectors.toList());

            macchineUtentiListTemp.forEach(mu -> {
                if(mu.getRitorno()){
                    macchineUtentiDto.getMacchineUtentiListRitorno().add(mu.getPasseggero().getNome().concat(" ").concat(mu.getPasseggero().getCognome()));
                }
            });

            macchineUtentiDtoList.add(macchineUtentiDto);
        });

        return macchineUtentiDtoList;
    }

    @Transactional
    public MacchineUtenti save(Integer user, Integer idMacchina, Boolean andata, Boolean ritorno) throws Exception {

        Utenti utenti = new Utenti();
        utenti.setId(user);
        List<MacchineUtenti> macchineUtentiList = macchineUtentiRepository.findByPasseggero(utenti);

        Iterator<MacchineUtenti> iterator = macchineUtentiList.iterator();
        while (iterator.hasNext()){
            MacchineUtenti macchineUtenti = iterator.next();
            if(andata && macchineUtenti.getAndata() && macchineUtenti.getMacchina().getId() != idMacchina){
                throw new Exception("Andata gia prenotata con altra macchina");
            }

            if(ritorno && macchineUtenti.getRitorno() && macchineUtenti.getMacchina().getId() != idMacchina){
                throw new Exception("Ritorno gia prenotato con altra macchina");
            }
        }

        List<MacchineUtenti> macchineUtentifiltered = macchineUtentiList.stream().filter(mu -> mu.getMacchina().getId().equals(idMacchina)).collect(Collectors.toList());
        MacchineUtenti macchineUtenti;
        if(!macchineUtentifiltered.isEmpty()){
            macchineUtenti = macchineUtentifiltered.get(0);
        }
        else{
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

        List<MacchineUtenti> macchineUtentiByMacchineList = macchineUtentiRepository.findByMacchina(macchine);
        if(macchineUtentiByMacchineList.stream().filter(MacchineUtenti::getAndata).collect(Collectors.toList()).size() > macchine.getPostiAndata()){
            throw new Exception("Macchina andata piena");
        }
        if(macchineUtentiByMacchineList.stream().filter(MacchineUtenti::getRitorno).collect(Collectors.toList()).size() > macchine.getPostiAndata()){
            throw new Exception("Macchina ritorno piena");
        }

        return macchineUtentiRepository.save(macchineUtenti);
    }

    @Transactional
    public MacchineUtenti addMacchinaUtente(String user, Integer idMacchina, Boolean andata, Boolean ritorno){

        MacchineUtenti macchineUtenti = new MacchineUtenti();

        return macchineUtentiRepository.save(macchineUtenti);
    }

    @Transactional
    public void eliminaMacchineUtenti(Macchine macchina){

        List<MacchineUtenti> macchineUtentiList = macchineUtentiRepository.findByMacchina(macchina);

        macchineUtentiList.forEach(mu -> {
            macchineUtentiRepository.delete(mu);
        });

        macchineService.elimina(macchina);
    }

    @Transactional
    public void eliminaMacchineUtente(Utenti utente, Macchine macchine){

        List<MacchineUtenti> macchineUtente = macchineUtentiRepository.findByPasseggeroAndMacchina(utente, macchine);

        macchineUtentiRepository.deleteAll(macchineUtente);
    }

}
