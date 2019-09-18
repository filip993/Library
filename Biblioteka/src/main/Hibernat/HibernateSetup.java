package Hibernat;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSetup {
    private static SessionFactory sessionFactory;

    static
    {
        try
        {
            //Configuration configuration = new Configuration().configure();
            StandardServiceRegistry  standardServiceRegistry = new StandardServiceRegistryBuilder().configure("cfg.xml")
                    .build();
            Metadata metadata = new MetadataSources(standardServiceRegistry)
                    .getMetadataBuilder().build();
            sessionFactory = metadata.getSessionFactoryBuilder().build();

        }catch(HibernateException exception)
        {
            System.out.println("Problem creating session factory!");
        }
    }

    public static SessionFactory getSessionFactory(){

        return sessionFactory;
    }

    public static void close() {
        sessionFactory.close();
    }
}

