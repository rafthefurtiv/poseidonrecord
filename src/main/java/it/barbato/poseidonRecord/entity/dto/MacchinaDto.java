package it.barbato.poseidonRecord.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MacchinaDto {

    Integer id;
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

    List<String> passeggeriAndata;
    List<String> passeggeriRitorno;

}
