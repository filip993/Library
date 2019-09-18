package Pocetak;

import Korisnik.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Home",urlPatterns = {"/Home"})
public class Home extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesija= request.getSession();
        int id =(Integer) sesija.getAttribute("id");
        KorisnikDao kd= new KorisnikDao();
        Korisnik k =  kd.getKorisnik(id);
        RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
        request.setAttribute("Korisnik", k);
        rd.forward(request,response);

    }
}
