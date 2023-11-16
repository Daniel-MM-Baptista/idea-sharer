package com.server.ideasharerserver.repositories.users;

import com.server.ideasharerserver.models.users.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
