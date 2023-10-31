package mk.finki.ukim.mk.lab.servlet;


import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import mk.finki.ukim.mk.lab.model.*;
import mk.finki.ukim.mk.lab.service.*;
import org.thymeleaf.spring6.*;

import java.io.*;

@WebServlet(urlPatterns = "/addMovie")
public class AddNewMovie  extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final MovieService movieService;


    public AddNewMovie(SpringTemplateEngine springTemplateEngine, MovieService movieService) {
        this.springTemplateEngine = springTemplateEngine;
        this.movieService = movieService;
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String genre = req.getParameter("genre");
        double rating = Double.parseDouble(req.getParameter("rating"));

        movieService.addMovie(new Movie(title, genre, rating));

        resp.sendRedirect("/");
    }
}
