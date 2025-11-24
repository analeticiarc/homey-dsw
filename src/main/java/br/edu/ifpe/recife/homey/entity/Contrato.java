package br.edu.ifpe.recife.homey.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CONTRATO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contrato {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DT_INICIO", nullable = false)
    private Date data_inicio;
    @Column(name = "DT_FIM", nullable = false)
    private Date data_fim;
    @Column(name = "VALOR_FINAL", precision = 10, scale = 2)
    private BigDecimal valor_final;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ID_SERVICO", referencedColumnName = "ID")
    private Servico servico;
    
    @Column(name = "DT_CRIACAO")
    protected Date dataCriacao;
    
    @PrePersist
    public void setDataCriacao() {
        this.dataCriacao = new Date();
    }
}