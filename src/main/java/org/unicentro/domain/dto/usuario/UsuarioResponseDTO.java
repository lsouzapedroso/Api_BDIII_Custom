package org.unicentro.domain.dto.usuario;

import java.util.Date;

public class UsuarioResponseDTO {
    private Long id;
    private String nome;
    private String email;
    private Date dataCadastro;
    private Date dataInativacao;

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public Date getDataInativacao() {
        return dataInativacao;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }
}
