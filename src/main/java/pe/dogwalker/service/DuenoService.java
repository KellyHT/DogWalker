package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Dueno;
import pe.dogwalker.model.repository.DuenoRepository;

@Named
public class DuenoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DuenoRepository duenoRepository;
	
	@Transactional
	public Long insert(Dueno dueno) throws Exception {
		return duenoRepository.insert(dueno);
	}
	
	@Transactional
	public Long update(Dueno dueno) throws Exception {
		return duenoRepository.update(dueno);
	}

	@Transactional
	public void delete (Dueno dueno) throws Exception {
		duenoRepository.delete(dueno);
	}
	
	public List<Dueno> findAll() throws Exception {
		return duenoRepository.findAll();
	}
	
	public List<Dueno> findByName(String name) throws Exception {
		return duenoRepository.findByName(name);
	}
	
	public List<Dueno> findByCorreoContrasena(String correo, String contrasena) throws Exception {
		return duenoRepository.findByCorreoContrasena(correo, contrasena);
	}
	

}
