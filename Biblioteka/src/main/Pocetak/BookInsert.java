package Pocetak;

import Books.*;
import Komentari.*;
import Korisnik.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "BookInsert",urlPatterns = {"/BookInsert"})
public class BookInsert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        int id= (Integer) session.getAttribute("id");
        KorisnikDao kdo = new KorisnikDao();
        Korisnik ko = kdo.getKorisnik(id);
        String book_id = request.getParameter("book");
        int id_book = Integer.parseInt(book_id);
        System.out.println(id_book);
        String komentar= request.getParameter("comment");
        System.out.println(komentar);
        BookDao bd = new BookDao();
        Book b = bd.getBook(id_book);

        KomentariDAO kd= new KomentariDAO();
        Komentari k = new Komentari();
        k.setBook(b);
        k.setKomentar(komentar);
        k.setKorisnik(ko);
        kd.insert(k);
        System.out.println("USPESNO");
    }
}
