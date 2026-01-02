package com.ggocodelab.ds_challenge_4.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ggocodelab.ds_challenge_4.entities.Sale;

@JsonPropertyOrder({ "id", "amount", "date", "seller"})
public class SaleDTO {
	
	private Long id;
	private Double amount;
	private LocalDate date;
	private String seller;
	
	public SaleDTO() {
	}
	
	public SaleDTO(Sale entity) {
		id = entity.getId();
		amount = entity.getAmount();
		date = entity.getDate();
		seller = entity.getSeller().getName();
	}

	public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getSeller() {
		return seller;
	}	
}
