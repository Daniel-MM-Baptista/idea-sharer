package com.server.ideasharerserver.repositories.users;

import com.server.ideasharerserver.models.users.Theme;
import org.springframework.data.repository.CrudRepository;

public interface ThemeRepository extends CrudRepository<Theme, String> {
}
