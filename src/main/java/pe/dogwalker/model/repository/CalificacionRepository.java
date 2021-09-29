package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Calificacion;

@Named
public class CalificacionRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pdw")
	private EntityManager em;

	public Long insert(Calificacion calificacion) throws Exception {
		em.persist(calificacion);
		return calificacion.getIdCalificacion();
	}

	public Long update(Calificacion calificacion) throws Exception {
		em.merge(calificacion);
		return calificacion.getIdCalificacion();
	}

	public void delete(Calificacion calificacion) throws Exception {
		em.remove(em.contains(calificacion) ? calificacion : em.merge(calificacion));
	}

	public List<Calificacion> findAll() throws Exception {
		List<Calificacion> lista = new ArrayList<>();
		TypedQuery<Calificacion> query = em.createQuery("SELECT p FROM Calificacion p", Calificacion.class);
		lista = query.getResultList();
		return lista;
	}

	public List<Calificacion> findByName(String name) throws Exception {
		List<Calificacion> lista = new ArrayList<>();
		TypedQuery<Calificacion> query = em.createQuery("SELECT p FROM Calificacion p WHERE p.nombre LIKE ?1", Calificacion.class);
		query.setParameter(1, "%" + name + "%");
		lista = query.getResultList();
		return lista;
	}
	

}
