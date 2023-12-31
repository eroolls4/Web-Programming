package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.*;
import mk.finki.ukim.mk.lab.repository.*;
import mk.finki.ukim.mk.lab.service.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class MoveServiceImpl implements MovieService {
    private final InMemoryMovieRepository inMemoryMovieRepository;

    public MoveServiceImpl(InMemoryMovieRepository inMemoryMovieRepository) {
        this.inMemoryMovieRepository = inMemoryMovieRepository;
    }

    @Override
    public List<Movie> listAll() {
        return inMemoryMovieRepository.findAll();
    }

    @Override
    public List<Movie> searchMovies(String text, String rating) {
        return inMemoryMovieRepository.searchMovies(text, rating);
    }

    @Override
    public void addMovie(Movie movie) {
        inMemoryMovieRepository.addMovie(movie);
    }

    @Override
    public void updateRating(String title, double newRating) {
        // Find the movie with the given title
        Movie movieToUpdate = inMemoryMovieRepository.findByTitle(title);

        if (movieToUpdate != null) {

            movieToUpdate.setRating(newRating);
        } else {

         //   throw new MovieNotFoundException("Movie with title " + title + " not found");
        }
    }
}
