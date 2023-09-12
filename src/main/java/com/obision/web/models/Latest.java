package com.obision.web.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "latests")
@Data
public class Latest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String text;

    @Transient
    private Timestamp createdAt;

    @Transient
    private Timestamp updatedAt;
}