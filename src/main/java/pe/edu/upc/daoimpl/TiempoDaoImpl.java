package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITiempoDao;
import pe.edu.upc.entity.Tiempo;

public class TiempoDaoImpl implements ITiempoDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Tiempo tiempo) {		
		em.persist(tiempo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tiempo> listar() {
		List<Tiempo> lista = new ArrayList<Tiempo>();
		Query q = em.createQuery("select t from Tiempo t");
		lista = (List<Tiempo>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idTiempo) {
		Tiempo tiempo = new Tiempo();
		tiempo = em.getReference(Tiempo.class, idTiempo);
		em.remove(tiempo);
	}	

}
