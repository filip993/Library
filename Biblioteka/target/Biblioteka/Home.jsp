<%@ page import="Korisnik.Korisnik" %><%--
  Created by IntelliJ IDEA.
  User: Filip
  Date: 11/1/2018
  Time: 9:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> WELCOME </title>
    <style>
        .sidebar {
            float:left;
        }
        .visible {

        }

        .right, .left {
            width: 33%;
        }

        .flex-container {
            display: flex;
            justify-content: space-around;
            align-items: center;
            background-color: DodgerBlue;
            height: 50px;
        }
        .desno {
            float: right;
        }
        #cent {
            position: relative;
        }
        #insidecent {
            position: absolute;
            width:100%;
            height: 300px;
            border-style: double;
            z-index: 1;
            top:20px;
            display:none;
        }
    </style>

</head>
<body>

<div class="flex-container">
    <div class="left all">
        <div class="recomendation"> Book Recomendation </div>
    </div>
    <div class="center all">
        <div id="cent">
            <div id="insidecent"></div>
            <input id="inp" class="insid" type="text" placeholder="Search" onchange="Search()">
            <select id="sel" class="insid" class="unutar">
                <option value="All"> All </option>
                <option value="Author"> Author </option>
                <option value="Book"> Book Title </option>
                <option value="Subject"> Subject</option>
                <option value="People"> People</option>

            </select>
            <button onclick="SendSearch()"> Search</button>
        </div>
    </div>

    <div class="right all">
    <div class="messages desno"> Messages</div>
    <div class="notifications desno"> Notifications </div>
    <div class="Friends desno"> Friend Requests </div>
    </div>
</div>

<br>
<div class="left sidebar">

    <div>
        <%
            Korisnik k = (Korisnik) request.getAttribute("Korisnik");
        %>
    </div>

    <div class="MyBooks left" onclick="Show('book')" > BOOKS POSTED  </div>
        <div class="MyBooks left" onclick="Show('booktook')"> TOOK BOOKS </div>
        <div class=" Friends " onclick="Show('friends')"> SHOW FRIENDS </div>

</div>
<div class="right sidebar">
    <%
        try {

            out.print("<div class=\"name\">");
            out.print(k.getFirst_name() + " " + k.getLast_name());
            out.print("</div>");
            out.print("");
            for (int i = 0; i < k.getBook().size(); i++)
            {
                int id=k.getBook().get(i).getIdBooks();
                out.print("<div class=\"book \">");
                String stranica =" http://localhost:8080/Book?id=" + id ;
                String name = k.getBook().get(i).getBookName();
                out.print("<a href=" + stranica + ">" + name + " </a>");
                out.print("</div>");
            }
            for(int i=0;i<k.getFriends().size();i++) {
                out.print("<div class=\"friends visible \">");
                out.println(k.getFriends().get(i).getFirst_name());
                out.println(k.getFriends().get(i).getLast_name());
                out.print("</div>");
            }
        }

        catch (Exception e) {
            System.out.println(e + " ");
        }
    %>

</div>

<script>

    function Search() {
        let search =  document.getElementById("inp").value;
        let type = document.getElementById("sel").value;
        alert(search + type);
        let xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function () {
            if(xhttp.readyState===4) {
                alert(xhttp.responseText);
                let response= JSON.parse(JSON.stringify(xhttp.responseText));
                let response2 =JSON.parse(xhttp.responseText);
                alert(response2);
                alert(response.length);
                alert(response2.length);
                append(response2);
            }
        };
        alert(search);
        let url="http://localhost:8080/search?type=" + type + "&s_query=" + search ;
        xhttp.open("GET", url, true);
        xhttp.send();

    }

    function Show(e) {
        alert(e);
    }

    function append(arg) {
        let elem= document.getElementById("insidecent");
        let numb = elem.childElementCount;

        console.log(numb);
        while(numb>0) {
            let item = document.getElementsByClassName("child");
            elem.removeChild(item[0]);
            numb--;
        }
        if(arg.length!==0) {
            for (let i = 0; i < arg.length; i++) {
                let div = document.createElement("div");
                let text = document.createTextNode(arg[i].bookName);
                div.classList.add("child");
                div.addEventListener("click", function () {
                    Move(arg[i].idBooks);
                });

                div.appendChild(text);
                elem.appendChild(div);
                console.log(arg[i].bookName);
            }
            elem.style.display = "block";
            console.log(elem.childNodes[0].innerHTML);

        }
    }
function SendSearch() {
    
}
function Move(arg) {
        alert("clicked" + arg);
        window.location.href="http://localhost:8080/Search?query=" + arg;
}
</script>

</body>
</html>
