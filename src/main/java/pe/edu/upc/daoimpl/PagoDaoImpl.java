package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPagoDao;
import pe.edu.upc.entity.Pago;

public class PagoDaoImpl implements IPagoDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Pago pago) {		
		em.persist(pago);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pago> listar() {
		List<Pago> lista = new ArrayList<Pago>();
		Query q = em.createQuery("select p from Pago p");
		lista = (List<Pago>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idPago) {
		Pago pago = new Pago();
		pago = em.getReference(Pago.class, idPago);
		em.remove(pago);
	}	

}
