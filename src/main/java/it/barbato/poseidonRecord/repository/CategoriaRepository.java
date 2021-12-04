package it.barbato.poseidonRecord.repository;

import it.barbato.poseidonRecord.entity.Categorie;
import it.barbato.poseidonRecord.entity.Utenti;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends MineRepository<Categorie, Integer> {

    @Query("select c from Categorie c where c.codiceCategoria = :codiceCategoria")
    Categorie findByCodicecategria(String codiceCategoria);
}
