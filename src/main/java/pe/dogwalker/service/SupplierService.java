package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Supplier;
import pe.dogwalker.model.repository.SupplierRepository;

@Named
public class SupplierService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private SupplierRepository supplierRepository;
	
	public List<Supplier> findAll() throws Exception {
		return supplierRepository.findAll();
	}

}
