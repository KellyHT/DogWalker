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
	
	
	public List<Estado> findAll() throws Exception {
		List<Estado> estados = new ArrayList<>();
		TypedQuery<Estado> query = em.createQuery("SELECT s FROM Estado s", Estado.class);
		estados = query.getResultList();
		return estados;
	}
	
}
