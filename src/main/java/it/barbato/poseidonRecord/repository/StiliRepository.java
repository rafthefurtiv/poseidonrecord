package it.barbato.poseidonRecord.repository;

import it.barbato.poseidonRecord.entity.Stili;
import it.barbato.poseidonRecord.entity.Utenti;
import org.springframework.data.jpa.repository.Query;

public interface StiliRepository extends MineRepository<Stili, Integer> {

    @Query("select u from Stili u where u.descrizione = :descrizione")
    Stili findByDescrizione(String descrizione);

    @Query("select u from Stili u where u.descrizioneBreve = :descrizioneBreve")
    Stili findByDescrizioneBreve(String descrizioneBreve);
}
