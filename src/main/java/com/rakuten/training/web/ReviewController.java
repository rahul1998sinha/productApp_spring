package com.rakuten.training.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakuten.training.domain.Product;
import com.rakuten.training.domain.Review;
import com.rakuten.training.service.ProductService;
import com.rakuten.training.service.ReviewService;

@CrossOrigin("http://localhost:3000")
@RestController
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> findAllReviews(){
		List<Review> result = reviewService.findAllReviews();
		if(result.size() != 0)
			return new ResponseEntity<List<Review>>(result,HttpStatus.OK);
		return new ResponseEntity<List<Review>>(HttpStatus.BAD_REQUEST);	
	}
	
	@GetMapping("/products/{idPathVariable}/reviews")
	public ResponseEntity<List<Review>> findReviewsByProductId(@PathVariable("idPathVariable") int id){
		Product p = productService.findById(id);
		if(p==null)
			return new ResponseEntity<List<Review>>(HttpStatus.NOT_FOUND);
		List<Review> result = reviewService.findByProduct_Id(id);
		if(result.size() != 0)
			return new ResponseEntity<List<Review>>(result,HttpStatus.OK);
		return new ResponseEntity<List<Review>>(HttpStatus.BAD_REQUEST);	
	}
	
	@PostMapping("/products/{idPathVariable}/reviews")
	public ResponseEntity<Review> addReviewToProduct(@RequestBody Review r,@PathVariable("idPathVariable") int id){
		Review toBeAdded = reviewService.addReviewToProduct(r, id);
		Product p = productService.findById(id);
		if(p==null)
			return new ResponseEntity<Review>(HttpStatus.NOT_FOUND);
		toBeAdded.setProduct(p);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/products/"+id+"/reviews/"+toBeAdded.getId()));
		return new ResponseEntity<Review>(toBeAdded,headers,HttpStatus.OK);
	}
}
