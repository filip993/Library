<%--
  Created by IntelliJ IDEA.
  User: Filip
  Date: 1/7/2019
  Time: 1:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .tags {
            background-color: #e2dcc5;
            border-style: solid;
            display: inline-block;

        }
    </style>
</head>
<body>
<%
    for(int i =0;i<5;i++) {
        out.println("<span class= \"tags\">");
        out.println("OVO JE TAG");
        out.println("</span>");

    }
%>
</body>
</html>
