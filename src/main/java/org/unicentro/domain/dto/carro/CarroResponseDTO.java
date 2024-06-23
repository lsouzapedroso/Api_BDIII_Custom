package org.unicentro.domain.dto.carro;

import java.util.List;

import org.unicentro.domain.Enum.ETipoCarro;
import org.unicentro.domain.dto.carroId.CarroIdResponseDTO;

public class CarroResponseDTO {
    private Long id;
    private ETipoCarro carro;
    private List<CarroIdResponseDTO> Carroid;
    private String modelo;
    private String marca;
    private String cor;
    private int potencia;
    private int ano;
    private String descricao;
    private String observacao;
    
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public ETipoCarro getCarro() {
        return carro;
    }
    public void setCarro(ETipoCarro carro) {
        this.carro = carro;
    }
    public List<CarroIdResponseDTO> getCarroid() {
        return Carroid;
    }
    public void setCarroid(List<CarroIdResponseDTO> carroid) {
        Carroid = carroid;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public int getPotencia() {
        return potencia;
    }
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }

}
