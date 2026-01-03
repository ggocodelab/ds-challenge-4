package com.ggocodelab.ds_challenge_4.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SellerTotalDTO {
	
	@JsonIgnore
	private Long sellerId;
	private String sellerName;
	private Double total;
	
	
	public SellerTotalDTO(Long sellerId, String sellerName, Double total) {
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.total = total == null? 0.0 : total;		
	}

	public Long getSellerId() {
		return sellerId;
	}	

	public String getSellerName() {
		return sellerName;
	}

	public Double getTotal() {
		return total;
	}
}
