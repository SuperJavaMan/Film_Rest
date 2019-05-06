package spring.nikitasterlit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.nikitasterlit.model.Actor;
import spring.nikitasterlit.model.Film;
import spring.nikitasterlit.repository.ActorRepository;
import spring.nikitasterlit.repository.FilmRepository;

import java.util.List;
import java.util.Set;

@RestController
public class FilmController {

    @Autowired
    ActorRepository actorRepository;

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/film")
    public List<Film> getFilms (){return filmRepository.findAll();}
    @GetMapping("/film/{id}")
    public Film getFilmById(@PathVariable("id")long id){return filmRepository.findById(id).get();}

    @GetMapping("/filmlist/{actorid}")
    public Set<Film> getFilmsByActorId(@PathVariable("actorid")long id){
        return actorRepository.findById(id).get().getFilms();
    }
    @GetMapping("/film/actor/{filmid}/{actorid}")
    public Actor addFilmToActor(@PathVariable ("filmid")long filmid, @PathVariable ("actorid")long actorid){
        Film film = filmRepository.findById(filmid).get();
        Actor actor = actorRepository.findById(actorid).get();
        Set<Actor> setActor = film.getActors();
        setActor.add(actor);
        return actorRepository.save(actor);

    }

    @PostMapping("/film")
    public Film addFilm(@RequestBody Film film){return filmRepository.save(film);}
    @PostMapping("/film/{filmid}/actor")
    public Film addActorToFilm(@RequestBody Actor actor, @PathVariable("filmid")long id){
        Film film = filmRepository.findById(id).get();
        Set<Actor> setActor = film.getActors();
        setActor.add(actor);
        film.setActors(setActor);
        return filmRepository.save(film);
    }
}
