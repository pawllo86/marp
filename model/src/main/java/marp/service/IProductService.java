package marp.service;

import marp.entity.Product;

import java.util.List;

public interface IProductService {

	void save(Product product);

	Product get(Long id);

	List<Product> findAll();

	void delete(Long id);

}
