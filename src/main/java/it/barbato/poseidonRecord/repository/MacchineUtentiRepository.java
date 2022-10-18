package it.barbato.poseidonRecord.repository;

import it.barbato.poseidonRecord.entity.MacchineUtenti;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MacchineUtentiRepository extends MineRepository<MacchineUtenti, Integer> {

    @Query("select c from MacchineUtenti c where c.passeggero = :passeggero")
    MacchineUtenti findByPasseggero(Integer passeggero);

    @Query("select c from MacchineUtenti c where c.macchina = :macchina")
    List<MacchineUtenti> findByMacchina(Integer macchina);

}
