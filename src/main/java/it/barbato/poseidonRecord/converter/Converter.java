package it.barbato.poseidonRecord.converter;

import it.barbato.poseidonRecord.entity.*;
import it.barbato.poseidonRecord.entity.Record;
import it.barbato.poseidonRecord.entity.dto.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Converter {

    public static Utenti mapToUtente(Map<String, Object> json){
        Utenti utente = new Utenti();
        utente.setNome(json.get("nome").toString());
        utente.setCognome(json.get("cognome").toString());
        utente.setUsername(json.get("userName").toString());
        utente.setCodiceSesso(Integer.parseInt(json.get("sesso").toString()) == 0 ? "M" : "F");
        utente.setDescrizione(json.get("descrizione") != null ? json.get("descrizione").toString() : "");
        utente.setMedaglieOro(json.get("medaglieOro") != null ? Integer.parseInt(json.get("medaglieOro").toString()) : 0);
        utente.setMedaglieArgento(json.get("medaglieArgento") != null ? Integer.parseInt(json.get("medaglieArgento").toString()) : 0);
        utente.setMedaglieBronzo(json.get("medaglieBronzo") != null ? Integer.parseInt(json.get("medaglieBronzo").toString()) : 0);
        utente.setMedaglieOroStaffetta(json.get("medaglieOroStaff") != null ? Integer.parseInt(json.get("medaglieOroStaff").toString()) : 0);
        utente.setMedaglieArgentoStaffetta(json.get("medaglieArgentoStaff") != null ? Integer.parseInt(json.get("medaglieArgentoStaff").toString()) :  0);
        utente.setMedaglieBronzoStaffetta(json.get("medaglieBronzoStaff") != null ? Integer.parseInt(json.get("medaglieBronzoStaff").toString()) : 0);


        utente.setEmail(utente.getNome() + "." + utente.getCognome() + "@esempio.it");
        utente.setPassword(utente.getNome() + "." + utente.getCognome());

        return utente;
    }


    public static RecordDto recordToRecordDto(Utenti utenti, List<Record> recordList){

        RecordDto recordDto = new RecordDto();

        recordDto.setNome(utenti.getNome());
        recordDto.setCognome(utenti.getCognome());
        recordDto.setCodiceSesso(utenti.getCodiceSesso());
        recordDto.setUsername(utenti.getUsername());
        List<GaraDto> garaDtoList = new ArrayList<>();
        recordList.forEach(gara -> {
            GaraDto garaDto = new GaraDto();
            garaDto.setNomeGara(gara.getMetri() + " " + gara.getStile().getDescrizione());
            garaDto.setVasca(gara.getFlagVascaCorta()==1 ? "Corta" : "Lunga");
            garaDto.setCategoria(gara.getCategoria().getCodiceCategoria());
            garaDto.setTempo(gara.getTempo());
            garaDto.setNote(gara.getNote());
            garaDtoList.add(garaDto);
        });
        recordDto.setGare(garaDtoList);
        return recordDto;
    }


    public static List<RecordSocietarioDto> recordListToRecordDtoList(List<Record> recordList){

        List<RecordSocietarioDto> recordSocietarioDtoList = new ArrayList<>();

        recordList.forEach(record -> {
            RecordSocietarioDto recordSocietarioDto = new RecordSocietarioDto();

            recordSocietarioDto.setNome(record.getUtente().getNome());
            recordSocietarioDto.setCognome(record.getUtente().getCognome());
            recordSocietarioDto.setCodiceSesso(record.getUtente().getCodiceSesso());
            recordSocietarioDto.setUsername(record.getUtente().getUsername());

            GaraDto garaDto = new GaraDto();
            garaDto.setNomeGara(record.getMetri() + " " + record.getStile().getDescrizione());
            garaDto.setVasca(record.getFlagVascaCorta()==1 ? "Corta" : "Lunga");
            garaDto.setCategoria(record.getCategoria().getCodiceCategoria());
            garaDto.setTempo(record.getTempo());
            garaDto.setMetri(record.getMetri().toString());
            garaDto.setStile(record.getStile().getDescrizione());
            garaDto.setNote(record.getNote());

            recordSocietarioDto.setGara(garaDto);

            recordSocietarioDtoList.add(recordSocietarioDto);
        });
        return recordSocietarioDtoList;
    }


    public static Record newRecordDtoToRecord(NewRecordDto newRecordDto){

        Record record = new Record();
        record.setMetri(newRecordDto.getMetri());

        Stili stile = new Stili();
        stile.setId(newRecordDto.getIdStile());
        record.setStile(stile);

        Categorie categoria = new Categorie();
        categoria.setId(newRecordDto.getIdCategoria());
        record.setCategoria(categoria);

        Utenti utente = new Utenti();
        utente.setId(newRecordDto.getIdUtente());
        record.setUtente(utente);

        record.setFlagVascaCorta(newRecordDto.getVasca());
        record.setTempo(new Double(newRecordDto.getMinuti()*6000 + newRecordDto.getSecondi()*100 + newRecordDto.getCentesimi()));

        record.setFlagSocietario(0);

        record.setNote(newRecordDto.getNote());

        return record;
    }

    public static Macchine convertAddMacchineDtoToMacchine(AddMacchinaDto addMacchinaDto, Macchine macchina){

        if(addMacchinaDto == null){return null;}

        Macchine macchine = new Macchine();

        Utenti proprietario = new Utenti();
        proprietario.setId(addMacchinaDto.getIdProprietario());
        macchine.setProprietario(proprietario);
        macchine.setId(macchina.getId());
        macchine.setNome(addMacchinaDto.getNome());
        macchine.setPostiAndata(addMacchinaDto.getPostiAndata());
        macchine.setPostiRitorno(addMacchinaDto.getPostiRitorno());
        macchine.setNote(addMacchinaDto.getNote());
        macchine.setAndata(addMacchinaDto.getAndata());
        macchine.setRitorno(addMacchinaDto.getRitorno());
        macchine.setTipo(addMacchinaDto.getAuto().equals("AUTO") ? 1 : 2);

        return macchine;

    }
    public static Macchine convertAddMacchineDtoToMacchine(AddMacchinaDto addMacchinaDto){

        if(addMacchinaDto == null){return null;}

        Macchine macchine = new Macchine();

        Utenti proprietario = new Utenti();
        proprietario.setId(addMacchinaDto.getIdProprietario());
        macchine.setProprietario(proprietario);
        macchine.setNome(addMacchinaDto.getNome());
        macchine.setPostiAndata(addMacchinaDto.getPostiAndata());
        macchine.setPostiRitorno(addMacchinaDto.getPostiRitorno());
        macchine.setNote(addMacchinaDto.getNote());
        macchine.setAndata(addMacchinaDto.getAndata());
        macchine.setRitorno(addMacchinaDto.getRitorno());
        macchine.setTipo(addMacchinaDto.getAuto().equals("AUTO") ? 1 : 2);

        return macchine;

    }


    public static MacchinaDto convertMacchinaToDto(Macchine macchina){

        ModelMapper modelMapper = new ModelMapper();

        MacchinaDto macchinaDto = modelMapper.map(macchina, MacchinaDto.class);
        macchinaDto.setProprietario(macchina.getProprietario().getNome().concat(" ").concat(macchina.getProprietario().getCognome()));
        macchinaDto.setUsername(macchina.getProprietario().getUsername());
        macchinaDto.setAuto(macchina.getTipo() == 1 ? "AUTO" : "MOTO");
        macchinaDto.setId(macchina.getId());

        return macchinaDto;
    }




}
