package pe.dogwalker.model.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.dogwalker.model.entity.Supplier;

@Named
public class SupplierRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="pdw")
	private EntityManager em;
	
	public List<Supplier> findAll() throws Exception {
		List<Supplier> suppliers = new ArrayList<>(); // suppliers = listado de proveedores
		TypedQuery<Supplier> query = em.createQuery("SELECT s FROM Supplier s", Supplier.class);
		suppliers = query.getResultList();
		return suppliers;
	}
	
}
