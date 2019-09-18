package Pocetak;
import Korisnik.*;
import Books.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;


@WebServlet(urlPatterns = {"/registracija"})
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String first_name = request.getParameter("firstname");
        String last_name = request.getParameter("lastname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String username = request.getParameter("username");

        Korisnik k1=new Korisnik();
        k1.setFirst_name(first_name);
        k1.setLast_name(last_name);
        k1.setPassword(password);
        k1.setUsername(username);
        k1.setEmail(email);
        KorisnikDao k1dao = new KorisnikDao();
        int id=k1dao.insertUser(k1);
        HttpSession session= request.getSession();
        session.setAttribute("id",id);
        session.setAttribute("email",email);
        RequestDispatcher rd=request.getRequestDispatcher("main.jsp");
        request.setAttribute("ceo ", k1);
        request.setAttribute("ime", "Nista");
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        out.println("<h1>" + "Nista" + "</h1>");
        out.close();

    }
}
