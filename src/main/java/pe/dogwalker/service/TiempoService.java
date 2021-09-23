package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Tiempo;
import pe.dogwalker.model.repository.TiempoRepository;

@Named
public class TiempoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TiempoRepository tiempoRepository;
	
	@Transactional
	public Long insert(Tiempo tiempo) throws Exception {
		return tiempoRepository.insert(tiempo);
	}
	
	public Long update(Tiempo tiempo) throws Exception {
		return tiempoRepository.update(tiempo);
	}

	@Transactional
	public void delete (Tiempo tiempo) throws Exception {
		tiempoRepository.delete(tiempo);
	}
	
	public List<Tiempo> findAll() throws Exception {
		return tiempoRepository.findAll();
	}
	
	public List<Tiempo> findByName(String name) throws Exception {
		return tiempoRepository.findByName(name);
	}
	
}
