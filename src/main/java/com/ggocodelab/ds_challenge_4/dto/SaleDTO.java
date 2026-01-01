package com.ggocodelab.ds_challenge_4.dto;

import java.time.LocalDate;

import com.ggocodelab.ds_challenge_4.entities.Sale;

public class SaleDTO {
	
	private Long id;
	private Double amount;
	private LocalDate date;
	private SellerDTO seller;
	
	public SaleDTO() {
	}

	public SaleDTO(Long id, Double amount, LocalDate date, SellerDTO seller) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.seller = seller;
	}
	
	public SaleDTO(Sale entity) {
		id = entity.getId();
		amount = entity.getAmount();
		date = entity.getDate();
		this.seller = new SellerDTO(entity.getSeller());
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

	public SellerDTO getSeller() {
		return seller;
	}	
}
