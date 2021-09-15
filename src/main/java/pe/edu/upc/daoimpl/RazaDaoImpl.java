package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IRazaDao;
import pe.edu.upc.entity.Raza;

public class RazaDaoImpl implements IRazaDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Raza raza) {		
		em.persist(raza);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Raza> listar() {
		List<Raza> lista = new ArrayList<Raza>();
		Query q = em.createQuery("select m from Raza m");
		lista = (List<Raza>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idRaza) {
		Raza raza = new Raza();
		raza = em.getReference(Raza.class, idRaza);
		em.remove(raza);
	}	

}
