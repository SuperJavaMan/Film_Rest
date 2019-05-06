package spring.nikitasterlit.service;


import spring.nikitasterlit.model.Actor;

import java.util.List;

public interface ActorService {
    Actor addActor(Actor actor);
    void deleteBank(long id);
    Actor editActor(Actor actor);
    Actor findById(long id);
    List<Actor> findAll();
}
