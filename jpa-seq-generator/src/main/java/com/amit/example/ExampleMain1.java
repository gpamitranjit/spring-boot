package com.amit.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExampleMain1 {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-unit");
        EntityManager em = emf.createEntityManager();

        System.out.println("before persisting new entities");
//        Util.nativeQuery(em, "SELECT * FROM INFORMATION_SCHEMA.SEQUENCES");
        Util.nativeQuery(em, "SELECT * FROM MyTable");
        MyEntity entity1 = new MyEntity();
        MyEntity entity2 = new MyEntity();
        em.getTransaction().begin();
        em.persist(entity1);
        em.persist(entity2);
        em.getTransaction().commit();

        System.out.println("after persisting new entities");
        Util.nativeQuery(em, "SELECT * FROM MyTable");

        em.close();
        emf.close();
    }
}