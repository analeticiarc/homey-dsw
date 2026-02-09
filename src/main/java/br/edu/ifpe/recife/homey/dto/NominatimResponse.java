package br.edu.ifpe.recife.homey.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NominatimResponse(
    String lat,
    String lon
) {}