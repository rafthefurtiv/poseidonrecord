package it.barbato.poseidonRecord.controller.impl;

import it.barbato.poseidonRecord.controller.ChatController;
import it.barbato.poseidonRecord.controller.MacchineController;
import it.barbato.poseidonRecord.converter.Converter;
import it.barbato.poseidonRecord.entity.Macchine;
import it.barbato.poseidonRecord.entity.Message;
import it.barbato.poseidonRecord.entity.Utenti;
import it.barbato.poseidonRecord.entity.dto.AddMacchinaDto;
import it.barbato.poseidonRecord.entity.dto.MacchineUtentiDto;
import it.barbato.poseidonRecord.service.ChatService;
import it.barbato.poseidonRecord.service.MacchineService;
import it.barbato.poseidonRecord.service.MacchineUtentiService;
import it.barbato.poseidonRecord.service.UtentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    public String saveMessaggio(String id, String message) {

        Message m = new Message();
        m.setMessaggio(message);
        m.setOwner(id.toLowerCase());
        m.setTimestamp(new Timestamp(System.currentTimeMillis()));
        chatService.saveMessage(m);
        return null;
    }
}
