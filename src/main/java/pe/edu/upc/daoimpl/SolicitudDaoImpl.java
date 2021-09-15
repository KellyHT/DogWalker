package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ISolicitudDao;
import pe.edu.upc.entity.Solicitud;

public class SolicitudDaoImpl implements ISolicitudDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Solicitud solicitud) {		
		em.persist(solicitud);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> listar() {
		List<Solicitud> lista = new ArrayList<Solicitud>();
		Query q = em.createQuery("select s from Solicitud s");
		lista = (List<Solicitud>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idSolicitud) {
		Solicitud solicitud = new Solicitud();
		solicitud = em.getReference(Solicitud.class, idSolicitud);
		em.remove(solicitud);
	}	

}
