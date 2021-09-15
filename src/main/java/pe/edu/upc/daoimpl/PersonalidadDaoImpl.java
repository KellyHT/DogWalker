package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IPersonalidadDao;
import pe.edu.upc.entity.Personalidad;

public class PersonalidadDaoImpl implements IPersonalidadDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	@Transactional
	@Override
	public void insertar(Personalidad personalidad) {		
		em.persist(personalidad);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Personalidad> listar() {
		List<Personalidad> lista = new ArrayList<Personalidad>();
		Query q = em.createQuery("select m from Personalidad m");
		lista = (List<Personalidad>) q.getResultList();
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idPersonalidad) {
		Personalidad personalidad = new Personalidad();
		personalidad = em.getReference(Personalidad.class, idPersonalidad);
		em.remove(personalidad);
	}	

}
