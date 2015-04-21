package at.ac.tuwien.big.we15.lab2.servlet;

import at.ac.tuwien.big.we15.lab2.api.KI;
import at.ac.tuwien.big.we15.lab2.api.QuestionAnswerer;
import at.ac.tuwien.big.we15.lab2.api.User;
import at.ac.tuwien.big.we15.lab2.api.impl.SimpleKI;
import at.ac.tuwien.big.we15.lab2.api.impl.SimpleQuestionAnswerer;

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
public class QuestionServlet extends HttpServlet {

    public void init() throws ServletException {

    }

    public void destroy() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String[] answers = request.getParameterValues("answers");
        QuestionAnswerer answerer = new SimpleQuestionAnswerer();
        User user = (User) session.getAttribute("user");

        if (answerer.check(answers)) {
            user.setSaldo(user.getSaldo() + user.getQuestion().getValue());
        } else {
            user.setSaldo(user.getSaldo() - user.getQuestion().getValue());
        }
        //ki spielt
        KI ki = new SimpleKI();
        if (session.getAttribute("ki") != null) {
            ki = (KI) session.getAttribute("ki");
        }
        User kiUser = ki.start();
        session.setAttribute("ki", ki);
        System.out.println(kiUser.getQuestion() + "_" + kiUser.getQuestionNr() + "_" + kiUser.getRound() + "_" + kiUser.getSaldo());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoadCategoryServlet");
        dispatcher.forward(request, response);
        //response.sendRedirect("/LoadCategoryServlet");
    }
}
