package Pocetak;

import Books.*;
import Korisnik.Korisnik;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GetBook",urlPatterns = {"/Book"})
public class GetBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String idp= request.getParameter("id");
        int id = Integer.parseInt(idp);
        System.out.println(id);
        BookDao bd= new BookDao();
        Book b = bd.getBook(id);
        System.out.println(b);
        RequestDispatcher rd= request.getRequestDispatcher("Book.jsp");
        request.setAttribute("Book",b);
        rd.forward(request,response);
    }
}
