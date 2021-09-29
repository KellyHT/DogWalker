package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Tarjeta;

@Named
public class TarjetaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	public List<Tarjeta> findAll() throws Exception {
		List<Tarjeta> tarjetas = new ArrayList<>();
		TypedQuery<Tarjeta> query = em.createQuery("SELECT s FROM Tarjeta s", Tarjeta.class);
		tarjetas = query.getResultList();
		return tarjetas;
	}
	


}
