package com.server.ideasharerserver.models.ideas;

import com.server.ideasharerserver.models.users.User;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Message {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    @ManyToOne
    @JoinColumn(name="ideaId")
    private Idea idea;
    private String content;
    private Date creationDate;
}
