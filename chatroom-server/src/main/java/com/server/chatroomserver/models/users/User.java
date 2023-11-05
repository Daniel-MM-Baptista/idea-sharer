package com.server.chatroomserver.models.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Blob;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class User {
    @Id
    private UUID id;
    private String username;
    private String email;
    private String passwordHash;
    private byte[] passwordSalt;
    private Date creationDate;
}
