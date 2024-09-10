package it.barbato.poseidonRecord.service;
import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.MacchineUtenti;
import it.barbato.poseidonRecord.entity.Message;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.repository.ChatRepository;
import it.barbato.poseidonRecord.repository.MacchineRepository;
import it.barbato.poseidonRecord.repository.MacchineUtentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.util.calendar.BaseCalendar;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;



    @Transactional
    public List<Message> getAll(String id) {
        Pageable topTwenty = PageRequest.of(0, 40);
        return chatRepository.findLasts(id, topTwenty);
    }

    @Transactional
    public void saveMessage(Message message) {
        chatRepository.save(message);
    }

}
