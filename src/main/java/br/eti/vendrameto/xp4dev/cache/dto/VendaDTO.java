package br.eti.vendrameto.xp4dev.cache.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class VendaDTO implements Serializable {

    private String value;
    private int count = 0;

}