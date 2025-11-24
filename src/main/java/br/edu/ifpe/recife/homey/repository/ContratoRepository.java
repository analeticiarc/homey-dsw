package br.edu.ifpe.recife.homey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpe.recife.homey.entity.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}
