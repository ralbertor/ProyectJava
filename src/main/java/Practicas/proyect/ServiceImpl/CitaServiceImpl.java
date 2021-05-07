package Practicas.proyect.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practicas.proyect.entidades.Cita;
import Practicas.proyect.repository.CitaRepository;
import Practicas.proyect.service.CitaService;

@Service
public class CitaServiceImpl implements CitaService{

	@Autowired
	CitaRepository citaRepository;
	
	@Override
	public List<Cita> findAllCita() {
		return citaRepository.findAll();
	}

	@Override
	public Optional<Cita> findCitaById(int id) {
		Optional<Cita> cita = citaRepository.findById(id);
		return cita;
	}

	@Override
	public Cita saveCita(Cita citaNuevo) {
		if (citaNuevo !=null) {
			return citaRepository.save(citaNuevo);
		}
		return null;
	}

	@Override
	public String deleteCita(int id) {
		if(citaRepository.findById(id).isPresent()) {
			citaRepository.deleteById(id);
			return "Cita eliminada correctamente";
		}
		return "Error la cita no existe";
	}

	@Override
	public String updateCita(Cita citaNuevo) {
		int num = citaNuevo.getId();
		if(citaRepository.findById(num).isPresent()) {
			Cita citaToUpdate = new Cita();
			citaToUpdate.setDiagnostico(citaNuevo.getDiagnostico());
			citaToUpdate.setFechaHora(citaNuevo.getFechaHora());
			citaToUpdate.setId(citaNuevo.getId());
			citaToUpdate.setMedico(citaNuevo.getMedico());
			citaToUpdate.setMotivoCita(citaNuevo.getMotivoCita());
			citaToUpdate.setPaciente(citaNuevo.getPaciente());
			citaRepository.save(citaToUpdate);
			return "Cita modificada";
		}
		return "Error al modificar la cita";
	}

}
