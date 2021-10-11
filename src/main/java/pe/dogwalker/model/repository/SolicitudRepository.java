package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import pe.dogwalker.model.entity.Dueno;
import pe.dogwalker.model.entity.Solicitud;

@Named
public class SolicitudRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pdw")
	private EntityManager em;

	public Long insert(Solicitud solicitud) throws Exception {
		em.persist(solicitud);
		return solicitud.getIdSolicitud();
	}

	public Long update(Solicitud solicitud) throws Exception {
		em.merge(solicitud);
		return solicitud.getIdSolicitud();
	}

	public void delete(Solicitud solicitud) throws Exception {
		em.remove(em.contains(solicitud) ? solicitud : em.merge(solicitud));
	}

	public List<Solicitud> findAll() throws Exception {
		List<Solicitud> lista = new ArrayList<>();
		TypedQuery<Solicitud> query = em.createQuery("SELECT p FROM Solicitud p", Solicitud.class);
		lista = query.getResultList();
		return lista;
	}

	public List<Solicitud> findByName(String name) throws Exception {
		List<Solicitud> lista = new ArrayList<>();
		TypedQuery<Solicitud> query = em.createQuery("SELECT p FROM Solicitud p WHERE p.nombre LIKE ?1", Solicitud.class);
		query.setParameter(1, "%" + name + "%");
		lista = query.getResultList();
		return lista;
	}
	
	public List<Solicitud> listarSolicitudesPorDueno(Dueno dueno) throws Exception {
		List<Solicitud> lista = new ArrayList<>(); 
		TypedQuery<Solicitud> query = em.createQuery("SELECT s FROM Solicitud s WHERE s.dueno =? 1", Solicitud.class);
		query.setParameter(1,dueno);
		lista = query.getResultList();
		return lista;		
	}	
}
