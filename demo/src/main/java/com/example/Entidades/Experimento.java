package com.example.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="experimentos")
public class Experimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String nombreExperimentos;
    private String resultadoPreliminar;
    
    @ManyToOne
    @JoinColumn(name= "investigador_id")
    private Investigador investigadorAsignado;

    //Constructores
    public Experimento() {
    }

    public Experimento(String nombreExperimentos, String resultadoPreliminar) {
        this.nombreExperimentos = nombreExperimentos;
        this.resultadoPreliminar = resultadoPreliminar;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombreExperimentos() {
        return nombreExperimentos;
    }

    public void setNombreExperimentos(String nombreExperimentos) {
        this.nombreExperimentos = nombreExperimentos;
    }

    public String getResultadoPreliminar() {
        return resultadoPreliminar;
    }

    public void setResultadoPreliminar(String resultadoPreliminar) {
        this.resultadoPreliminar = resultadoPreliminar;
    }

    public Investigador getInvestigadorAsignado() {
        return investigadorAsignado;
    }

    public void setInvestigadorAsignado(Investigador investigadorAsignado) {
        this.investigadorAsignado = investigadorAsignado;
    }

  //Mostrar datos toString
    @Override
    public String toString() {
        return "Experimento {Id= " + Id + 
        "\n, nombreExperimentos = " + nombreExperimentos + "}";

    }

}