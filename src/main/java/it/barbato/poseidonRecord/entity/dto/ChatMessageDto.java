package it.barbato.poseidonRecord.entity.dto;

import it.barbato.poseidonRecord.entity.Message;

public class ChatMessageDto {

    private Integer id;
    private String from;
    private String messaggio;
    private String timestamp;

    public ChatMessageDto() {}

    public static ChatMessageDto fromEntity(Message m) {
        ChatMessageDto d = new ChatMessageDto();
        d.id = m.getId();
        d.from = m.getOwner();
        d.messaggio = m.getMessaggio();
        d.timestamp = m.getTimestamp() != null ? m.getTimestamp().toInstant().toString() : null;
        return d;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getMessaggio() { return messaggio; }
    public void setMessaggio(String messaggio) { this.messaggio = messaggio; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }
}
