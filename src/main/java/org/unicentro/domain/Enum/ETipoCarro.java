package org.unicentro.domain.Enum;
//Carros: modelo, marca, cor, potência e ano
public enum ETipoCarro {
    CARRO("Modelo", "Marca", "cor", "potencia", "ano");
    /*MODELO("Modelo"),
    MARCA("Marca"),
    COR("Cor"),
    POTENCIA("Potência"),
    ANO("Ano");*/

    private String modelo;
    private String marca;
    private String cor;
    private String potencia;
    private String ano;

    private ETipoCarro(String modelo, String marca, String cor, String potencia, String ano){
        this.modelo = modelo; 
        this.marca = marca;
        this.cor = cor;
        this.potencia = potencia;
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public String getPotencia() {
        return potencia;
    }

    public String getAno() {
        return ano;
    }
}

