package org.unicentro.domain.model;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;


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
    private int potencia;
    @Column(nullable = false)
    private int ano;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getModelo() {return modelo;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public String getMarca() {return marca;}
    public void setMarca(String marca) {this.marca = marca;}
    public String getCor() {return cor;}
    public void setCor(String cor) {this.cor = cor;}
    public int getPotencia() {return potencia;}
    public void setPotencia(int potencia) {this.potencia = potencia;}
    public int getAno() {return ano;}
    public void setAno(int ano) {this.ano = ano;}
    public Usuario getUsuario() {return usuario;}
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}
}
