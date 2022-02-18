package it.barbato.poseidonRecord.entity.dto;

public class FileDto {

    private String nome;
    private Long data;

    public FileDto(String nome, Long data){
        this.nome = nome;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

}
