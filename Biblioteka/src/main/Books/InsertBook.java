package Books;

import Korisnik.Korisnik;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InsertBook",urlPatterns = {"/InsertBook"})
public class InsertBook extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String author= request.getParameter("author");
        String name=request.getParameter("name");
        int price=Integer.parseInt(request.getParameter("price"));
        int kolicina= Integer.parseInt(request.getParameter("kolicina"));
        HttpSession session=request.getSession(false);
        int id= (int) session.getAttribute("id");
        System.out.println(id);
        Book b= new Book();
        b.setBookName(name);
        b.setKolicina(kolicina);
        b.setBookPrice(price);
        //b.setAuthor(author);
        Korisnik k = new Korisnik();
        k.setFirst_name("FILIP");
        BookDao bd= new BookDao();
        bd.insert(b);

    }
}
