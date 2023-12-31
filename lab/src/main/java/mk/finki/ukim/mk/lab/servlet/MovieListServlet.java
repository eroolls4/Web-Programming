package mk.finki.ukim.mk.lab.servlet;



import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import mk.finki.ukim.mk.lab.service.*;
import org.thymeleaf.context.*;
import org.thymeleaf.spring6.*;
import org.thymeleaf.web.*;
import org.thymeleaf.web.servlet.*;

import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "")
public class MovieListServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final MovieService movieService;

    public MovieListServlet(SpringTemplateEngine springTemplateEngine, MovieService movieService) {
        this.springTemplateEngine = springTemplateEngine;
        this.movieService = movieService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        context.setVariable("movies", movieService.listAll());
        context.setVariable("userName" ,req.getParameter("userName"));

        springTemplateEngine.process(
                "listMovies.html",
                context,
                resp.getWriter()
        );

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        if (userName != null) {
            req.getSession().setAttribute("userName", userName);
        }
        String title = req.getParameter("radio");
        if (title != null) {
            int tickets = Integer.parseInt(req.getParameter("numTickets"));
         //   System.out.println(title + tickets);
            resp.sendRedirect("/ticketOrder?title=" + title + "&tickets=" + tickets + "&userName=" + req.getParameter("userName"));

            Set<String> movieList = (Set<String>) req.getSession().getAttribute("movieList");
            if (movieList == null) {
                movieList = new HashSet<>();
            }
            movieList.add(title);
            req.getSession().setAttribute("movieList", movieList);
        }
    }


}