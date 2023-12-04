package com.server.ideasharerserver.controllers.ideas;

import com.server.ideasharerserver.models.ideas.Idea;
import com.server.ideasharerserver.models.users.User;
import com.server.ideasharerserver.repositories.ideas.IdeaRepository;
import com.server.ideasharerserver.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/ideaApi")
public class IdeaApiController {
    @Autowired
    private IdeaRepository ideaRepository;

    @GetMapping("/ideas")
    public @ResponseBody Iterable<Idea> getIdeas(){
        return ideaRepository.findAll();
    }

    @GetMapping("/ideas/{ideaId}")
    public @ResponseBody Idea getIdea(@PathVariable String ideaId){
        Optional<Idea> ideaQuery = ideaRepository.findById(ideaId);
        return ideaQuery.orElse(null);
    }

    @PostMapping("/ideas")
    public @ResponseBody Idea createIdea(@RequestBody Idea newIdea){
        return ideaRepository.save(newIdea);
    }

    @PutMapping("/ideas/{ideaId}")
    public @ResponseBody Idea editIdea(@PathVariable String ideaId, @RequestBody Idea newIdea){
        if(!ideaId.equals(newIdea.getId())) return null;
        if(ideaRepository.findById(ideaId).isEmpty()) return null;
        return ideaRepository.save(newIdea);
    }

    @DeleteMapping ("/ideas/{ideaId}")
    public @ResponseBody void deleteIdea(@PathVariable String userId){
        ideaRepository.deleteById(userId);
    }
}
