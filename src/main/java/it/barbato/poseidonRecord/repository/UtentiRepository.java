package it.barbato.poseidonRecord.repository;

import it.barbato.poseidonRecord.entity.Utenti;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UtentiRepository extends MineRepository<Utenti, Integer> {

    List<Utenti> findAll();

    @Query("select u from Utenti u where u.id = :id")
    Utenti findByIdUtente(Integer id);

    @Query("select u from Utenti u ORDER BY u.nome, u.cognome")
    List<Utenti> findAllOrdered();

    @Query("select u from Utenti u where u.username = :username")
    Utenti findByUsername(String username);
}
