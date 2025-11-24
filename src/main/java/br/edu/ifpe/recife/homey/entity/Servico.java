package br.edu.ifpe.recife.homey.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SERVICO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servico {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;
    @Column(name = "DESCRICAO", nullable = true, length = 255)
    private String descricao;
    @Column(name = "PRECO_BASE", precision = 10, scale = 2)
    private BigDecimal precoBase;
    @Column(name = "DISPONIVEL", nullable = false)
    private Boolean disponivel;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ID_PRESTADOR", referencedColumnName = "ID")
    private Prestador prestador;
    
    @OneToMany(mappedBy = "servico", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contrato> contratos;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "SERVICOS_CATEGORIAS", joinColumns = {
        @JoinColumn(name = "ID_SERVICO")},
            inverseJoinColumns = {
                @JoinColumn(name = "ID_CATEGORIA")
            })
    private List<Categoria> categorias;

    @Column(name = "DT_CRIACAO")
    protected Date dataCriacao;    
    
    @PrePersist
    public void setDataCriacao() {
        this.dataCriacao = new Date();
    }

    public void addContrato(Contrato contrato) {
        if(this.contratos == null) {
            this.contratos = new ArrayList<>();
        }
        this.contratos.add(contrato);
    }
}