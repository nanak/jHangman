<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
html *
{
   font-family: Courier !important;
}
</style>
<title>Se beste Hangman in se W&ouml;rld</title>
</head>
<body>
<h1>Willkommen to se beste Hangman Gejm in se W&ouml;rld!</h1>
<% int hangmanState = (Integer)request.getAttribute("hangmanState"); %> 
<% if (hangmanState == 0) { %>
&nbsp;_________   <br>
&nbsp;|/      |   <br>
&nbsp;|           <br>
&nbsp;|           <br>
&nbsp;|           <br>
&nbsp;|           <br>
&nbsp;|           <br>
_|___        <br>
<% } else if (hangmanState == 1) { %>
&nbsp;_________   <br>
&nbsp;|/      |   <br>
&nbsp;|      (_)  <br>
&nbsp;|           <br>
&nbsp;|           <br>
&nbsp;|           <br>
&nbsp;|           <br>
_|___        <br>
<% } else if (hangmanState == 2) { %>
&nbsp;_________   <br>
&nbsp;|/      |   <br>
&nbsp;|      (_)  <br>
&nbsp;|       |   <br>
&nbsp;|       |   <br>
&nbsp;|           <br>
&nbsp;|           <br>
_|___        <br>
<% } else if (hangmanState == 3) { %>
&nbsp;_________   <br>
&nbsp;|/      |   <br>
&nbsp;|      (_)  <br>
&nbsp;|      \|   <br>
&nbsp;|       |   <br>
&nbsp;|           <br>
&nbsp;|           <br>
_|___        <br>
<% } else if (hangmanState == 4) { %>
&nbsp;_________   <br>
&nbsp;|/      |   <br>
&nbsp;|      (_)  <br>
&nbsp;|      \|/  <br>
&nbsp;|       |   <br>
&nbsp;|           <br>
&nbsp;|           <br>
_|___        <br>
<% } else if (hangmanState == 5) { %>
&nbsp;_________   <br>
&nbsp;|/      |   <br>
&nbsp;|      (_)  <br>
&nbsp;|      \|/  <br>
&nbsp;|       |   <br>
&nbsp;|      /    <br>
&nbsp;|           <br>
_|___        <br>
<% } else if (hangmanState == 6) { %>
&nbsp;_________   <br>
&nbsp;|/      |   <br>
&nbsp;|      (_)  <br>
&nbsp;|      \|/  <br>
&nbsp;|       |   <br>
&nbsp;|      / \  <br>
&nbsp;|           <br>
_|___        <br>
<% } else { %>
<h6>Illegal Hangman State</h6>
<% } %>

Enter a letter
<form class="post_form" action="HangmanServlet" method="post">
	<input id="post_text" name="post_text" type="text" size="1" maxlength="1"/>
	<input type=submit value="Send"/>
</form>

</body>
</html>