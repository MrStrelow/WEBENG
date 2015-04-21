package at.ac.tuwien.big.we15.lab2.servlet;

import at.ac.tuwien.big.we15.lab2.api.Category;
import at.ac.tuwien.big.we15.lab2.api.Question;
import at.ac.tuwien.big.we15.lab2.api.User;

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
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        //zum ausgrauen
        int questionNr = Integer.parseInt(request.getParameter("question_selection"));
        String[] moneyGes = request.getParameterValues("money");
        int money = Integer.parseInt(moneyGes[questionNr]);
        String selectedCategory = request.getParameter("category");
        List<Category> categories = (List<Category>) session.getAttribute("categories");
        Question question = possibleQuestion(getCategory(categories, selectedCategory).getQuestions(), money);
        user.setQuestionNr(questionNr);
        user.setQuestion(question);
        //frage->user in session schreiben
        session.setAttribute("user", user);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/question.jsp");
        dispatcher.forward(request, response);
        //response.sendRedirect("/question.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    private Question possibleQuestion(List<Question> questions, int money) {
        List<Question> list = new ArrayList<>();
        for (Question question : questions) {
            if (question.getValue() == money) {
                list.add(question);
            }
        }

        Question ret = list.get((int)(Math.random()*list.size()));
        return ret;
    }

    private Category getCategory(List<Category> categories, String categoryName) {
        Category ret = null;
        for (Category category : categories) {
            if (category.getName().equals(categoryName)) {
                ret = category;
                break;
            }
        }
        return ret;
    }
}
