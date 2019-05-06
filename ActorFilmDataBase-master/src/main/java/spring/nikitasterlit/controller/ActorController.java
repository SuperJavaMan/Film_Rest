package spring.nikitasterlit.controller;

import org.apache.el.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.nikitasterlit.model.Actor;
import spring.nikitasterlit.model.Film;
import spring.nikitasterlit.repository.ActorRepository;
import spring.nikitasterlit.repository.FilmRepository;

import java.util.List;
import java.util.Set;

@RestController
public class ActorController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/actor")
    public List<Actor> getAllActors(){return actorRepository.findAll();}

    @GetMapping("/actor/{id}")
    public Actor findById(@PathVariable ("id")long id){return actorRepository.findById(id).get();}

    @PostMapping("/actor")
    public Actor post(@RequestBody Actor actor){
        //Stream.
        return actorRepository.save(actor);}

    //PostMapping("/actor/film/{filmid}")
    //ublic Actor postActor(@RequestBody Actor actor, @PathVariable("filmid")long id){
    //  Film film = filmRepository.findById(id).get();
    //  Set<Actor> actorList = film.getActors();
    //  actorList.add(actor);
    //  film.setActors(actorList);
    //  return actorRepository.save(actorList);
    //  // return filmRepository.findById(id).map(actor -> List<>)
    //}
    @PutMapping("/actor/{actorid}")
    public Actor elitActor(@PathVariable("actorid")long id, @RequestBody Actor actor){
        Actor actor1 = actorRepository.findById(id).get();
        actor1.setFirstName(actor.getFirstName());
        actor1.setLastName(actor.getLastName());
        actor1.setGenre(actor.getGenre());
        return actorRepository.save(actor1);
    }

    @DeleteMapping("/actor/{id}")
    public String deletePost(@PathVariable("id")long id){
        actorRepository.deleteById(id);
        return "actor delete";
    }
}
