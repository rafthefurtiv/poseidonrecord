package it.barbato.poseidonRecord.entity.dto;

import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.MacchineUtenti;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MacchineUtentiDto {

    Macchine macchina;

    List<MacchineUtenti> macchineUtentiListAndata;
    List<MacchineUtenti> macchineUtentiListRitorno;

}
