package io.myCode.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Movie name cannot be blank")
    private String name;

    @NotBlank(message = "Director name cannot be blank")
    private String director;

    @Size(min = 1, message = "There must be at least one actor")
    @ElementCollection
    private List<String> actors = new ArrayList<>();

    // Default constructor
    public Movie() {}

    // Parameterized constructor
    public Movie(Long id, String name, String director, List<String> actors) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.actors = actors;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", name=" + name + ", director=" + director + ", actors=" + actors + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
			return true;
		}
        if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
        Movie movie = (Movie) obj;
        return id != null && id.equals(movie.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
