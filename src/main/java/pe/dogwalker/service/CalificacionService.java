package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Calificacion;
import pe.dogwalker.model.repository.CalificacionRepository;

@Named
public class CalificacionService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CalificacionRepository calificacionRepository;
	
	@Transactional
	public Long insert(Calificacion calificacion) throws Exception {
		return calificacionRepository.insert(calificacion);
	}
	
	@Transactional
	public Long update(Calificacion calificacion) throws Exception {
		return calificacionRepository.update(calificacion);
	}

	@Transactional
	public void delete (Calificacion calificacion) throws Exception {
		calificacionRepository.delete(calificacion);
	}
	
	public List<Calificacion> findAll() throws Exception {
		return calificacionRepository.findAll();
	}
	
	public List<Calificacion> findByName(String name) throws Exception {
		return calificacionRepository.findByName(name);
	}
	
}
