package spring.nikitasterlit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table( name = "actor")
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(max = 30)
    @Column (name = "first_name")
    private String firstName;

    @NotNull
    @Size(max = 30)
    @Column (name = "last_name")
    private String lastName;

    @NotNull
    @Size
    @Column(name = "genre")
    private String genre;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "actor_films",
            joinColumns = { @JoinColumn(name = "actor_id") },
            inverseJoinColumns = { @JoinColumn(name = "films_id") })
   // @JsonBackReference
    private Set<Film> films = new HashSet<>();

    public Actor(String firstName, String lastName,String genre, Set<Film> films) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.genre = genre;
        this.films = films;
    }

    public Actor() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
