package com.server.ideasharerserver.repositories.ideas;

import com.server.ideasharerserver.models.ideas.Favorite;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteRepository extends CrudRepository<Favorite, String> {
}
