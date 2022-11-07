package it.barbato.poseidonRecord.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MacchinaDto {

    String nome;
    String proprietario;
    Integer idProprietario;
    Boolean auto;
    Boolean andata;
    Boolean ritorno;
    Integer postiAndata;
    Integer postiRitorno;

    List<String> passeggeriAndata;
    List<String> passeggeriRitorno;

}
