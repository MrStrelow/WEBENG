package at.ac.tuwien.big.we15.lab2.servlet;

import at.ac.tuwien.big.we15.lab2.api.impl.QuestionAnswerer;
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
public class QuestionServlet extends HttpServlet {

    public void init() throws ServletException {

    }

    public void destroy() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] answers = request.getParameterValues("answers");
        QuestionAnswerer answerer = new QuestionAnswerer();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        if(answerer.check(answers)){
            user.setMoney(user.getMoney() + (int)session.getAttribute("selectedQuestionMoney"));
        }
        else{
            user.setMoney(user.getMoney() - (int)session.getAttribute("selectedQuestionMoney"));
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoadCategoryServlet");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
