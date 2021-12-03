package it.barbato.poseidonRecord.entity;

import javax.persistence.*;

@Table(name = "categorie", indexes = {
        @Index(name = "categoria_unique", columnList = "codice_categoria", unique = true)
})
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria", nullable = false)
    private Integer id;

    @Column(name = "codice_categoria", nullable = false, length = 3)
    private String codiceCategoria;

    public String getCodiceCategoria() {
        return codiceCategoria;
    }

    public void setCodiceCategoria(String codiceCategoria) {
        this.codiceCategoria = codiceCategoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}