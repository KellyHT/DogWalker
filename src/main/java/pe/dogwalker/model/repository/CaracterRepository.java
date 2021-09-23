package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Caracter;
@Named
public class CaracterRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	public Long insert(Caracter caracter) throws Exception {
		em.persist(caracter);
		return caracter.getIdCaracter();
	}
	
	public Long update(Caracter caracter) throws Exception {
		em.merge(caracter);
		return caracter.getIdCaracter();
	}
	
	public void delete (Caracter caracter) throws Exception {
		em.remove(em.contains(caracter)?caracter: em.merge(caracter));
	}
	
	public List<Caracter> findAll() throws Exception {
		List<Caracter> lista = new ArrayList<>(); 
		TypedQuery<Caracter> query = em.createQuery("SELECT p FROM Caracter p", Caracter.class);
		lista = query.getResultList();
		return lista;		
	}
	
	public List<Caracter> findByName(String name) throws Exception {
		List<Caracter> lista = new ArrayList<>(); 
		TypedQuery<Caracter> query = em.createQuery("SELECT p FROM Caracter p WHERE p.name LIKE ?1", Caracter.class);
		query.setParameter(1, "%" + name + "%");
		lista = query.getResultList();
		return lista;		
	}	

}
