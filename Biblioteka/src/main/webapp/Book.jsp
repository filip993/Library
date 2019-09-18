<%@ page import="Books.*" %>
<%@ page import="Tagovi.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Knjiga</title>
    <style>
        #name {
            display: none;
        }
        #input {
            display: none;
        }
        .common {
            border-color: crimson;
            float: right;
        }
        #komentari {
            background-color: antiquewhite;
            width: 80%;
            border-style: solid;

        }
        #namebook {
            width: 17%;
        }
        #nameb {
            font-family: Cambria;
            font-style: italic;
            color: indianred;

        }
        .tags {
            background-color: #e2dcc5;
            display: inline-block;
            border-style: solid;
        }
        .book {
            text-align: center;
        }
    </style>

</head>
<body>
<div id="namebook" class="common">

<%

    Book b = (Book) request.getAttribute("Book");
    %>
    <div id="nameb" class="book">
        <%
        out.print(b.getBookName());
        %>
        <div>
        <span onclick="like()"> LIKE </span>
        <span onclick="dislike()"> DISLIKE </span>
        </div>

    </div>
    <br>
    <div class="book">
    <%
    out.print(b.getAbout());
%>
    </div>
        <div>
            <%
             for(BookTag t : b.getBookTag()) {
                 int id = t.getId();
                 String stranica =" http://localhost:8080/Tag?id="+id;
                 out.println("<a href= " + stranica  + " class= \"tags\"" + ">");
                 out.println(t.getTag());
                 out.println("</a>");
             }
        %>
        </div>

</div>
<div id="komentari" class="common">

<%
    out.print("<div class= \"inside \"");
    HttpSession session2 = request.getSession();
    out.print("<div id=\"name\">");
    out.print(session2.getAttribute("name"));
    out.print(session2.getAttribute("lastname"));
    out.print("</div>");
    for(int i=0;i<b.getKomentari().size();i++) {

        out.print("<div class=\"comment\">");

        out.print("<div class=\" namec \" >" );
        out.print(b.getKomentari().get(i).getKorisnik().getFirst_name());
        out.print(b.getKomentari().get(i).getKorisnik().getLast_name());
        out.print("</div>");

        out.print("<div class=\"komentar \" >");
        out.print(b.getKomentari().get(i).getKomentar());
        out.print("</div>");

        out.print("</div>");
        out.print("<br>");
    }
    out.print("</div>");
%>
    <div>
        <input id="input" type="text" value="<%out.print(b.getIdBooks()); %>">
        <div>
            <input id="komentar" type="text">
        </div>
        <button onclick="komentar()"> Postavite komentar </button>
    </div>


</div>

<script>
    let secret=document.getElementById("input").value;
    let name= document.getElementById("name").innerHTML;
    function komentar() {

        let kom=document.getElementById("komentar").value;
        alert(kom);
        let koment= kom.trim().replace(/\s\s+/g, ' ');
        if(koment!=="") {
            let xhttp = new XMLHttpRequest();

            xhttp.onreadystatechange = function () {
                if (xhttp.readyState === 4) {
                    addComment(koment);
                    alert(this);
                    alert("Ubaceno");
                }
            };
            let url = "http://localhost:8080/BookInsert?book=" + secret + "&comment=" + koment;
            xhttp.open("GET", url, true);
            xhttp.send();
        }
        else {
            alert("Morate uneti komentar");
        }
    }

    function addComment(kom) {
        let div = document.getElementById("komentari");
        let element = document.createElement("div");
        div.appendChild(element);
        element.classList.add("comment");
        let nameel= document.createElement("div");
        let noden= document.createTextNode(name);
        element.appendChild(nameel);
        nameel.appendChild(noden);
        nameel.classList.add("namec");
        let element2= document.createElement("div");
        let node= document.createTextNode(kom);
        element.appendChild(element2);
        element2.appendChild(node);
        element2.classList.add("komentar");
        let br = document.createElement("br");
        div.appendChild(br);
    }

    function like() {
        let xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if(xhttp.readyState===4) {
                alert(this);
            }
        }
    }
</script>

</body>
</html>
