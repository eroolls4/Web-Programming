package mk.finki.ukim.mk.lab.servlet;


import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import mk.finki.ukim.mk.lab.model.*;
import mk.finki.ukim.mk.lab.service.*;
import org.thymeleaf.context.*;
import org.thymeleaf.spring6.*;
import org.thymeleaf.web.*;
import org.thymeleaf.web.servlet.*;

import java.io.*;

@WebServlet(urlPatterns = "/addMovie")
public class AddNewMovieServlet extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final MovieService movieService;


    public AddNewMovieServlet(SpringTemplateEngine springTemplateEngine, MovieService movieService) {
        this.springTemplateEngine = springTemplateEngine;
        this.movieService = movieService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);


        System.out.println("AAAAAAAAAAA");
  //      context.setVariable("movies", movieService.listAll());
  //      context.setVariable("userName" ,req.getParameter("userName"));

        context.setVariable("message", "");
        springTemplateEngine.process(
                "addMovie.html",
                context,
                resp.getWriter()
        );
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
