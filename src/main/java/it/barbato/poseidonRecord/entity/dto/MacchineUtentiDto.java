package it.barbato.poseidonRecord.entity.dto;

import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.MacchineUtenti;

import java.util.List;

public class MacchineUtentiDto {

    Macchine macchina;

    List<MacchineUtenti> macchineUtentiList;

    public Macchine getMacchina() {
        return macchina;
    }

    public void setMacchina(Macchine macchina) {
        this.macchina = macchina;
    }

    public List<MacchineUtenti> getMacchineUtentiList() {
        return macchineUtentiList;
    }

    public void setMacchineUtentiList(List<MacchineUtenti> macchineUtentiList) {
        this.macchineUtentiList = macchineUtentiList;
    }
}
