package Statusi;

import Hibernat.HibernateSetup;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class StatusiDao implements StatusiDaoImp {

    @Override
    public int insert(Statusi s) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(s);
        t.commit();
        session.close();
        return 0;
    }
    @Override
    public int delete(Statusi s) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(s);
        t.commit();
        session.close();
        return 10;
    }

    @Override
    public Statusi getS(int id ) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Statusi s= session.get(Statusi.class, id);
        t.commit();
        session.close();
        return s;
    }
}
