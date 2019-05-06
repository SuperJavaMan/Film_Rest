package spring.nikitasterlit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.nikitasterlit.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
}
