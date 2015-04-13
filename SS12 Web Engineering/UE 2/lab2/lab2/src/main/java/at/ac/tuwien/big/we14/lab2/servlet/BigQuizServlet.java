package at.ac.tuwien.big.we14.lab2.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import at.ac.tuwien.big.we14.lab2.api.Choice;
import at.ac.tuwien.big.we14.lab2.api.impl.SimpleChoice;
import at.ac.tuwien.big.we14.lab2.bean.HumanPlayer;
import at.ac.tuwien.big.we14.lab2.bean.PlayerQuestion;
import at.ac.tuwien.big.we14.lab2.bean.Quiz;
import at.ac.tuwien.big.we14.lab2.exception.EmptyException;
import at.ac.tuwien.big.we14.lab2.service.QuestionService;

public class BigQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);

		if (session.getAttribute("startQuiz") != null) {

			if ((Boolean) session.getAttribute("startQuiz")) {
				try {
					Quiz quiz = new Quiz("Spieler 1", new QuestionService(
							getServletContext()));
					session.setAttribute("quiz", quiz);
					session.setAttribute("startQuiz", false);
					System.out.println("Quiz has been added.");
				} catch (EmptyException e) {
					e.printStackTrace();
				}
			}

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("question.jsp");
			dispatcher.forward(request, response);
			
		} else {

			session.setAttribute("startQuiz", true);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("start.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);

		Quiz quiz = (Quiz) session.getAttribute("quiz");

		int sizeOfAnswers = quiz.getLastQuestion().getAllChoices().size();
		List<Choice> answers = new ArrayList<Choice>();

		for (int i = 0; i < sizeOfAnswers; i++) {
			boolean checked = request.getParameter("option" + i) != null;
			if (checked) {
				String answerText = request.getParameter("text" + i);
				answers.add(new SimpleChoice(answerText, quiz.getLastQuestion()));
			}
		}
		
		System.out.println(answers);

		String retQuiz = null;
		try {
			if (quiz.isKiQuiz()) {
				Long timeleft = Long.parseLong(request
						.getParameter("timeleftvalue"));

				if (quiz.calculate(quiz.getLastQuestion(), answers)) {
					retQuiz = quiz.addQuestion(new PlayerQuestion(true,
							timeleft));
				} else {
					retQuiz = quiz.addQuestion(new PlayerQuestion(false,
							timeleft));
				}
			} else {
				// TODO
			}
		} catch (EmptyException e) {
			e.printStackTrace();
		}

		if (retQuiz != null) {
			System.out.println(retQuiz);

			if (retQuiz.equals("Just a normal Question.")) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("question.jsp");
				dispatcher.forward(request, response);
			} else if (quiz.currentQuestion() == 0 && quiz.getRounds() != 5) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("roundcomplete.jsp");
				request.setAttribute("winner", retQuiz);
				dispatcher.forward(request, response);
			} else if (quiz.currentQuestion() == 0 && quiz.getRounds() == 5) {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("finish.jsp");
				request.setAttribute("winner", retQuiz);
				session.setAttribute("startQuiz", true);
				dispatcher.forward(request, response);
			}
		}
	}
}
