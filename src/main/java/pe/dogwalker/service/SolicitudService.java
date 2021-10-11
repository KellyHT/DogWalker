package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;


import pe.dogwalker.model.entity.Dueno;
import pe.dogwalker.model.entity.Solicitud;
import pe.dogwalker.model.repository.SolicitudRepository;

@Named
public class SolicitudService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private SolicitudRepository solicitudRepository;
	
	@Transactional
	public Long insert(Solicitud solicitud) throws Exception {
		return solicitudRepository.insert(solicitud);
	}
	
	@Transactional
	public Long update(Solicitud solicitud) throws Exception {
		return solicitudRepository.update(solicitud);
	}

	@Transactional
	public void delete (Solicitud solicitud) throws Exception {
		solicitudRepository.delete(solicitud);
	}
	
	public List<Solicitud> findAll() throws Exception {
		return solicitudRepository.findAll();
	}
	
	public List<Solicitud> findByName(String name) throws Exception {
		return solicitudRepository.findByName(name);
	}
	

	
	public List<Solicitud> listarSolicitudesPorDueno(Dueno dueno)throws Exception{
		return solicitudRepository.listarSolicitudesPorDueno(dueno);
		
	}
	
}
