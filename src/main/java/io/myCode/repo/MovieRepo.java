package io.myCode.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.myCode.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
    // Custom query to find movies by director
    List<Movie> findByDirector(String director);

    // Custom query to find movies by actor
    List<Movie> findByActorsContaining(String actor);

    // Paginated query for movies by director
    Page<Movie> findByDirector(String director, Pageable pageable);


 // Method to check if a movie with the given name already exists
    boolean existsByName(String name);
}
