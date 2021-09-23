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
	
	public Long insert(Tarjeta tarjeta) throws Exception {
		em.persist(tarjeta);
		return tarjeta.getIdTarjeta();
	}
	
	public Long update(Tarjeta tarjeta) throws Exception {
		em.merge(tarjeta);
		return tarjeta.getIdTarjeta();
	}
	
	public void delete (Tarjeta tarjeta) throws Exception {
		em.remove(em.contains(tarjeta)?tarjeta: em.merge(tarjeta));
	}
	
	public List<Tarjeta> findAll() throws Exception {
		List<Tarjeta> lista = new ArrayList<>(); 
		TypedQuery<Tarjeta> query = em.createQuery("SELECT p FROM Tarjeta p", Tarjeta.class);
		lista = query.getResultList();
		return lista;		
	}
	
	public List<Tarjeta> findByName(String name) throws Exception {
		List<Tarjeta> lista = new ArrayList<>(); 
		TypedQuery<Tarjeta> query = em.createQuery("SELECT p FROM Tarjeta p WHERE p.name LIKE ?1", Tarjeta.class);
		query.setParameter(1, "%" + name + "%");
		lista = query.getResultList();
		return lista;		
	}	

}
