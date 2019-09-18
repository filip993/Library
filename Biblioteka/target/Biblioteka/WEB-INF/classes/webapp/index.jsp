<html>
<head>
    <style>
        .prvi {
            background-color: #333;
            height: 50px;
            padding-left: 200px;
            padding-right: 200px;
        }
        .drugi {

            background-color: blue;
            height: 100%;
            position: relative;

        }
        .levo {
            background-color: red;
            display: block;
            height: 100%;
            width: 200px;
            float:left;
            line-height: 50px;
            text-align: center;
            font-size: 17px;

        }
        .desno {
            display: block;
            background-color: red;
            height: 100%;
            width: 200px;
            text-align: center;
            float:right;
            line-height: 50px;
            font-size: 17px;
        }
        .header {
            height: 50px;
            overflow: auto;
        }
        .header {
            height: 50px;
            overflow: auto;
            background-color: #e2dcc5;
        }
        .header::after {
            content: "";
            clear: both;
            display: table;
        }
        .search {
            float: left;
            height: 85%;
            background-color: #e2dcc5;
            border-style: solid;
            font-size: 24px;
        }
        .insid{
            display: block;
            float: left;
            height: 100%;
            line-height: 50;
            background-color: #e2dcc5;
            border-style: solid;
            border-color: #e2dcc5;
        }
        .Categories {
            float:left;
            height: 100%;
            line-height: 50px;
            width: 300px;
            text-align: center;
            font-size: 24px;

        } .more {
              float:left;
              height: 100%;
              line-height: 50px;
              width: 300px;
              text-align: center;
              font-size: 24px
          }
        .sign {
            border-style: dotted;
            height: 200px;
        }
        input[type=text], input[type=password],input[type=submit] {
            display: block;

        }
        input::placeholder {
            line-height: 50px;
            text-align: center;
        }
    </style>
</head>

<body>

<div class="prvi">
    <div class="drugi">
        <span class="levo">INTERNET BIBLIOTEKA</span>
        <span class="desno"> DONIRAJTE </span>
    </div>
</div>

<div class="header">
    <div class="more">
        More
    </div>
    <div class="Categories">
        Categories
    </div>
    <div class=""></div>
    <div class="search">

        <input id="inp" class="insid" type="text" placeholder="Search">
        <select id="sel" class="insid" class="unutar">
            <option value="All"> All </option>
            <option value="Author"> Author </option>
            <option value="Book "> Book Title </option>
            <option value="Subject"> Subject</option>
        </select>
    </div>
</div>

<a href="http://localhost:8080/nista"> IDI OVDE </a>

<h1> MOST READ BOOKS </h1>

<div class="sign">
    <form name="myForm" action="registracija" method="post" onsubmit="return sendrequest(this)" >
        <input type="text" name="firstname" placeholder="Your first name">
        <input type="text" name="lastname" placeholder="Your last name">
        <input type="text" name="email" id="email" placeholder="Your email">
        <input type="text" name="username" placeholder="Your username">
        <input type="password" name="password" placeholder="Your password">
        <input type="password" name="passwordconf" placeholder="Confirm your password">
        <input type="Submit" value="Submit">
    </form>
</div>
<div class="login">
    <form name="LoginForm" action="Home" method="get" onsubmit="return sendrequest2(this)">
        <input type="text" name="emaill">
        <input type="text" name="passwordl">
        <input type="submit" value="Submit">
    </form>
</div>
<a href="http://localhost:8080/register">klikni</a>

<div class="read"></div>
<div class="read"></div>
<div class="read"></div>
<div class="read"></div>
<div class="read"></div>

<script>

    function sendrequest(a1) {
        let tacno=false;
        let username = document.forms["myForm"]["username"].value;
        let email = document.forms["myForm"]["email"].value;
        let password = document.forms["myForm"]["password"].value;
        let password2 = document.forms["myForm"]["passwordconf"].value;
        if (password !== password2) {
            return false;
        }
        else {
            alert("tacno");

            let xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (xhttp.readyState === 4) {
                    if(xhttp.responseText>=1) {
                        alert("Korisnik vec postoji morate uneti drugaciji email ili username");
                    }
                    else {
                        a1.submit();
                    }
                }
            };
            let url = "http://localhost:8080/check?email=" + email + "&username=" + username;
            alert(url);
            xhttp.open("GET", url, true);
            xhttp.send();

        }
        return tacno;
    }

    function sendrequest2(log) {
        alert("ovde ste");
        var tacno=false;
        var email = document.forms["LoginForm"]["emaill"].value;
        var password = document.forms["LoginForm"]["passwordl"].value;


            alert("tacno");
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (xhttp.readyState === 4) {
                    if(xhttp.responseText==="email pogresan") {
                        alert("pogresili ste email");
                    }
                    else if(xhttp.responseText==="false") {
                        alert("pogresili ste password");
                    }
                    else if(xhttp.responseText==="true") {
                        log.submit();
                    }
                }
            };
            var url = "http://localhost:8080/logincheck?email=" + email + "&password=" + password;
            alert(url);
            xhttp.open("GET", url, true);
            xhttp.send();


        return tacno;
    }

</script>
</body>
</html>
