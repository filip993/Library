package Pocetak;
import Korisnik.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginCheck",urlPatterns = {"/logincheck"})
public class LoginCheck extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StandardServiceRegistry ssr;
        Metadata meta;
        SessionFactory factory;
        Session session;
        Transaction t;
        String email= request.getParameter("email");
        String email2= "\'"+email+"\'";
        String password= request.getParameter("password");
        String password2= "\'"+password+"\'";

        String sql="SELECT * FROM registration WHERE email= " + email2;
        ssr = new StandardServiceRegistryBuilder().configure("cfg.xml").build();
        meta = new MetadataSources(ssr).getMetadataBuilder().build();
        factory = meta.getSessionFactoryBuilder().build();
        session = factory.openSession();
        t = session.beginTransaction();
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Korisnik.class);
        response.setContentType("text/plain");


        if(query.list().size()==1) {
            String sql2= "SELECT * FROM registration WHERE email= " + email2 + " AND " + "password=" + password2;
            Query query2 = session.createSQLQuery(sql2);
            if(query2.list().size()>=1) {
                response.getWriter().write("true");
                Korisnik k =(Korisnik) query.list().get(0);
                HttpSession session2= request.getSession(false);
                session2.setAttribute("id",k.getId());
                session2.setAttribute("email",k.getFirst_name());
                session2.setAttribute("name", k.getFirst_name());
                session2.setAttribute("lastname",k.getLast_name());

                System.out.println(k.getId() + "ovo je korisnik" + k.getEmail());
            }
            else {
                response.getWriter().write("false");
            }
        }
        else {
            response.getWriter().write("email pogresan");
        }
        t.commit();
        factory.close();
        session.close();
    }
}