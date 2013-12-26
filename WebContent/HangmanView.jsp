<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import = "jHangman.HangmanServlet" %>
<%
HangmanServlet hs = new HangmanServlet();
int hangmanState = hs.getHangmanState();
%>
<% if (hangmanState == 0) { %>
     _________   
     |/      |   
     |           
     |           
     |           
     |           
     |           
    _|___        
<% } %>
<% if (hangmanState == 1) { %>
     _________   
     |/      |   
     |      (_)  
     |           
     |           
     |           
     |           
    _|___        
<% } %>
<% if (hangmanState == 2) { %>
     _________   
     |/      |   
     |      (_)  
     |       |   
     |       |   
     |           
     |           
    _|___        
<% } %>
<% if (hangmanState == 3) { %>
     _________   
     |/      |   
     |      (_)  
     |      \|   
     |       |   
     |           
     |           
    _|___        
<% } %>
<% if (hangmanState == 4) { %>
     _________   
     |/      |   
     |      (_)  
     |      \|/  
     |       |   
     |           
     |           
    _|___        
<% } %>
<% if (hangmanState == 5) { %>
     _________   
     |/      |   
     |      (_)  
     |      \|/  
     |       |   
     |      /    
     |           
    _|___        
<% } %>
<% if (hangmanState == 6) { %>
     _________   
     |/      |   
     |      (_)  
     |      \|/  
     |       |   
     |      / \  
     |           
    _|___        
<% } %>

</body>
</html>