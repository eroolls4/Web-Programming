package mk.finki.ukim.mk.lab.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import mk.finki.ukim.mk.lab.service.*;
import org.thymeleaf.context.*;
import org.thymeleaf.spring6.*;
import org.thymeleaf.web.*;
import org.thymeleaf.web.servlet.*;

import java.io.*;

@WebServlet(urlPatterns = "/changeRating")
public class ChangeRatingServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final MovieService movieService;

    public ChangeRatingServlet(SpringTemplateEngine springTemplateEngine, MovieService movieService) {
        this.springTemplateEngine = springTemplateEngine;
        this.movieService = movieService;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange exchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(exchange);

        context.setVariable("message" , "");

        System.out.println("bbbbbbbbb");

        springTemplateEngine.process("changeRating.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("movieTitle");
        double newRating = Double.parseDouble(req.getParameter("newRating"));

        movieService.updateRating(title, newRating);

        resp.sendRedirect("/");
    }
}

