package at.ac.tuwien.big.we15.lab2.servlet;

import at.ac.tuwien.big.we15.lab2.api.Answer;
import at.ac.tuwien.big.we15.lab2.api.impl.KI;
import at.ac.tuwien.big.we15.lab2.api.impl.QuestionAnswerer;
import at.ac.tuwien.big.we15.lab2.api.impl.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Matze on 18.04.2015.
 */
public class QuestionServlet extends HttpServlet {

    public void init() throws ServletException {

    }

    public void destroy() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String[] answers = request.getParameterValues("answers");
        session.getAttribute("question");
        QuestionAnswerer answerer = new QuestionAnswerer();
        User user = (User)session.getAttribute("user");

        if(answerer.check(answers)){
            user.setMoney(user.getMoney() + ((List<Integer>) session.getAttribute("selectedQuestionMoneyHistory")).get(((List<Integer>) session.getAttribute("selectedQuestionMoneyHistory")).size() - 1));
        }
        else{
            user.setMoney(user.getMoney() - ((List<Integer>)session.getAttribute("selectedQuestionMoneyHistory")).get(((List<Integer>) session.getAttribute("selectedQuestionMoneyHistory")).size()-1));
        }
        //ki spielt
        KI ki = new KI();
        User kiUser = ki.start();
        session.setAttribute("kiUser", kiUser);
        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoadCategoryServlet");
        //dispatcher.forward(request, response);
        response.sendRedirect("/LoadCategoryServlet");
    }
}
