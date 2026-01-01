package com.ggocodelab.ds_challenge_4.dto;

import com.ggocodelab.ds_challenge_4.entities.Seller;

public class SellerDTO {
	
	private Long id;
	
	private String name;
	
	public SellerDTO() {
	}

	public SellerDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public SellerDTO(Seller entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
