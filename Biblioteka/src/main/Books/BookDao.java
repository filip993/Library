package Books;

import Hibernat.HibernateSetup;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class BookDao implements BookDaoImp {


    @Override
    public int insert(Book b) {
        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(b);
        t.commit();
        int retur = b.getIdBooks();
        session.close();
        return retur;
    }

    @Override
    public Book getBook(int num) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Book b = session.get(Book.class, num);
        t.commit();
        session.close();
        return b;
    }

    @Override
    public void DeleteBook(Book b) {

        Session session = HibernateSetup.getSessionFactory().openSession();;
        Transaction t = session.beginTransaction();
        session.delete(b);
        t.commit();
        session.close();

    }

    @Override
    public void UpdateBook(Book b) {

    }

    @Override
    public List SearchBook(String search) {
        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        String sql = "FROM Book WHERE bookName LIKE concat(:id,'%') ";

        Query query = session.createQuery(sql);
        query.setParameter("id", search);
        List results = query.list();
        t.commit();
        session.close();

        return results;
    }
}
