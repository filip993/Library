package Pocetak;

import Korisnik.Korisnik;
import Korisnik.KorisnikDao;
import Tagovi.BookTag;
import Tagovi.BookTagDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Tags",urlPatterns = {"/Tag"})
public class Tags extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        BookTagDao btd = new BookTagDao();
        String id =request.getParameter("id");

        int id2 =Integer.parseInt(id);
        System.out.println(id);
        BookTag bt = btd.getBookT(id2);
        RequestDispatcher rd = request.getRequestDispatcher("Tag.jsp");
        request.setAttribute("BookTags", bt);
        rd.forward(request,response);
    }

}
