package com.server.ideasharerserver.controllers.users;

import com.server.ideasharerserver.models.users.User;
import com.server.ideasharerserver.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/userApi")
public class UserApiController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public @ResponseBody Iterable<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{userId}")
    public @ResponseBody User getUser(@PathVariable String userId){
        Optional<User> userQuery = userRepository.findById(userId);
        return userQuery.orElse(null);
    }

    @PostMapping("/users")
    public @ResponseBody User createUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @PutMapping("/users/{userId}")
    public @ResponseBody User editUser(@PathVariable String userId, @RequestBody User newUser){
        if(!userId.equals(newUser.getId())) return null;
        if(userRepository.findById(userId).isEmpty()) return null;
        return userRepository.save(newUser);
    }

    @DeleteMapping ("/users/{userId}")
    public @ResponseBody void deleteUser(@PathVariable String userId){
        userRepository.deleteById(userId);
    }
}
