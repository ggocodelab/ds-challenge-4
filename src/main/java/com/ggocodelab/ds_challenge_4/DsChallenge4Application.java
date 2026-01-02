package com.ggocodelab.ds_challenge_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode;

@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
@SpringBootApplication
public class DsChallenge4Application {
	
	public static void main(String[] args) {
		SpringApplication.run(DsChallenge4Application.class, args);
	}

}
