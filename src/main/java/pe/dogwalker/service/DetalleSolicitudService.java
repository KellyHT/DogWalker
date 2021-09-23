package pe.dogwalker.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import pe.dogwalker.model.entity.DetalleSolicitud;
import pe.dogwalker.model.repository.DetalleSolicitudRepository;

@Named
public class DetalleSolicitudService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DetalleSolicitudRepository detalleSolicitudRepository;
	
	@Transactional
	public Long insert(DetalleSolicitud detalleSolicitud) throws Exception {
		return detalleSolicitudRepository.insert(detalleSolicitud);
	}
	
	public Long update(DetalleSolicitud detalleSolicitud) throws Exception {
		return detalleSolicitudRepository.update(detalleSolicitud);
	}

	@Transactional
	public void delete (DetalleSolicitud detalleSolicitud) throws Exception {
		detalleSolicitudRepository.delete(detalleSolicitud);
	}
	
	public List<DetalleSolicitud> findAll() throws Exception {
		return detalleSolicitudRepository.findAll();
	}
	
	public List<DetalleSolicitud> findByName(String name) throws Exception {
		return detalleSolicitudRepository.findByName(name);
	}
	
}
