package it.barbato.poseidonRecord.entity.dto;

import java.util.List;

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
