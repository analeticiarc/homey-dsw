package br.edu.ifpe.recife.homey.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRESTADOR")
@DiscriminatorValue(value = "P")
@PrimaryKeyJoinColumn(name="ID_PRESTADOR", referencedColumnName = "ID")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prestador extends Usuario {
    
    @Column(name = "CPF_CNPJ", nullable = false, unique = true, length = 14)
    private String cpf_cnpj;
    @Column(name = "RESUMO", nullable = true, length = 255)
    private String resumo;
    @Column(name = "AVALIACAO", nullable = true)
    private Double avaliacao;
    
    @OneToMany(mappedBy = "prestador", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Servico> servicos;

    public void addServico(Servico servico) {
        if(this.servicos == null){
            this.servicos = new ArrayList<>();
        }
        this.servicos.add(servico);
    }
}