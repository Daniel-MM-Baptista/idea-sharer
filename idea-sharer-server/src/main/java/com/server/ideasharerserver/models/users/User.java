package com.server.ideasharerserver.models.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class User {
    @Id
    private String id;
    private String username;
    private String email;
    private String passwordHash;
    private byte[] passwordSalt;
    private Date creationDate;
}
