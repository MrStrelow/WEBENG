<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="at.ac.tuwien.big.we14.lab2.api.Choice"%>
<%@page import="java.util.List"%>
<%@page import="at.ac.tuwien.big.we14.lab2.api.Question"%>

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>


<jsp:useBean id="quiz"
	class="at.ac.tuwien.big.we14.lab2.bean.Quiz" scope="session" />

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="de" lang="de">
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Business Informatics Group Quiz</title>
<link rel="stylesheet" type="text/css" href="style/screen.css" />
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/framework.js" type="text/javascript"></script>
</head>
<body id="questionpage">
	<a class="accessibility" href="#question">Zur Frage springen</a>
	<header role="banner" aria-labelledby="mainheading">
		<h1 id="mainheading">
			<span class="accessibility">Business Informatics Group</span> Quiz
		</h1>
	</header>
	<nav role="navigation" aria-labelledby="navheading">
		<h2 id="navheading" class="accessibility">Navigation</h2>
		<ul>
			<li><a id="logoutlink" title="Klicke hier um dich abzumelden"
				href="#" accesskey="l">Abmelden</a></li>
		</ul>
	</nav>

	<!-- round info -->
	<%
		Question currentQuestion = quiz.getQuestion();
		List<Choice> currentChoices = currentQuestion.getAllChoices();
	%>
	<section role="main">
		<section id="roundinfo" aria-labelledby="roundinfoheading">
			<h2 id="roundinfoheading" class="accessibility">Spielerinformationen</h2>
			<div id="player1info">
				<span id="player1name"><%= quiz.getNamePlayer1() %></span>
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
						id="player1answer<%= questionCounter %>" class=incorrect>Falsch</span></li>
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
			</div>
			<div id="player2info">
				<span id="player2name"><%= quiz.getNamePlayer2() %></span>
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
			</div>
			<div id="currentcategory">
				<span class="accessibility">Kategorie:</span> <%= currentQuestion.getCategory().getName() %>
			</div>
		</section>

		<!-- Question -->
		<section id="questionid" aria-labelledby="questionheading" value="<%= currentQuestion.getId() %>" >

			<form id="questionform" action="BigQuizServlet" method="post">
				<h2 id="questionheading" class="accessibility">Frage</h2>
				<p id="questiontext"><%= currentQuestion.getText() %></p>
				<ul id="answers">
					<% 
						int counter = 0;
						for(Choice choice : currentChoices) {
					%>
					<li>
						<input id="option<%= counter %>" name="option<%= counter %>" type="checkbox" />
						<label for="option<%= counter %>" id="labeloption<%= counter %>"><%= choice.getText() %></label>
						<input id="text<%= counter %>" name="text<%= counter %>" type="hidden" value="<%= choice.getText() %>"/>
					</li>
					<%
						counter++;
						} 
					%>
				</ul>
				<input id="timeleftvalue" name="timeleftvalue" type="hidden" value="100" /> 
				<input id="next" type="submit" value="weiter" accesskey="s" />
			</form>
		</section>

		<section id="timer" aria-labelledby="timerheading">
			<h2 id="timerheading" class="accessibility">Timer</h2>
			<p>
				<span id="timeleftlabel">Verbleibende Zeit:</span>
				<time id="timeleft">00:30</time>
			</p>
			<meter id="timermeter" min="0" low="20" value="100" max="100" />
		</section>

		<section id="lastgame">
			<p id="lastgameText">Letztes Spiel: Nie</p>
		</section>
	</section>

	<!-- footer -->
	<footer role="contentinfo">© 2014 BIG Quiz</footer>

	<script type="text/javascript">
		//<![CDATA[

		// initialize time
		$(document).ready(function() {
			var maxtime = <%= currentQuestion.getMaxTime() %>;
			var hiddenInput = $("#timeleftvalue");
			var meter = $("#timer meter");
			var timeleft = $("#timeleft");
			var lastgameText = $("#lastgameText");

			hiddenInput.val(maxtime);
			meter.val(maxtime);
			meter.attr('max', maxtime);
			meter.attr('low', maxtime / 100 * 20);
			timeleft.text(secToMMSS(maxtime));
			
			if(supportsLocalStorage()) {
				if (localStorage.lastgame) {
					lastgameText.text("Letztes Spiel: " + localStorage.lastgame);
				}
			}
		});

		// update time
		function timeStep() {
			var hiddenInput = $("#timeleftvalue");
			var meter = $("#timer meter");
			var timeleft = $("#timeleft");

			var value = $("#timeleftvalue").val();
			if (value > 0) {
				value = value - 1;
			}

			hiddenInput.val(value);
			meter.val(value);
			timeleft.text(secToMMSS(value));

			if (value <= 0) {
				$('#questionform').submit();
			}
		}

		window.setInterval(timeStep, 1000);

		//]]>
	</script>
</body>
</html>
