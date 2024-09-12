package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.ChatController;
import it.barbato.poseidonRecord.entity.Message;
import it.barbato.poseidonRecord.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class ChatControllerImpl implements ChatController {

    @Autowired
    private ChatService chatService;

    @Override
    public List<Message> getMessaggiByUtente(String id) {

        return chatService.getAll(id.toLowerCase());

    }

    @Override
    public List<Message> getNewMessages(String id, Integer idMessaggio) {
        return chatService.getNewById(id, idMessaggio);
    }

    @Override
    public String saveMessaggio(String id, String message) {

        Message m = new Message();
        m.setMessaggio(message);
        m.setOwner(id.toLowerCase());
        m.setTimestamp(new Timestamp(System.currentTimeMillis()));

        chatService.saveMessage(m);
        return null;
    }



}
