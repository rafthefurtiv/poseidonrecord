package it.barbato.poseidonRecord.repository;

import it.barbato.poseidonRecord.entity.Record;
import org.jvnet.staxex.BinaryText;
import org.springframework.data.jpa.repository.Query;

public interface RecordRepository extends MineRepository<Record, Integer> {

    @Query("select r from Record r where r.utente.id = :idUtente" +
            " AND r.categoria.id = :idCategoria AND r.stile.id = :idStile AND r.metri = :metri" +
            " AND r.flagVascaCorta = :vasca")
    public Record findByFilter(Integer idUtente, Integer idCategoria, Integer idStile, Integer metri, Integer vasca);
}
