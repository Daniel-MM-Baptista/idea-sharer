package com.server.chatroomserver.controllers.users;

import com.server.chatroomserver.models.users.User;
import com.server.chatroomserver.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userApi")
public class UserApiController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public @ResponseBody Iterable<User> getUsers(){
        return userRepository.findAll();
    }
}
