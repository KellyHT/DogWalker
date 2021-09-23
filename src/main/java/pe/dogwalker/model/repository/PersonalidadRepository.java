package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Personalidad;

@Named
public class PersonalidadRepository implements  Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	

	public Long insert(Personalidad personalidad) throws Exception {
		em.persist(personalidad);
		return personalidad.getIdPersonalidad();
	}
	
	public Long update(Personalidad personalidad) throws Exception {
		em.merge(personalidad);
		return personalidad.getIdPersonalidad();
	}
	
	public void delete (Personalidad personalidad) throws Exception {
		em.remove(em.contains(personalidad)?personalidad: em.merge(personalidad));
	}
	
	public List<Personalidad> findAll() throws Exception {
		List<Personalidad> lista = new ArrayList<>(); 
		TypedQuery<Personalidad> query = em.createQuery("SELECT p FROM Personalidad p", Personalidad.class);
		lista = query.getResultList();
		return lista;		
	}
	
	public List<Personalidad> findByName(String name) throws Exception {
		List<Personalidad> lista = new ArrayList<>(); 
		TypedQuery<Personalidad> query = em.createQuery("SELECT p FROM Personalidad p WHERE p.name LIKE ?1", Personalidad.class);
		query.setParameter(1, "%" + name + "%");
		lista = query.getResultList();
		return lista;		
	}	

}
