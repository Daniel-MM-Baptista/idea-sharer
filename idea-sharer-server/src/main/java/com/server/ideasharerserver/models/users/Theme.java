package com.server.ideasharerserver.models.users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Theme {
    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;
    private String primaryColor;
    private String secondaryColor;
    private String tertiaryColor;
    private String textColor;
    private String hoverColor;
    private Date creationDate;
}
