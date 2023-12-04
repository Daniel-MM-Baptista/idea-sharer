package com.server.ideasharerserver.repositories.ideas;

import com.server.ideasharerserver.models.ideas.Idea;
import org.springframework.data.repository.CrudRepository;

public interface IdeaRepository extends CrudRepository<Idea, String> {
}
