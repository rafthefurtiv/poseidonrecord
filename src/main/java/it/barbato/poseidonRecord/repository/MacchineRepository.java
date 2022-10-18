package it.barbato.poseidonRecord.repository;

import it.barbato.poseidonRecord.entity.Macchine;
import org.springframework.data.jpa.repository.Query;

public interface MacchineRepository extends MineRepository<Macchine, Integer> {

    @Query("select c from Macchine c where c.proprietario = :proprietario")
    Macchine findByProprietario(Integer proprietario);

}
