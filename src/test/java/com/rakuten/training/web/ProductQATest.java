package com.rakuten.training.web;

import org.springframework.web.client.RestTemplate;

import com.rakuten.training.domain.Product;

public class ProductQATest {

	public static void main(String[] args) {
		RestTemplate template = new RestTemplate();
		Product p = template.getForObject("http://localhost:8080/products/3",Product.class);
		// in junit following line would be replaced by assert
		if(p.getId()==3)
			System.out.println("success");
		else
			System.out.println("failure");
	}
}
