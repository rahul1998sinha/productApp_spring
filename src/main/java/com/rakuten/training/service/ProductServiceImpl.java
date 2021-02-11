package com.rakuten.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.domain.Product;

@Service
public class ProductServiceImpl implements ProductService {
	ProductDAO dao; // = new ProductDAOInMemImpl();

	@Autowired
	public void setDao(ProductDAO dao) {
		this.dao = dao;
	}// Setter for Dependency Injection

	@Override
	public int createNewProduct(Product toBeCreated) {
		if (toBeCreated.getPrice() * toBeCreated.getQop() >= 10000) {
			Product created = dao.save(toBeCreated);
			return created.getId();
		} else {
			throw new IllegalArgumentException("The Product passed to create is not worth 10k");
		}
	}

	@Override
	public void removeExisting(int id) {
		Product existing = dao.findById(id);
		if (existing == null) {
			throw new IllegalArgumentException("Product with id" + id + "not available");
		}
		if (existing.getPrice() * existing.getQop() >= 100000) {
			throw new IllegalStateException("Cant delete stock as worth >=100k");
		}
		dao.deleteById(id);

	}

	@Override
	public List<Product> findAll() {
		return dao.findAll();
	}

	@Override
	public Product findById(int id) {
		return dao.findById(id);
	}

}
