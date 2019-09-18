package Korisnik;

import Hibernat.HibernateSetup;
import Statusi.Statusi;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class KorisnikDao implements KorisnikDaoImp {

        private ArrayList<Korisnik> Korisnici;

        @Override
        public Korisnik getKorisnik(int num) {

            try {
                Session session = HibernateSetup.getSessionFactory().openSession();
                Transaction t = session.beginTransaction();
                Korisnik k = session.get(Korisnik.class, num);
                t.commit();
                session.close();
                return k;
            }
            catch (HibernateException he) {
                System.out.println(he);

            }
            return null;
        }

        @Override
        public List<Korisnik> getAllKorisnik() {
            return Korisnici;
        }

        @Override
        public int deleteUser(Korisnik k) {

            Session session = HibernateSetup.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.delete(k);
            t.commit();
            session.close();
            return 90;
        }

        @Override
        public int insertUser(Korisnik k) {

            Session session = HibernateSetup.getSessionFactory().openSession();
            Transaction t = session.beginTransaction();
            session.save(k);
            t.commit();
            session.close();
            return k.getId();
        }

    }

