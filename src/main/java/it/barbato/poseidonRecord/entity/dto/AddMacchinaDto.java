package it.barbato.poseidonRecord.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddMacchinaDto {

    String nome;
    String proprietario;
    Integer idProprietario;
    String username;
    String auto;
    Boolean andata;
    Boolean ritorno;
    Integer postiAndata;
    Integer postiRitorno;
    String note;

}
