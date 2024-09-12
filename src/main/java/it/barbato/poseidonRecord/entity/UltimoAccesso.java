package it.barbato.poseidonRecord.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Table(name = "ultimo_accesso")

@Data
@Getter
@Setter
@Entity
public class UltimoAccesso {
    @Id
    @Column(name = "owner", nullable = false)
    private String owner;

    @Column(name = "timestamp", nullable = false, length = 200)
    private Timestamp timestamp;

}