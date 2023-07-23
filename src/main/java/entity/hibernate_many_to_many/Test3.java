package entity.hibernate_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try {
//
            session = factory.getCurrentSession();

            session.beginTransaction();

            Section section = session.get(Section.class, 3);

            System.out.println(section);
            System.out.println(section.getChildren());

            session.getTransaction().commit();

//****************************************************************
//            session = factory.getCurrentSession();
//
//
//
//
//            session.beginTransaction();
//
//            Child child = session.get(Child.class,1);
//
//            System.out.println(child);
//            System.out.println(child.getSections());
//
//            session.getTransaction().commit();


// ****************************************************************
//
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//
//            Child child = session.get(Child.class, 1);
//            session.delete(child);
//
//            session.getTransaction().commit();


        } finally {
            session.close();
            factory.close();
        }

    }
}
