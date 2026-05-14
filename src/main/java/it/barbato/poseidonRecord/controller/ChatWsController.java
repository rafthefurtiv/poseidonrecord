package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.dto.ChatInboundDto;
import it.barbato.poseidonRecord.entity.dto.ChatMessageDto;
import it.barbato.poseidonRecord.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatWsController {

    @Autowired
    private SimpMessagingTemplate broker;

    @Autowired
    private ChatService chatService;

    @MessageMapping("/chat")
    public void onMessage(ChatInboundDto in) {
        if (in == null || in.getFrom() == null || in.getMessaggio() == null) {
            return;
        }
        ChatMessageDto saved = chatService.sendMessage(in.getFrom(), in.getMessaggio());
        broker.convertAndSend("/topic/chat", saved);
    }
}
