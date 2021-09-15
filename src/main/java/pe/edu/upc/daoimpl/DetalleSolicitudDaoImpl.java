package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDetalleSolicitudDao;
import pe.edu.upc.entity.DetalleSolicitud;

public class DetalleSolicitudDaoImpl implements IDetalleSolicitudDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(DetalleSolicitud detalleSolicitud) {		
		em.persist(detalleSolicitud);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DetalleSolicitud> listar() {
		List<DetalleSolicitud> lista = new ArrayList<DetalleSolicitud>();
		Query q = em.createQuery("select ds from DetalleSolicitud ds");
		lista = (List<DetalleSolicitud>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idDetalleSolicitud) {
		DetalleSolicitud detalleSolicitud = new DetalleSolicitud();
		detalleSolicitud = em.getReference(DetalleSolicitud.class, idDetalleSolicitud);
		em.remove(detalleSolicitud);
	}	

}
