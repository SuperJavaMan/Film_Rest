package spring.nikitasterlit.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.nikitasterlit.model.Film;

import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
}
