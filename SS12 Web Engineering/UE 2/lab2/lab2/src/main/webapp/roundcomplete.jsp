<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.util.ArrayList"%>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>

<jsp:useBean id="quiz"
	class="at.ac.tuwien.big.we14.lab2.bean.Quiz" scope="session" />

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
    <head>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Business Informatics Group Quiz - Zwischenstand</title>
        <link rel="stylesheet" type="text/css" href="style/screen.css" />
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/framework.js" type="text/javascript"></script>
    </head>
    <body id="winnerpage">
        <a class="accessibility" href="#roundwinner">Zur Rundenwertung springen</a>
        <header role="banner" aria-labelledby="mainheading"><h1 id="mainheading"><span class="accessibility">Business Informatics Group</span> Quiz</h1></header>
        <nav role="navigation" aria-labelledby="navheading">
            <h2 id="navheading" class="accessibility">Navigation</h2>
            <ul>
                <li><a id="logoutlink" title="Klicke hier um dich abzumelden" href="#" accesskey="l">Abmelden</a></li>
            </ul>
        </nav>
        
        <section role="main">
            <!-- winner message -->
            <section id="roundwinner" aria-labelledby="roundwinnerheading">
                <h2 id="roundwinnerheading" class="accessibility">Rundenzwischenstand</h2>
                <% 
                	String winner = (String) request.getAttribute("winner");
               		winner += " Round " + quiz.getRounds();
                %>
                <p class="roundwinnermessage"><%= winner %></p>
            </section>
        
            <!-- round info -->    
            <section id="roundinfo" aria-labelledby="roundinfoheading">
                <h2 id="roundinfoheading" class="accessibility">Spielerinformationen</h2>
                <div id="player1info" class="playerinfo">
                    <span id="player1name" class="playername"><%= quiz.getNamePlayer1() %></span>
                    <ul class="playerroundsummary">
                        <% 
						ArrayList<Boolean> answersPlayer1 = quiz.getAnswersPlayer1();
						int dif = 3 - answersPlayer1.size();
						int questionCounter = 0;
						for(Boolean answer : answersPlayer1) {
							if(answer) {
					%>
						<li><span class="accessibility">Frage <%= questionCounter %>:</span><span
						id="player1answer<%= questionCounter %>" class="correct">Richtig</span></li>
					<%
							} else {
					%>
						<li><span class="accessibility">Frage <%= questionCounter %>:</span><span
						id="player1answer<%= questionCounter %>" class="incorrect">Falsch</span></li>
					<%
							}
							questionCounter++;
						}
						
						if(dif != 0) {
							for(int i = 0; i < dif; i++) {
					%>
						<li><span class="accessibility">Frage <%= questionCounter %>:</span><span
						id="player1answer<%= questionCounter %>" class="unknown">Unbekannt</span></li>
					<%
								questionCounter++;
							}
						}
					%>
                    </ul>
                    <p id="player1roundcounter" class="playerroundcounter">Gewonnene Runden: <span id="player1wonrounds" class="playerwonrounds"><%= quiz.getPointsPlayer1() %></span></p>
                </div>
                <div id="player2info" class="playerinfo">
                    <span id="player2name" class="playername"><%= quiz.getNamePlayer2() %></span>
                    <ul class="playerroundsummary">
                        <% 
						ArrayList<Boolean> answersPlayer2 = quiz.getAnswersPlayer2();
						dif = 3 - answersPlayer2.size();
						questionCounter = 0;
						for(Boolean answer : answersPlayer2) {
							if(answer) {
					%>
						<li><span class="accessibility">Frage <%= questionCounter %>:</span><span
						id="player2answer<%= questionCounter %>" class="correct">Richtig</span></li>
					<%
							} else {
					%>
						<li><span class="accessibility">Frage <%= questionCounter %>:</span><span
						id="player2answer<%= questionCounter %>" class="incorrect">Falsch</span></li>
					<%
							}
							questionCounter++;
						}
						
						if(dif != 0) {
							for(int i = 0; i < dif; i++) {
					%>
						<li><span class="accessibility">Frage <%= questionCounter %>:</span><span
						id="player2answer<%= questionCounter %>" class="unknown">Unbekannt</span></li>
					<%
								questionCounter++;
							}
						}
					%>
                    </ul>
                    <p id="player2roundcounter" class="playerroundcounter">Gewonnene Runden: <span id="player2wonrounds" class="playerwonrounds"><%= quiz.getPointsPlayer2() %></span></p>
                </div>
                <a id="next" href="BigQuizServlet">Weiter</a>
            </section>
        </section>

        <!-- footer -->
        <footer role="contentinfo">© 2014 BIG Quiz</footer>
    </body>
</html>
