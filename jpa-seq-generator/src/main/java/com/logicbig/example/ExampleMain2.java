package com.logicbig.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ExampleMain2 {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test-unit");
        EntityManager em = emf.createEntityManager();

        System.out.println("before persisting new entities");
//        Util.nativeQuery(em, "SELECT * FROM INFORMATION_SCHEMA.SEQUENCES");
        Util.nativeQuery(em, "SELECT * FROM MyTable");

        MyEntity entity1 = new MyEntity();
        MyEntity entity2 = new MyEntity();
        MyEntity entity3 = new MyEntity();
        MyEntity entity4 = new MyEntity();
        em.getTransaction().begin();
        em.persist(entity1);
        em.persist(entity2);
        em.persist(entity3);
        em.persist(entity4);
        em.getTransaction().commit();

        System.out.println("after persisting new entities");
        Util.nativeQuery(em, "SELECT * FROM MyTable");

        em.close();
        emf.close();
    }
}