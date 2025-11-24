package br.edu.ifpe.recife.homey.entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CLIENTE")
@DiscriminatorValue(value = "C")
@PrimaryKeyJoinColumn(name="ID_CLIENTE", referencedColumnName = "ID")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario{
    @Column(name = "CPF", nullable = false, unique = true, length = 11)
    private String cpf;
}