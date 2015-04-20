package at.ac.tuwien.big.we15.lab2.servlet;

import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.QuestionDataProvider;
import at.ac.tuwien.big.we15.lab2.api.impl.ServletJeopardyFactory;
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
public class LoadCategoryServlet extends HttpServlet {;
    public void init() throws ServletException {

    }

    public void destroy() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        JeopardyFactory factory = new ServletJeopardyFactory(getServletContext());
        QuestionDataProvider provider = factory.createQuestionDataProvider();
        HttpSession session = request.getSession(false);
        int maxround = 10;
        User user = (User)session.getAttribute("user");
        int round = user.getRound();
        //zum categorieaufbau - beinhaltet categorien, kekommt name mit getName. z.B. (TV, SSD, ...). aufbau von geldfelder weiß i nit. nit vorgegeben.
        session.setAttribute("categories", provider.getCategoryData());
        //anzahl der fragen.
        if(round >= maxround) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/winner.jsp");
            dispatcher.forward(request, response);
        }
        user.setRound(round + 1);
        session.setAttribute("user", user);

        //response.sendRedirect("/jeopardy.jsp");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jeopardy.jsp");
        dispatcher.forward(request, response);
    }
}
