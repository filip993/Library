package Messages;

import Hibernat.HibernateSetup;
import org.hibernate.Session;
import org.hibernate.Transaction;



public class MessageDao implements MessageDaoImp {

    @Override
    public Messages getMessage(int num) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Messages message = session.get(Messages.class,num );
        t.commit();
        session.close();
        return message;
    }

    @Override

    public int insertMessage(Messages m) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t =  session.beginTransaction();
        int retur= (int) session.save(m);
        t.commit();
        System.out.println("UBACENO");
        session.close();
        return retur;
    }

    @Override
    public void DeleteMessage(Messages m) {

        Session session = HibernateSetup.getSessionFactory().openSession();
        Transaction t =  session.beginTransaction();
        session.delete(m);
        t.commit();
        session.close();
    }
}

