package mk.finki.ukim.mk.lab.bootstrap;


import jakarta.annotation.*;
import lombok.*;
import mk.finki.ukim.mk.lab.model.*;
import org.springframework.stereotype.*;

import java.util.*;

@Getter
@Component
public class DataHolder {

    public static List<Movie> movies = new ArrayList<>();


    @PostConstruct
    public void init() {
        movies.add(new Movie("The Shawshank Redemption", "Drama", 9.3));
        movies.add(new Movie("The Godfather", "Crime", 9.2));
        movies.add(new Movie("Inception", "Sci-Fi", 8.8));
        movies.add(new Movie("Pulp Fiction", "Crime", 8.9));
        movies.add(new Movie("The Dark Knight", "Action", 9.0));
        movies.add(new Movie("Forrest Gump", "Drama", 8.8));
        movies.add(new Movie("The Matrix", "Sci-Fi", 8.7));
        movies.add(new Movie("The Fellowship of the Ring", "Fantasy", 8.8));
        movies.add(new Movie("A New Hope", "Sci-Fi", 8.6));
        movies.add(new Movie("The Silence of the Lambs", "Thriller", 8.6));
    }

}
