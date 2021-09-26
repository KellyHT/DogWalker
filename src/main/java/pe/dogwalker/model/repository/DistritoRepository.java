package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Distrito;

@Named
public class DistritoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	public List<Distrito> findAll() throws Exception {
		List<Distrito> distritos = new ArrayList<>();
		TypedQuery<Distrito> query = em.createQuery("SELECT s FROM Distrito s", Distrito.class);
		distritos = query.getResultList();
		return distritos;
	}
	
	

	public List<Distrito> findByName(String name) throws Exception {
		List<Distrito> lista = new ArrayList<>(); 
		TypedQuery<Distrito> query = em.createQuery("SELECT d FROM Distrito d WHERE d.name LIKE ?1", Distrito.class);
		query.setParameter(1, "%" + name + "%");
		lista = query.getResultList();
		return lista;		
	}	



}
