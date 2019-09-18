package Pocetak;

import Books.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "Search",urlPatterns = {"/search"})
public class Search extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<String> lista = new ArrayList<String>();
        lista.add("EVO ");
        lista.add("NISTA");

        List<Book> books = new ArrayList<Book>();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        String type = request.getParameter("type");
        String s_query = request.getParameter("s_query");
        String send=" IME I PREZIME" ;
        String s2;
        switch (type) {
            case "Author" :
                System.out.println("PORUKA JE PRIMLJENA");
                out.println("PORUKA JE PRIMLJENA VRACAMO PODATKE");
                break;
            case "Book":
                BookDao bd = new BookDao();
                List Books =bd.SearchBook(s_query);
                for(int i =0;i<Books.size();i++) {
                    Book b1 = (Book) Books.get(i);
                    Book b = new Book();
                    b.setIdBooks(b1.getIdBooks());
                    b.setBookName(b1.getBookName());
                    books.add(b);
                }
                System.out.println("JSON");
                System.out.println(books.get(0).getType());
                System.out.println(gson.toJson(books));

                out.print(gson.toJson(books));
                break;
        }

    }
}
