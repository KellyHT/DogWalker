package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.Paseador;
import pe.dogwalker.model.repository.PaseadorRepository;

@Named
public class PaseadorService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PaseadorRepository paseadorRepository;
	
	@Transactional
	public Long insert(Paseador paseador) throws Exception {
		return paseadorRepository.insert(paseador);
	}
	@Transactional
	public Long update(Paseador paseador) throws Exception {
		return paseadorRepository.update(paseador);
	}

	@Transactional
	public void delete (Paseador paseador) throws Exception {
		paseadorRepository.delete(paseador);
	}
	
	public List<Paseador> findAll() throws Exception {
		return paseadorRepository.findAll();
	}
	
	public List<Paseador> findByName(String name) throws Exception {
		return paseadorRepository.findByName(name);
	}
	
	public List<Paseador> findByDistrito(String name) throws Exception {
		return paseadorRepository.findByDistrito(name);
	}
	public List<Paseador> findByCorreoContrasena(String correo, String contrasena) throws Exception {
		return paseadorRepository.findByCorreoContrasena(correo, contrasena);
	}
	
}
