package Books;

import Hibernat.HibernateSetup;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookTookDao implements BookTookDaoImp {

    @Override
    public int insertBT(BookTook bt) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(bt);
        t.commit();
        int retur = bt.getId();
        session.close();
        return retur;
    }

    @Override
    public BookTook getBT(int id) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        BookTook bt = session.get(BookTook.class, id);
        t.commit();
        session.close();
        return bt;
    }
}