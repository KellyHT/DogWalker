package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Product;
import pe.dogwalker.model.repository.ProductRepository;

@Named
public class ProductService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProductRepository productRepository;
	
	@Transactional
	public Long insert(Product product) throws Exception {
		return productRepository.insert(product);
	}
	
	public Long update(Product product) throws Exception {
		return productRepository.update(product);
	}

	@Transactional
	public void delete (Product product) throws Exception {
		productRepository.delete(product);
	}
	
	public List<Product> findAll() throws Exception {
		return productRepository.findAll();
	}
	
	public List<Product> findByName(String name) throws Exception {
		return productRepository.findByName(name);
	}
	
}
