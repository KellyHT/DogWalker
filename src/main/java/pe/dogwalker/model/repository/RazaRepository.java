package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Raza;

@Named
public class RazaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	public List<Raza> findAll() throws Exception {
		List<Raza> lista = new ArrayList<>(); 
		TypedQuery<Raza> query = em.createQuery("SELECT p FROM Raza p", Raza.class);
		lista = query.getResultList();
		return lista;		
	}
	
}
