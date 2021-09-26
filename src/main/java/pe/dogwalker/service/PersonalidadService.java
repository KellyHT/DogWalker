package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import pe.dogwalker.model.entity.Personalidad;
import pe.dogwalker.model.repository.PersonalidadRepository;

@Named
public class PersonalidadService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private PersonalidadRepository personalidadRepository;

	public List<Personalidad> findAll() throws Exception {
		return personalidadRepository.findAll();
	}
	
	
}
