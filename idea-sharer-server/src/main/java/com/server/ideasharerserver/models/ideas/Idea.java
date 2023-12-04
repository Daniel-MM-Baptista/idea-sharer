package com.server.ideasharerserver.models.ideas;

import com.server.ideasharerserver.models.users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Idea {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    private String name;
    private String description;
    private int likes;
    private Date creationDate;
}
