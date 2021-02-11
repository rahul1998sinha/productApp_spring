package com.rakuten.training.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rakuten.training.domain.Review;

@Repository
@Transactional
public class ReviewDAOJpaImpl implements ReviewDAO {
	@Autowired
	EntityManager em;

	@Override
	public Review save(Review r) {
		em.persist(r);
		return r;
	}
	
	@Override
	public List<Review> findByProduct_Id(int pid){
		Query q = em.createQuery("select r from Review r where r.product.id=:productID");
		q.setParameter("productID", pid);
		return q.getResultList();
	}
	
	@Override
	public Review findByReview_Id(int pid){
		return em.find(Review.class, em);
	}

	@Override
	public void deleteByProductId(int pid) {
		Query q = em.createQuery("delete from Review r where r.product.id=:productId");
		q.setParameter("productId",pid);
		q.executeUpdate();
	}

	@Override
	public List<Review> findAllReviews() {
		Query q = em.createQuery("select r from Review as r");
		return q.getResultList();
	}

}
