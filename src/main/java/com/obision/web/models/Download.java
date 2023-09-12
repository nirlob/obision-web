package com.obision.web.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "downloads")
@Data
public class Download {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String ip;

    private String version;

    @Transient
    private Timestamp createdAt;
}