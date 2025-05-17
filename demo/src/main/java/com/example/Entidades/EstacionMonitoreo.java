package com.example.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="estacionmonitoreos")
public class EstacionMonitoreo {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private Long Id;
    private String coordenadasGPS;
    private int nivelActividad;
    
    @OneToOne
    @JoinColumn(name= "investigador_id")
    private Investigador investigadorAsignado;
    
    //Consturctores
    public EstacionMonitoreo() {
    }


    public EstacionMonitoreo(String coordenadasGPS, int nivelActividad) {
        this.coordenadasGPS = coordenadasGPS;
        this.nivelActividad = nivelActividad;
    }


    public Long getId() {
        return Id;
    }


    public void setId(Long id) {
        Id = id;
    }


    public String getCoordenadasGPS() {
        return coordenadasGPS;
    }


    public void setCoordenadasGPS(String coordenadasGPS) {
        this.coordenadasGPS = coordenadasGPS;
    }


    public int getNivelActividad() {
        return nivelActividad;
    }


    public void setNivelActividad(int nivelActividad) {
        this.nivelActividad = nivelActividad;
    }


    public Investigador getInvestigadorAsignado() {
        return investigadorAsignado;
    }


    public void setInvestigadorAsignado(Investigador investigadorAsignado) {
        this.investigadorAsignado = investigadorAsignado;
    }

/* 
    //Mostrar datos toString
    @Override
    public String toString() {
        return "EstacionMonitoreo [getId()=" + getId() + ", getCoordenadasGPS()=" + getCoordenadasGPS()
                + ", getNivelActividad()=" + getNivelActividad() + ", getInvestigadorAsignado()="
                + getInvestigadorAsignado() + "]";
    } */

}
