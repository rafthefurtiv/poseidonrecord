package it.barbato.poseidonRecord.entity;

public class Esito {

    String message;

    Boolean esito;

    Boolean superUser;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getEsito() {
        return esito;
    }

    public void setEsito(Boolean esito) {
        this.esito = esito;
    }

    public Boolean getSuperUser() {
        return superUser;
    }

    public void setSuperUser(Boolean superUser) {
        this.superUser = superUser;
    }
}
