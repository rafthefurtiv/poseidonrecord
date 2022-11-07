package it.barbato.poseidonRecord.entity.dto;

import it.barbato.poseidonRecord.entity.MacchineUtenti;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MacchineUtentiDto {

    MacchinaDto macchina;

    List<MacchineUtenti> macchineUtentiListAndata;
    List<MacchineUtenti> macchineUtentiListRitorno;

}
