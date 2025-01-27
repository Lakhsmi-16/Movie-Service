package io.myCode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.myCode.exception.InvalidDataException;
import io.myCode.exception.MovieNotFoundException;
import io.myCode.model.Movie;
import io.myCode.repo.MovieRepo;


@Service
@Transactional
public class MovieService {

    @Autowired
    private MovieRepo movieRepository;

    // CRUD operation - Creat, Read, Update, Delete

    public Movie create(Movie movie) {

        if (movie == null) {
            throw new InvalidDataException("Invalid movie: null");
        }

        return movieRepository.save(movie);
    }

    public Movie read(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + id));
    }

    public void update(Long id, Movie update) {
        if (update == null || id == null) {
            throw new InvalidDataException("Invalid movie: null");
        }

        // Check if exists
        if (movieRepository.existsById(id)) {
            Movie movie = movieRepository.getReferenceById(id);
            movie.setName(update.getName());
            movie.setDirector(update.getDirector());
            movie.setActors(update.getActors());
            movieRepository.save(movie);
        } else {
            throw new MovieNotFoundException("Movie not found with id: " + id);
        }
    }

    public void delete(Long id) {
        if (movieRepository.existsById(id)) {
            movieRepository.deleteById(id);
        } else {
            throw new MovieNotFoundException("Movie not found with id: " + id);
        }
    }
}