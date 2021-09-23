package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Can;

@Named
public class CanRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	public Long insert(Can can) throws Exception {
		em.persist(can);
		return can.getIdCan();
	}
	
	public Long update(Can can) throws Exception {
		em.merge(can);
		return can.getIdCan();
	}
	
	public void delete (Can can) throws Exception {
		em.remove(em.contains(can)?can: em.merge(can));
	}
	
	public List<Can> findAll() throws Exception {
		List<Can> lista = new ArrayList<>(); 
		TypedQuery<Can> query = em.createQuery("SELECT p FROM Can p", Can.class);
		lista = query.getResultList();
		return lista;		
	}
	
	public List<Can> findByName(String name) throws Exception {
		List<Can> lista = new ArrayList<>(); 
		TypedQuery<Can> query = em.createQuery("SELECT p FROM Can p WHERE p.name LIKE ?1", Can.class);
		query.setParameter(1, "%" + name + "%");
		lista = query.getResultList();
		return lista;		
	}	

}
