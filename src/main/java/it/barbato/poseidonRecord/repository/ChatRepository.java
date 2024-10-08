package it.barbato.poseidonRecord.repository;

import it.barbato.poseidonRecord.entity.Message;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends MineRepository<Message, Integer> {
/*
    @Query("select m from Message m order by timestamp ASC")
    List<Message> findLasts(String id, Pageable pageable);
    */
    @Query("select m from Message m where id > :id order by timestamp ASC")
    List<Message> findLasts(Integer id);

    @Query("select m from Message m order by timestamp ASC")
    List<Message> findAll(String id);


}
