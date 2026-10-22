package com.craft;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class App {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("John Snow");
        student.setTech("Java");

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("studentPU");
        EntityManager em = emf.createEntityManager();

        EntityTransaction entityTransaction = em.getTransaction();
//        entityTransaction.begin();
//        em.persist(student);

        Student fetchedStudent = em.find(Student.class, 1);

//        entityTransaction.commit();
        System.out.println("Fetched: " + fetchedStudent);
        em.close();
    }
}