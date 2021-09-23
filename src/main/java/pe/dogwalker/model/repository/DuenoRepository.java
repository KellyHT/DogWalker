package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Dueno;

@Named
public class DuenoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	public Long insert(Dueno dueno) throws Exception {
		em.persist(dueno);
		return dueno.getId();
	}
	
	public Long update(Dueno dueno) throws Exception {
		em.merge(dueno);
		return dueno.getId();
	}
	
	public void delete (Dueno dueno) throws Exception {
		em.remove(em.contains(dueno)?dueno: em.merge(dueno));
	}
	
	public List<Dueno> findAll() throws Exception {
		List<Dueno> lista = new ArrayList<>(); 
		TypedQuery<Dueno> query = em.createQuery("SELECT p FROM Dueno p", Dueno.class);
		lista = query.getResultList();
		return lista;		
	}
	
	public List<Dueno> findByName(String name) throws Exception {
		List<Dueno> lista = new ArrayList<>(); 
		TypedQuery<Dueno> query = em.createQuery("SELECT p FROM Dueno p WHERE p.nombre LIKE ?1", Dueno.class);
		query.setParameter(1, "%" + name + "%");
		lista = query.getResultList();
		return lista;		
	}	

}
