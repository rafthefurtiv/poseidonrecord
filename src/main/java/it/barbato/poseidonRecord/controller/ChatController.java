package it.barbato.poseidonRecord.controller;

import it.barbato.poseidonRecord.entity.Message;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/chat")
public interface ChatController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/messaggi/{id}")
    public List<Message> getMessaggiByUtente(@PathVariable("id") String id);

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/messaggi/{id}")
    public String saveMessaggio(@PathVariable("id") String id, @RequestBody String message);




}
