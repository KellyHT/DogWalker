package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Estado;
@Named
public class EstadoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	

	public Long insert(Estado estado) throws Exception {
		em.persist(estado);
		return estado.getIdEstado();
	}
	
	public Long update(Estado estado) throws Exception {
		em.merge(estado);
		return estado.getIdEstado();
	}
	
	public void delete (Estado estado) throws Exception {
		em.remove(em.contains(estado)?estado: em.merge(estado));
	}
	
	public List<Estado> findAll() throws Exception {
		List<Estado> lista = new ArrayList<>(); 
		TypedQuery<Estado> query = em.createQuery("SELECT p FROM Estado p", Estado.class);
		lista = query.getResultList();
		return lista;		
	}
	
	public List<Estado> findByName(String name) throws Exception {
		List<Estado> lista = new ArrayList<>(); 
		TypedQuery<Estado> query = em.createQuery("SELECT p FROM Estado p WHERE p.name LIKE ?1", Estado.class);
		query.setParameter(1, "%" + name + "%");
		lista = query.getResultList();
		return lista;		
	}	
}
