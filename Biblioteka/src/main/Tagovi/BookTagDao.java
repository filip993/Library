package Tagovi;

import Hibernat.HibernateSetup;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BookTagDao implements BookTagDaoImp {

    @Override
    public BookTag getBookT(int id) {

        Session session = HibernateSetup.getSessionFactory().openSession();;
        Transaction t = session.beginTransaction();
        BookTag bt = session.get(BookTag.class,id );
        t.commit();
        session.close();
        return bt;
    }

    @Override
    public int deleteTag(BookTag k) {

        Session session = HibernateSetup.getSessionFactory().openSession();;
        Transaction t = session.beginTransaction();
        session.delete(k);
        t.commit();
        session.close();
        return 0;
    }

    @Override
    public int insertTag(BookTag k) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        int vratu= (int) session.save(k);
        t.commit();
        session.close();
        return vratu;
    }
}
