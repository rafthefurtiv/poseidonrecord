package it.barbato.poseidonRecord.service;

import it.barbato.poseidonRecord.entity.Message;
import it.barbato.poseidonRecord.entity.UltimoAccesso;
import it.barbato.poseidonRecord.repository.ChatRepository;
import it.barbato.poseidonRecord.repository.UltimoAccessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private UltimoAccessoRepository ultimoAccessoRepository;


    @Transactional
    public List<Message> getNewById(String id, Integer idMessage) {
        UltimoAccesso ultimoAccesso = new UltimoAccesso();
        ultimoAccesso.setOwner(id);
        ultimoAccesso.setTimestamp(new Timestamp(System.currentTimeMillis()));
        ultimoAccessoRepository.save(ultimoAccesso);

        return chatRepository.findLasts(idMessage);
    }


    @Transactional
    public List<Message> getAll(String id) {
        //Pageable topTwenty = PageRequest.of(0, 40);
        UltimoAccesso ultimoAccesso = new UltimoAccesso();
        ultimoAccesso.setOwner(id);
        ultimoAccesso.setTimestamp(new Timestamp(System.currentTimeMillis()));
        ultimoAccessoRepository.save(ultimoAccesso);
        return chatRepository.findAll(id);
    }

    @Transactional
    public void saveMessage(Message message) {
        chatRepository.save(message);
    }

}
