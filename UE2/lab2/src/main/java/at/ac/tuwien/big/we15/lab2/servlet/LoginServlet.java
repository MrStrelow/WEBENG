package at.ac.tuwien.big.we15.lab2.servlet;

import at.ac.tuwien.big.we15.lab2.api.impl.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Matze on 18.04.2015.
 */
public class LoginServlet extends HttpServlet {

    public void init() throws ServletException {

    }

    public void destroy() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = new User(request.getParameter("username"), request.getParameter("password"));
        session.setAttribute("user", user);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/CategoryServlet");
        dispatcher.forward(request, response);
    }
}
