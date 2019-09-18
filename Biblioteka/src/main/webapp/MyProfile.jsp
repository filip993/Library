<%--
  Created by IntelliJ IDEA.
  User: Filip
  Date: 12/5/2018
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<div class="right sidebar"> <div>NISTA</div>
    <div>
        <input type="text" id="ime" name="ime" placeholder="Ime knjige">
        <input type="text" id="price" name="price" placeholder="Unesite cenu knjige">
        <input type="text" id="kolicina" name="kolicina" placeholder="Kolicina">
        <input type="text" id="author" name="Autor" placeholder="IME AUTORA">
        <button onclick="Postavi()"> Postavi knjigu </button>
    </div>

</div>

<script>
    function Postavi() {
        let author = document.getElementById("author").value;
        let name= document.getElementById("ime").value;
        let price = document.getElementById("price").value;
        let kolicina = document.getElementById("kolicina").value;
        let ime="";
        let prezime= "";
        let tacno=false;
        for(var i=0;i<author.length;i++) {
            if(tacno===false) {
                ime=ime+author[i];
            }
            else {
                prezime=prezime+author[i];
            }
            if(author[i]===" ") {
                tacno=true;
            }
        }
        let submit=true;
        if(author==="" || author === " " ) {
            alert("Morate uneti autora");
            submit = false;
        }
        if(name==="" || name===" ") {
            alert("MORATE UNETI IME KNJIGE");
            submit=false;
        }
        if(price==="" || price===" ") {
            alert("MORATE UNETI CENU KNJIGE");
            submit=false;
        }
        if(kolicina==="" || name===" ") {
            alert("MORATE UNETI IME KNJIGE");
            submit=false;
        }
        if(submit===false) {
            alert("MORATE UNETI SVA POLJA");
        }
        else {
            let xhttp= new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if(xhttp.readyState===4) {
                    alert("nista");
                }
            };
            let url="http://localhost:8080/InsertBook?author=" + author + "&name=" + name + "&price=" + price + "&kolicina=" + kolicina ;
            alert(url);
            xhttp.open("GET", url, true);
            xhttp.send();
        }
    }

</script>

</body>
</html>
