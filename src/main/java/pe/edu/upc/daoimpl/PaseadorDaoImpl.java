package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPaseadorDao;
import pe.edu.upc.entity.Paseador;

public class PaseadorDaoImpl implements IPaseadorDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Paseador paseador) {		
		em.persist(paseador);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paseador> listar() {
		List<Paseador> lista = new ArrayList<Paseador>();
		Query q = em.createQuery("select m from Paseador m");
		lista = (List<Paseador>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idPaseador) {
		Paseador paseador = new Paseador();
		paseador = em.getReference(Paseador.class, idPaseador);
		em.remove(paseador);
	}	

}
