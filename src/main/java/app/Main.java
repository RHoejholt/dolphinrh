package app;

import app.config.HibernateConfig;
import app.entities.Fee;
import app.entities.Note;
import app.entities.Person;
import app.entities.PersonDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Dolphin!");

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        try(EntityManager em = emf.createEntityManager())
        {
            Person p1 = new Person("Hanzi");
            PersonDetail pd1 = new PersonDetail("Algade 3", 4300, "Holbæk", 45);
            p1.addPersonDetail(pd1);
            Fee f1 = new Fee(125, LocalDate.of(2023, 8, 25));
            Fee f2 = new Fee(150, LocalDate.of(2023, 7, 19));
            p1.addFee(f1);
            p1.addFee(f2);

            Note n1 = new Note("bad guy", "Rasmus");
            Note n2 = new Note("stinky dude", "Casper");

            p1.addNote(n1);
            p1.addNote(n2);
            em.getTransaction().begin();
            em.persist(p1);
            em.getTransaction().commit();
            System.out.println(p1);
        } finally {
            emf.close();
        }
    }
}