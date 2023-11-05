package com.server.chatroomserver.repositories.users;

import com.server.chatroomserver.models.users.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
}
