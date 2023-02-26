package br.eti.vendrameto.xp4dev.cache.service;

import br.eti.vendrameto.xp4dev.cache.dto.VendaDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VendasService {

    @Cacheable(cacheNames="venda", key="#id")
    public VendaDTO getById(Long id) {
        log.info("gerando venda getByid {}", id);
        return VendaDTO.builder().value(id.toString()).build();
    }

    @CacheEvict(cacheNames="venda", key="#id")
    public void cleanCache(Long id) {
    }
}