package spring.nikitasterlit.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.naming.Name;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @NotNull
    @Size(max = 50)
    private String name;

    @NotNull
    @Size(max = 50)
    private String title;

    //@ManyToMany(fetch = FetchType.LAZY,
//
    //        mappedBy = "films")
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "actor_films",
            joinColumns = { @JoinColumn(name = "films_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
    @JsonBackReference
    private Set<Actor> actors = new HashSet<>();

    public Film(String name, String title, Set<Actor> actors) {
        this.name = name;
        this.title = title;
        this.actors = actors;
    }

    public Film() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}
