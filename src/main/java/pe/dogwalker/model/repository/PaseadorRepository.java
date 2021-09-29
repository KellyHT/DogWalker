package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Paseador;

@Named
public class PaseadorRepository implements  Serializable{

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	public Long insert(Paseador paseador) throws Exception {
		em.persist(paseador);
		return paseador.getId();
	}
	
	public Long update(Paseador paseador) throws Exception {
		em.merge(paseador);
		return paseador.getId();
	}
	
	public void delete (Paseador paseador) throws Exception {
		em.remove(em.contains(paseador)?paseador: em.merge(paseador));
	}
	
	public List<Paseador> findAll() throws Exception {
		List<Paseador> paseadores = new ArrayList<>(); // paseadores = listado de paseadoros
		TypedQuery<Paseador> query = em.createQuery("SELECT p FROM Paseador p", Paseador.class);
		paseadores = query.getResultList();
		return paseadores;		
	}
	
	public List<Paseador> findByName(String name) throws Exception {
		List<Paseador> paseadores = new ArrayList<>(); 
		TypedQuery<Paseador> query = em.createQuery("SELECT p FROM Paseador p WHERE p.nombre LIKE ?1", Paseador.class);
		query.setParameter(1, "%" + name + "%");
		paseadores = query.getResultList();
		return paseadores;		
	}
	public List<Paseador> findByCorreoContrasena(String correo, String contrasena)  {
		List<Paseador> lista = new ArrayList<>();
		TypedQuery<Paseador> query = em.createQuery("SELECT p FROM Paseador p WHERE p.correo LIKE ?1 and p.contrasena LIKE ?2 ", Paseador.class);
		query.setParameter(1, correo);
		query.setParameter(2,contrasena);
		System.out.print("query " + query);
		lista = query.getResultList();
		return lista;
	}
	
	public List<Paseador> findByDistrito(String nombre) throws Exception {
	List<Paseador> paseadores = new ArrayList<>(); 
	TypedQuery<Paseador> query = em.createQuery("SELECT p FROM Paseador p left join fetch p.distrito  where p.distrito.nombre  LIKE ?1", Paseador.class);
	query.setParameter(1, "%" + nombre + "%");
	paseadores = query.getResultList();
	return paseadores;		
}	

	
}
