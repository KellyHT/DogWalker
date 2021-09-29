package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Pago;
import pe.dogwalker.model.repository.PagoRepository;

@Named
public class PagoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PagoRepository pagoRepository;
	
	@Transactional
	public Long insert(Pago pago) throws Exception {
		return pagoRepository.insert(pago);
	}
	
	@Transactional
	public Long update(Pago pago) throws Exception {
		return pagoRepository.update(pago);
	}

	@Transactional
	public void delete (Pago pago) throws Exception {
		pagoRepository.delete(pago);
	}
	
	public List<Pago> findAll() throws Exception {
		return pagoRepository.findAll();
	}
	
	public List<Pago> findByName(String name) throws Exception {
		return pagoRepository.findByName(name);
	}
}
