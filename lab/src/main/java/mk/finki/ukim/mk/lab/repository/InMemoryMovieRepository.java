package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.bootstrap.*;
import mk.finki.ukim.mk.lab.model.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Repository
public class InMemoryMovieRepository {



    public List<Movie> findAll(){
        return DataHolder.movies;
    }

    public List<Movie> searchMovies(String text, String rating){
        if (Objects.equals(text, "") && Objects.equals(rating, "")){
            return DataHolder.movies;
        }
        else if (Objects.equals(text, "")){
            return DataHolder.movies
                    .stream()
                    .filter(x->x.getRating() >= Float.parseFloat(rating))
                    .collect(Collectors.toList());
        }
        else if (Objects.equals(rating, "")){
            return DataHolder.movies
                    .stream()
                    .filter(x->x.getTitle().contains(text)
                            || x.getSummary().contains(text))
                    .collect(Collectors.toList());
        }
        else {
            return DataHolder.movies
                    .stream()
                    .filter(x->(x.getTitle().contains(text)
                            || x.getSummary().contains(text)) &&
                            x.getRating() >= Float.parseFloat(rating))
                    .collect(Collectors.toList());
        }
    }


    public void addMovie(Movie movie) {
        DataHolder.movies.add(movie);
    }

}
