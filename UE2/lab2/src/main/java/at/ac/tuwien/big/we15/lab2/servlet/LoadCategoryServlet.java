package at.ac.tuwien.big.we15.lab2.servlet;

import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.QuestionDataProvider;
import at.ac.tuwien.big.we15.lab2.api.impl.ServletJeopardyFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matze on 18.04.2015.
 */
public class LoadCategoryServlet extends HttpServlet {;
    public void init() throws ServletException {

    }

    public void destroy() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JeopardyFactory factory = new ServletJeopardyFactory(getServletContext());
        QuestionDataProvider provider = factory.createQuestionDataProvider();
        int maxround = 10;
        int round = 1;
        HttpSession session = request.getSession(false);
        //zum categorieaufbau - beinhaltet categorien, kekommt name mit getName. z.B. (TV, SSD, ...). aufbau von geldfelder weiß i nit. nit vorgegeben.
        session.setAttribute("categories", provider.getCategoryData());
        //anzahl der fragen.
        if(session.getAttribute("round") != null){
            if(round > maxround) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/winner.jsp");
                dispatcher.forward(request, response);
            }
            round = (int) session.getAttribute("round") + 1;
        }
        session.setAttribute("round", round);
        response.sendRedirect("/jeopardy.jsp");
        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jeopardy.jsp");
        //dispatcher.forward(request, response);
    }
}
