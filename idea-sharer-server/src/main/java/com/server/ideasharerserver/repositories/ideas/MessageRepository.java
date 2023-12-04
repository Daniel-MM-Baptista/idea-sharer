package com.server.ideasharerserver.repositories.ideas;

import com.server.ideasharerserver.models.ideas.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, String> {
}
