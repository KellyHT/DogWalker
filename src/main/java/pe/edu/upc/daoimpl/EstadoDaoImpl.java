package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IEstadoDao;
import pe.edu.upc.entity.Estado;

public class EstadoDaoImpl implements IEstadoDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Estado estado) {		
		em.persist(estado);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> listar() {
		List<Estado> lista = new ArrayList<Estado>();
		Query q = em.createQuery("select e from Estado e");
		lista = (List<Estado>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idEstado) {
		Estado estado = new Estado();
		estado = em.getReference(Estado.class, idEstado);
		em.remove(estado);
	}	

}
