package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICanDao;
import pe.edu.upc.entity.Can;

public class CanDaoImpl implements ICanDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Can can) {		
		em.persist(can);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Can> listar() {
		List<Can> lista = new ArrayList<Can>();
		Query q = em.createQuery("select c from Can c");
		lista = (List<Can>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idCan) {
		Can can = new Can();
		can = em.getReference(Can.class, idCan);
		em.remove(can);
	}	

}
