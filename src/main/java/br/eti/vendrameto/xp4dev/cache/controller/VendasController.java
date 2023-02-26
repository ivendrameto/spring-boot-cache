package br.eti.vendrameto.xp4dev.cache.controller;

import br.eti.vendrameto.xp4dev.cache.dto.VendaDTO;
import br.eti.vendrameto.xp4dev.cache.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/vendas")
public class VendasController {

	@Autowired
	private VendasService vendasService;

	@GetMapping("explorer/{id}")
	public ResponseEntity<VendaDTO> explorer(@PathVariable(value = "id") Long id) {
		VendaDTO response = vendasService.getById(id);
		return new ResponseEntity<VendaDTO>(response, HttpStatus.OK);
	}

	@GetMapping("clean-cache/{id}")
	public ResponseEntity<Void> cleanCache(@PathVariable(value = "id") Long id) {
		vendasService.cleanCache(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}