package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Tiempo;

@Named
public class TiempoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	public List<Tiempo> findAll() throws Exception {
		List<Tiempo> lista = new ArrayList<>(); 
		TypedQuery<Tiempo> query = em.createQuery("SELECT p FROM Tiempo p", Tiempo.class);
		lista = query.getResultList();
		return lista;		
	}
	
}
