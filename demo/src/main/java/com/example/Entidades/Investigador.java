package com.example.Entidades;

import jakarta.persistence.GenerationType;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="investigadores")
public class Investigador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    private String name;
    private String identificadorInstitucional;
    
    @OneToOne(mappedBy = "investigadorAsignado", cascade = CascadeType.ALL)
    private EstacionMonitoreo estacionMonitoreo;

    @OneToMany(mappedBy="investigadorAsignado", cascade = CascadeType.ALL)
    private List<Experimento>listaExperimentos;

    //Constructores
    public Investigador() {
    }

    public Investigador(String name, String identificadorInstitucional) {
        this.name = name;
        this.identificadorInstitucional = identificadorInstitucional;
    }

    //Getter and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificadorInstitucional() {
        return identificadorInstitucional;
    }

    public void setIdentificadorInstitucional(String identificadorInstitucional) {
        this.identificadorInstitucional = identificadorInstitucional;
    }

    public EstacionMonitoreo getEstacionMonitoreo() {
        return estacionMonitoreo;
    }

    public void setEstacionMonitoreo(EstacionMonitoreo estacionMonitoreo) {
        this.estacionMonitoreo = estacionMonitoreo;
    }

    public List<Experimento> getListaExperimentos() {
        return listaExperimentos;
    }

    public void setListaExperimentos(List<Experimento> listaExperimentos) {
        this.listaExperimentos = listaExperimentos;
    }
}
