package marp.service;

import marp.entity.Product;
import marp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	@Transactional(readOnly = false)
	public void save(Product product) {
		repository.save(product);
	}

	@Override
	public Product get(Long id) {
		return repository.findOne(id);
	}

	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		repository.delete(id);
	}

}
