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
    @Column(name = "idTitulo")
    private Long id;
    @Column(nullable = false)
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    private ETipoCarro tipo;
    @ManyToMany
    @JoinTable(
        name="titulo_centrodecusto",
        joinColumns = @JoinColumn(name="idTitulo"),
        inverseJoinColumns = @JoinColumn(name="idCentroDeCusto")
    )
    private List<CentroDeCusto> centrosDeCustos;
    @Column(nullable = false)
    private Double valor;
    private Date dataCadastro;
    private Date dataReferencia;
    private Date dataVencimento;
    private Date dataPagamento;
    @Column(columnDefinition = "TEXT")
    private String observacao;

}
