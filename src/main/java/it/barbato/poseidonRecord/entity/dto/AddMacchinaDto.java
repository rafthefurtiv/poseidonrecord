package it.barbato.poseidonRecord.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddMacchinaDto {

    private String nome;
    Integer postiAndata;
    Integer postiRitorno;
    Integer tipo;
    String note;
    String proprietario;
    Integer idProprietario;
    Boolean andata;
    Boolean ritorno;

}
