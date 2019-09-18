<%@ page import="Korisnik.Korisnik" %><%--
  Created by IntelliJ IDEA.
  User: Filip
  Date: 10/25/2018
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<button onclick="pozovi()"> POZOVI</button>
<div id="nista">nista</div>
<%
    out.print("OVO JE");
%>

<script>
    function pozovi() {
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (xhttp.readyState === 4) {
                document.getElementById("nista").innerHTML=xhttp.responseText;
            }
        };
        let url = "http://localhost:8080/eksper";
        alert(url);
        xhttp.open("POST", url, true);
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

        xhttp.send("id=idi");
    }
</script>
</body>
</html>