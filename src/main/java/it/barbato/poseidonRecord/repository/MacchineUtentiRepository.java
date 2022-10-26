package it.barbato.poseidonRecord.repository;

import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.MacchineUtenti;
import it.barbato.poseidonRecord.entity.Utenti;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface MacchineUtentiRepository extends MineRepository<MacchineUtenti, Integer> {

    @Query("select c from MacchineUtenti c where c.passeggero = :passeggero")
    MacchineUtenti findByPasseggero(Utenti passeggero);

    @Query("select c from MacchineUtenti c where c.macchina = :macchina")
    List<MacchineUtenti> findByMacchina(Macchine macchina);

}
