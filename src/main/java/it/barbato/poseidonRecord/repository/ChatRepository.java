package it.barbato.poseidonRecord.repository;

import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.Message;
import it.barbato.poseidonRecord.entity.Utenti;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends MineRepository<Message, Integer> {

    @Query("select m from Message m order by timestamp ASC")
    List<Message> findLasts(String id, Pageable pageable);



}
