package at.ac.tuwien.big.we15.lab2.servlet;

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
public class SubmitCategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //zum ausgrauen
        List<Integer> numbers = new ArrayList<>();
        numbers.add(Integer.parseInt(request.getParameter("question_selection")));
        session.setAttribute("selectedQuestionNumbers", numbers);
        //fia wert da frage
        List<Integer> moneyHistory = new ArrayList<>();
        moneyHistory.add(Integer.parseInt(request.getParameter("money")));
        session.setAttribute("selectedQuestionMoneyHistory", moneyHistory);
        //redir
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/question.jsp");
        dispatcher.forward(request, response);
    }
}
