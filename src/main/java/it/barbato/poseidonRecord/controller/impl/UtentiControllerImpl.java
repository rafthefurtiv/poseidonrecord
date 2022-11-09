package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.UtentiController;
import it.barbato.poseidonRecord.entity.Esito;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.service.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UtentiControllerImpl implements UtentiController {

    @Autowired
    private UtentiService utentiService;

    @Override
    public Utenti findByIdUtente(Integer id) {
        return utentiService.findByIdUtente(id);
    }

    @Override
    public List<Utenti> getUtenteUnoById() {
        return utentiService.findAll();
    }

    @Override
    public Utenti getUtenteByUsername(String userName) {
        return utentiService.findByUsername(userName);
    }

    @Override
    public ResponseEntity<?> getAuth(String user, String password) throws Exception {

        Esito esito = new Esito();
        if(user == null || user.equals("")){
            esito.setMessage("Utente vuoto");
            esito.setEsito(false);
            return new ResponseEntity<Esito>(esito, HttpStatus.BAD_REQUEST);
        }

        Utenti ut = utentiService.findByUsername(user);

        if(ut == null){
            esito.setMessage("Utente non trovato");
            esito.setEsito(false);
            return new ResponseEntity<Esito>(esito, HttpStatus.NOT_FOUND);
        }

        if(!password.equals(ut.getPassword())){
            esito.setMessage("Password errata");
            esito.setEsito(false);
            return new ResponseEntity<Esito>(esito, HttpStatus.UNAUTHORIZED);
        }

        esito.setEsito(true);
        esito.setSuperUser(ut.getSuperUser() != null && ut.getSuperUser() == 1 ? true : false);
        return new ResponseEntity<Esito>(esito, HttpStatus.OK);
    }
}
