package com.rakuten.training.service;

import java.util.List;

import com.rakuten.training.domain.Review;

public interface ReviewService {

	Review addReviewToProduct(Review r, int productId);

	List<Review> findByProduct_Id(int pid);

	Review findByReview_Id(int pid);

	void deleteByReviewByProductId(int pid);
	
	List<Review> findAllReviews();
}