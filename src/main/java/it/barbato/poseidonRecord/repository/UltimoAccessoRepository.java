package it.barbato.poseidonRecord.repository;

import it.barbato.poseidonRecord.entity.Message;
import it.barbato.poseidonRecord.entity.UltimoAccesso;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UltimoAccessoRepository extends MineRepository<UltimoAccesso, Integer> {
/*
    @Query("select m from Message m order by timestamp ASC")
    List<Message> findLasts(String id, Pageable pageable);
    */



}
