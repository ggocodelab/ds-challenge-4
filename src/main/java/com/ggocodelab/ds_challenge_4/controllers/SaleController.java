package com.ggocodelab.ds_challenge_4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ggocodelab.ds_challenge_4.dto.SaleDTO;
import com.ggocodelab.ds_challenge_4.services.SaleService;

@RestController
@RequestMapping(value="/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public List<SaleDTO> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public SaleDTO findById(@PathVariable Long id) {
		return service.findById(id);
	}
}
