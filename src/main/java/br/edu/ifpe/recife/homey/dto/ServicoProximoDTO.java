package br.edu.ifpe.recife.homey.dto;

import java.math.BigDecimal;

public record ServicoProximoDTO(
    Long id,
    String titulo,
    String descricao,
    BigDecimal precoBase,
    double distanciaKm
) {}