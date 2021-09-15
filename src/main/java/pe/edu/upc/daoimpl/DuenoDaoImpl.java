package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDuenoDao;
import pe.edu.upc.entity.Dueno;

public class DuenoDaoImpl implements IDuenoDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Dueno dueno) {		
		em.persist(dueno);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dueno> listar() {
		List<Dueno> lista = new ArrayList<Dueno>();
		Query q = em.createQuery("select m from Dueno m");
		lista = (List<Dueno>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idDueno) {
		Dueno dueno = new Dueno();
		dueno = em.getReference(Dueno.class, idDueno);
		em.remove(dueno);
	}	

}
