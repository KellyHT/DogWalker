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
	
	
	public List<Personalidad> findAll() throws Exception {
		List<Personalidad> lista = new ArrayList<>(); 
		TypedQuery<Personalidad> query = em.createQuery("SELECT p FROM Personalidad p", Personalidad.class);
		lista = query.getResultList();
		return lista;		
	}

	

}
