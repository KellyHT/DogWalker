package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICalificacionDao;
import pe.edu.upc.entity.Calificacion;

public class CalificacionDaoImpl implements ICalificacionDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Calificacion calificacion) {		
		em.persist(calificacion);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Calificacion> listar() {
		List<Calificacion> lista = new ArrayList<Calificacion>();
		Query q = em.createQuery("select c from Calificacion c");
		lista = (List<Calificacion>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idCalificacion) {
		Calificacion calificacion = new Calificacion();
		calificacion = em.getReference(Calificacion.class, idCalificacion);
		em.remove(calificacion);
	}	

}
