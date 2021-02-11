package com.rakuten.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.rakuten.training.dal.ProductRepository;
import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Review;
import com.rakuten.training.service.ReviewService;
import com.rakuten.training.ui.ProductConsoleUI;

@SpringBootApplication
public class ProductsappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductsappApplication.class, args);
		
		
		
		
		
		//ProductConsoleUI ui = springContainer.getBean(ProductConsoleUI.class);
		//ui.createProductWithUI();
		//testReviewAssociation(springContainer);
		//testSpringDataRepository(springContainer);
		
	}

//	private static void testSpringDataRepository(ApplicationContext springContainer) {
//		ProductRepository repo = springContainer.getBean(ProductRepository.class);
//		Product p = new Product("repo",10000,10);
//		Product saved = repo.save(p);
//		System.out.println("Saved product with id"+saved.getId());
//	}
//
//	private static void testReviewAssociation(ApplicationContext springContainer) {
//		Review aReview = new Review("self", "very good", 5);
//		
//		ReviewService svc = springContainer.getBean(ReviewService.class);
//		
//		svc.addReviewToProduct(aReview, 1);
//	}

}
