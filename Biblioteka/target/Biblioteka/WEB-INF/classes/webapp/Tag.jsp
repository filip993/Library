<%@ page import="Tagovi.BookTag" %><%--
  Created by IntelliJ IDEA.
  User: Filip
  Date: 1/7/2019
  Time: 11:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> WELCOME TO TAGS</h1>
<%

    BookTag bt =(BookTag) request.getAttribute("BookTags");
    for(int i = 0;i<bt.getBooks().size();i++) {
        out.println("<div class=\"tags\">");
        int id = bt.getBooks().get(i).getIdBooks();
        String book =bt.getBooks().get(i).getBookName();
        String stranica =" http://localhost:8080/Book?id=" + id ;
        out.print("<a href=" + stranica + ">" + book + " </a>");

        out.println("</div>");
    }

%>
</body>
</html>
