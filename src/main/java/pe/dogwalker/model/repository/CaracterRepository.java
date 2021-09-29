package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Caracter;

@Named
public class CaracterRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	public List<Caracter> findAll() throws Exception {
		List<Caracter> caracters = new ArrayList<>();
		TypedQuery<Caracter> query = em.createQuery("SELECT s FROM Caracter s", Caracter.class);
		caracters = query.getResultList();
		return caracters;
	}
	
	



}
