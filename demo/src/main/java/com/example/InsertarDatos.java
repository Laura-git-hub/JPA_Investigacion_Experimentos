package com.example;

import java.util.Arrays;

import com.example.Entidades.EstacionMonitoreo;
import com.example.Entidades.Experimento;
import com.example.Entidades.Investigador;

import jakarta.persistence.EntityManager;

public class InsertarDatos {

    public static void InsertarDatos(EntityManager em) {
        try {

            //Creación objeto Investigador
            Investigador investigador1 = new Investigador("Lawerence", "10A");
            Investigador investigador2 = new Investigador("Ellen", "20B");
            Investigador investigador3 = new Investigador("Tommy", "30B");

            //Creación objeto Experimento
            Experimento experim1 = new Experimento("Mecánico","Positivo");
            experim1.setInvestigadorAsignado(investigador1);
            Experimento experim2 = new Experimento("Social","Positivo");
            experim2.setInvestigadorAsignado(investigador1);
            Experimento experim3 = new Experimento("Psicológico","Negativo");
            experim3.setInvestigadorAsignado(investigador1);
            Experimento experim4 = new Experimento("Psicológico","Positivo");
            experim4.setInvestigadorAsignado(investigador2);
            Experimento experim5 = new Experimento("Mecánico","Negativo");
            experim5.setInvestigadorAsignado(investigador2);

            investigador1.setListaExperimentos(Arrays.asList(experim1,experim2,experim3));
            investigador2.setListaExperimentos(Arrays.asList(experim4,experim5));

            EstacionMonitoreo estMonitoreo1 = new EstacionMonitoreo("Norte", 100);
            estMonitoreo1.setInvestigadorAsignado(investigador1);
          
            investigador1.setEstacionMonitoreo(estMonitoreo1);
    

            //PERSISTIR
            em.persist(investigador1);
            em.persist(investigador2);
            System.out.println("DATOS INSERTADOS CORRECTAMENTE");
           
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

}
