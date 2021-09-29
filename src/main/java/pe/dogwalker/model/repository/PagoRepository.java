package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Pago;

@Named
public class PagoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "pdw")
	private EntityManager em;

	public Long insert(Pago pago) throws Exception {
		em.persist(pago);
		return pago.getIdPago();
	}

	public Long update(Pago pago) throws Exception {
		em.merge(pago);
		return pago.getIdPago();
	}

	public void delete(Pago pago) throws Exception {
		em.remove(em.contains(pago) ? pago : em.merge(pago));
	}

	public List<Pago> findAll() throws Exception {
		List<Pago> lista = new ArrayList<>();
		TypedQuery<Pago> query = em.createQuery("SELECT p FROM Pago p", Pago.class);
		lista = query.getResultList();
		return lista;
	}

	public List<Pago> findByName(String name) throws Exception {
		List<Pago> lista = new ArrayList<>();
		TypedQuery<Pago> query = em.createQuery("SELECT p FROM Pago p WHERE p.nombre LIKE ?1", Pago.class);
		query.setParameter(1, "%" + name + "%");
		lista = query.getResultList();
		return lista;
	}
	


}
