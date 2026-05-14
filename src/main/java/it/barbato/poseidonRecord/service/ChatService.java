package it.barbato.poseidonRecord.service;

import it.barbato.poseidonRecord.entity.Message;
import it.barbato.poseidonRecord.entity.UltimoAccesso;
import it.barbato.poseidonRecord.entity.dto.ChatMessageDto;
import it.barbato.poseidonRecord.repository.ChatRepository;
import it.barbato.poseidonRecord.repository.UltimoAccessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional
    public List<ChatMessageDto> getStorico(String owner) {
        if (owner != null && !owner.isEmpty()) {
            UltimoAccesso ultimoAccesso = new UltimoAccesso();
            ultimoAccesso.setOwner(owner.toLowerCase());
            ultimoAccesso.setTimestamp(new Timestamp(System.currentTimeMillis()));
            ultimoAccessoRepository.save(ultimoAccesso);
        }
        return chatRepository.findAllOrderByTimestamp()
                .stream()
                .map(ChatMessageDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Transactional
    public ChatMessageDto sendMessage(String from, String testo) {
        Message m = new Message();
        m.setOwner(from.toLowerCase());
        m.setMessaggio(testo);
        m.setTimestamp(new Timestamp(System.currentTimeMillis()));
        Message saved = chatRepository.save(m);
        return ChatMessageDto.fromEntity(saved);
    }
}
