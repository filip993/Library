package Komentari;

import Hibernat.HibernateSetup;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class KomentariDAO implements KomentarDAOImp {


    @Override
    public Komentari getKoment(int id) {

            Session session = HibernateSetup.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            Komentari k = session.get(Komentari.class, id);
            t.commit();
            session.close();
            return k;


    }

    @Override
    public int insert(Komentari komentar) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(komentar);
        t.commit();
        int retur = komentar.getID();
        session.close();
        return retur;
    }

    @Override
    public void update() {

    }
    public int  deleteKom(Komentari kom) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.delete(kom);
        t.commit();
        session.close();
        return 0;
    }

}
