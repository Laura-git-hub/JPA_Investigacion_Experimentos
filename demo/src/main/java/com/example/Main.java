package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

      try {
        //INICIAR TRANSACCION
        em.getTransaction().begin();
        System.out.println("INSERTANDO DATOS");
        InsertarDatos.InsertarDatos(em);

        //CONFIRMAR TRANSACCION
        em.getTransaction().commit();

        //EJECUTAR CONSULTAS
        System.out.println("EJECUTAR CONSULTAS");
        EjecutarConsultas.EjecutarConsultas(em);

        
      } catch (Exception e) {
        if(em.getTransaction().isActive()){
            em.getTransaction().rollback();
        }e.printStackTrace();
      }finally{
        emf.close();
        em.close();
      }
    }
}