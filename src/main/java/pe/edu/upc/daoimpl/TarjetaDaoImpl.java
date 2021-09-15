package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITarjetaDao;
import pe.edu.upc.entity.Tarjeta;

public class TarjetaDaoImpl implements ITarjetaDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Tarjeta tarjeta) {		
		em.persist(tarjeta);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tarjeta> listar() {
		List<Tarjeta> lista = new ArrayList<Tarjeta>();
		Query q = em.createQuery("select t from Tarjeta t");
		lista = (List<Tarjeta>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idTarjeta) {
		Tarjeta tarjeta = new Tarjeta();
		tarjeta = em.getReference(Tarjeta.class, idTarjeta);
		em.remove(tarjeta);
	}	

}
