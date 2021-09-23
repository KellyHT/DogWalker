package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.DetalleSolicitud;

@Named
public class DetalleSolicitudRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;

	public Long insert(DetalleSolicitud detalleSolicitud) throws Exception {
		em.persist(detalleSolicitud);
		return detalleSolicitud.getIdDetalle();
	}
	
	public Long update(DetalleSolicitud detalleSolicitud) throws Exception {
		em.merge(detalleSolicitud);
		return detalleSolicitud.getIdDetalle();
	}
	
	public void delete (DetalleSolicitud detalleSolicitud) throws Exception {
		em.remove(em.contains(detalleSolicitud)?detalleSolicitud: em.merge(detalleSolicitud));
	}
	
	public List<DetalleSolicitud> findAll() throws Exception {
		List<DetalleSolicitud> lista = new ArrayList<>(); 
		TypedQuery<DetalleSolicitud> query = em.createQuery("SELECT p FROM DetalleSolicitud p", DetalleSolicitud.class);
		lista = query.getResultList();
		return lista;		
	}
	
	public List<DetalleSolicitud> findByName(String name) throws Exception {
		List<DetalleSolicitud> lista = new ArrayList<>(); 
		TypedQuery<DetalleSolicitud> query = em.createQuery("SELECT p FROM DetalleSolicitud p WHERE p.name LIKE ?1", DetalleSolicitud.class);
		query.setParameter(1, "%" + name + "%");
		lista = query.getResultList();
		return lista;		
	}	


}
