package it.barbato.poseidonRecord.repository;

import it.barbato.poseidonRecord.entity.Record;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecordRepository extends MineRepository<Record, Integer> {

    @Query("select r from Record r where r.utente.id = :idUtente" +
            " AND r.categoria.id = :idCategoria AND r.stile.id = :idStile AND r.metri = :metri" +
            " AND r.flagVascaCorta = :vasca")
    public Record findByFilter(Integer idUtente, Integer idCategoria, Integer idStile, Integer metri, Integer vasca);


    @Query(value = "select r2.*\n" +
            "from record r2\n" +
            "join (\n" +
            "select min(r.tempo) as tempo, r.stile, r.metri, r.flag_vasca_corta, r.categoria, u2.codice_sesso \n" +
            "from record r\n" +
            "inner join utenti u2 on r.utente = u2.id_utente \n" +
            "group by r.stile, r.metri, r.flag_vasca_corta, r.categoria, u2.codice_sesso \n" +
            ")\n" +
            "as t on t.tempo = r2.tempo  \n" +
            "AND r2.stile = t.stile  \n" +
            "AND r2.metri = t.metri  \n" +
            "AND r2.flag_vasca_corta = t.flag_vasca_corta  \n" +
            "AND r2.categoria = t.categoria  \n" +
            "inner join utenti u on r2.utente = u.id_utente and t.codice_sesso = u.codice_sesso \n" +
            "inner join categorie c on c.id_categoria = r2.categoria \n" +
            "inner join stili s on s.id_stile = r2.stile \n" +
            "order by stile, metri \n", nativeQuery = true)
    public List<Record> findSocietariAll();



}
