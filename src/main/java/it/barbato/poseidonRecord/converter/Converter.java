package it.barbato.poseidonRecord.converter;

import it.barbato.poseidonRecord.entity.Utenti;

import java.util.Map;

public class Converter {

    public static Utenti mapToUtente(Map<String, Object> json){
        Utenti utente = new Utenti();
        utente.setNome(json.get("nome").toString());
        utente.setCognome(json.get("cognome").toString());
        utente.setUsername(json.get("userName").toString());
        utente.setCodiceSesso(Integer.parseInt(json.get("sesso").toString()) == 0 ? "M" : "S");
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
}
