package org.unicentro.domain.model;
import java.util.Date;
import java.util.List;

import org.unicentro.domain.Enum.ETipoCarro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCarro")
    private Long id;
    @Column(nullable = false)
    private String modelo;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String cor;
    @Column(nullable = false)
    private String potencia;
    @Column(nullable = false)
    private String ano;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getModelo() {return modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}
    public String getCor() {return cor;}
    public void setCor(String cor) {this.cor = cor;}
    public String getPotencia() {return potencia;}
    public void setPotencia(String potencia) {this.potencia = potencia;}
    public String getAno() {return ano;}
    public void setAno(String ano) {this.ano = ano;}
}
