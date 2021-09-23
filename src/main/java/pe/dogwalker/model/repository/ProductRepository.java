package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Product;

@Named
public class ProductRepository implements  Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	public Long insert(Product product) throws Exception {
		em.persist(product);
		return product.getId();
	}
	
	public Long update(Product product) throws Exception {
		em.merge(product);
		return product.getId();
	}
	
	public void delete (Product product) throws Exception {
		em.remove(em.contains(product)?product: em.merge(product));
	}
	
	public List<Product> findAll() throws Exception {
		List<Product> products = new ArrayList<>(); // products = listado de productos
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
		products = query.getResultList();
		return products;		
	}
	
	public List<Product> findByName(String name) throws Exception {
		List<Product> products = new ArrayList<>(); 
		TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p WHERE p.name LIKE ?1", Product.class);
		query.setParameter(1, "%" + name + "%");
		products = query.getResultList();
		return products;		
	}	

}
