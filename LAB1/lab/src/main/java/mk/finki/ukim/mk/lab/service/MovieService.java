package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.*;

import java.util.*;

public interface MovieService {

    List<Movie> listAll();
    List<Movie> searchMovies(String text, String rating);
}
