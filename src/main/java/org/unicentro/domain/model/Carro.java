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
    private String potencia;
    @Column(nullable = false)
    private String ano;

    @OneToMany(mappedBy = "carro")
    private List<CarroUsuario> usuarios;

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
