package at.ac.tuwien.big.we15.lab2.servlet;

import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.JeopardyFactory;
import at.ac.tuwien.big.we15.lab2.api.Question;
import at.ac.tuwien.big.we15.lab2.api.QuestionDataProvider;
import at.ac.tuwien.big.we15.lab2.api.impl.ServletJeopardyFactory;

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
        HttpSession session = request.getSession(false);
        //zum ausgrauen
        List<Integer> numbers = new ArrayList<>();
        if(session.getAttribute("selectedQuestionNumbers") != null){
            numbers = (List<Integer>)session.getAttribute("selectedQuestionNumbers");
        }
        numbers.add(Integer.parseInt(request.getParameter("question_selection")));
        session.setAttribute("selectedQuestionNumbers", numbers);
        //fia wert da frage
        List<Integer> moneyHistory = new ArrayList<>();
        if(session.getAttribute("selectedQuestionMoneyHistory") != null){
            moneyHistory = (List<Integer>)session.getAttribute("selectedQuestionMoneyHistory");
        }
        moneyHistory.add(Integer.parseInt(request.getParameter("money")));
        session.setAttribute("selectedQuestionMoneyHistory", moneyHistory);
        //frage in session schreiben
        List<Category> categories = (List<Category>)session.getAttribute("categories");
        for(Category category : categories){
            if(category.getName().equals(request.getParameter("category"))){
                List<Question> questions = category.getQuestions();
                int i = (int)(Math.random()*questions.size());
                session.setAttribute("question", questions.get(i));
                break;
            }
        }
        //RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/question.jsp");
        //dispatcher.forward(request, response);
        response.sendRedirect("/question.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
