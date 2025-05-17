package com.example;

import java.util.List;

import com.example.Entidades.EstacionMonitoreo;
import com.example.Entidades.Experimento;
import com.example.Entidades.Investigador;

import jakarta.persistence.EntityManager;

public class EjecutarConsultas {

    public static void EjecutarConsultas(EntityManager em) {
       
        // 1. Obtener los nombres investigador y los nombres de sus experimentos
        List<Investigador>queryInvestigadorExperimento = em.createQuery(
            "SELECT DISTINCT i FROM Investigador i JOIN FETCH i.listaExperimentos", Investigador.class).getResultList();
            System.out.println("NOMBRE DEL INVESTIGADOR Y SUS EXPERIMENTOS");
            for (Investigador i : queryInvestigadorExperimento) {
                System.out.println("NOMBRE DEL INVESTIGADOR: " + i.getName());
                for (Experimento e : i.getListaExperimentos()) {
                    System.out.println("NOMBRE DE LOS EXPERIMENTOS: " + e.getNombreExperimentos());
                }
            }

            // 3. Mostrar el nombre e identificador de todos los Investigadores que tengan más de un experimento
            //Si NO selecciono campos específicos cojo todo el objeto y extraigo lo que necesite.
            List<Investigador> queryInvestigadorConMasDeUnExper = em.createQuery(
                "SELECT i FROM Investigador i WHERE SIZE(i.listaExperimentos) > 1", Investigador.class).getResultList();
                System.out.println("MOSTRAR EL NOMBRE E IDENTIFICADOR DE TODOS LOS INVESTIGADORES QUE TENGAN MÁS DE UN EXPERIMENTO");
                for (Investigador invest : queryInvestigadorConMasDeUnExper) {
                    System.out.println("NOMBRE DE INVESTIGADOR: " + invest.getName()+
                    "\nIDENTIFICADOR DEL INVESTIGADOR: " + invest.getIdentificadorInstitucional());
                }
            

           //3. Mostrar las coordenadas GPS de la estación del investigador con id = 1.
           List<EstacionMonitoreo>queryEstacionMonitoreo = em.createQuery(
            "SELECT e FROM EstacionMonitoreo e WHERE e.investigadorAsignado.id =1", EstacionMonitoreo.class).getResultList();
                System.out.println("MOSTRAR LAS COORDINADAS GPS DE LA ESTACIÓN DEL INVESTIGADOR CON ID 1");
                for (EstacionMonitoreo estacionMonitoreo : queryEstacionMonitoreo) {
                    System.out.println("DATOS DE LAS COORDENADAS: " + estacionMonitoreo.getCoordenadasGPS());
                } 
    }
}

