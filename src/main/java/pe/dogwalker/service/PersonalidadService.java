package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Personalidad;
import pe.dogwalker.model.repository.PersonalidadRepository;

@Named
public class PersonalidadService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PersonalidadRepository personalidadRepository;
	
	@Transactional
	public Long insert(Personalidad personalidad) throws Exception {
		return personalidadRepository.insert(personalidad);
	}
	
	public Long update(Personalidad personalidad) throws Exception {
		return personalidadRepository.update(personalidad);
	}

	@Transactional
	public void delete (Personalidad personalidad) throws Exception {
		personalidadRepository.delete(personalidad);
	}
	
	public List<Personalidad> findAll() throws Exception {
		return personalidadRepository.findAll();
	}
	
	public List<Personalidad> findByName(String name) throws Exception {
		return personalidadRepository.findByName(name);
	}
	
}
