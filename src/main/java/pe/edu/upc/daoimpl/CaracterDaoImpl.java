package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICaracterDao;
import pe.edu.upc.entity.Caracter;

public class CaracterDaoImpl implements ICaracterDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Caracter caracter) {		
		em.persist(caracter);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caracter> listar() {
		List<Caracter> lista = new ArrayList<Caracter>();
		Query q = em.createQuery("select c from Caracter c");
		lista = (List<Caracter>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idCaracter) {
		Caracter caracter = new Caracter();
		caracter = em.getReference(Caracter.class, idCaracter);
		em.remove(caracter);
	}	

}
