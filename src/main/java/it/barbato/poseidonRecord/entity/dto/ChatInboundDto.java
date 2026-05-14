package it.barbato.poseidonRecord.entity.dto;

public class ChatInboundDto {

    private String from;
    private String messaggio;

    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }

    public String getMessaggio() { return messaggio; }
    public void setMessaggio(String messaggio) { this.messaggio = messaggio; }
}
