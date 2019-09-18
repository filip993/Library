package Pocetak;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Check",urlPatterns = {"/check"})
public class Check extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/plain");
        String email =request.getParameter("email");
        String email2 = "\'"+email+"\'" ;
        String username = request.getParameter("username");
        String username2= "\'"+username+"\'";
        request.getParameter("nista");
        StandardServiceRegistry ssr;
        Metadata meta;
        SessionFactory factory;
        Session session;
        Transaction t;
        String sql = "SELECT * FROM registration WHERE email= " + email2 + " OR " + "username=" + username2 ;
        System.out.println(sql);
        ssr = new StandardServiceRegistryBuilder().configure("cfg.xml").build();
        meta = new MetadataSources(ssr).getMetadataBuilder().build();
        factory = meta.getSessionFactoryBuilder().build();
        session = factory.openSession();
        t = session.beginTransaction();
        Query query = session.createSQLQuery(sql);

        List rezultati = query.list();
        int res= rezultati.size();
        System.out.println(rezultati);
        System.out.println(res);
        String res2= Integer.toString(res);
        response.getWriter().write(res2);
    }
}
