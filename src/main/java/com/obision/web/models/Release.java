package com.obision.web.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "releases")
@Data
public class Release {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String version;

    private String changes;

    private Date publishDate;
    
    @Transient
    private Timestamp createdAt;
}