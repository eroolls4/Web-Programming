package mk.finki.ukim.mk.lab.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.thymeleaf.context.*;
import org.thymeleaf.spring6.*;
import org.thymeleaf.web.*;
import org.thymeleaf.web.servlet.*;

import java.io.*;
import java.util.*;

@WebServlet(urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public HistoryServlet(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        context.setVariable("userName", req.getSession().getAttribute("userName"));

        // Get the list of movies from the user's session (if available)
        Set<String> movieList = (Set<String>) req.getSession().getAttribute("movieList");
        context.setVariable("movieList", movieList);

        springTemplateEngine.process("history.html", context, resp.getWriter());
    }
}
