package Practicas.proyect.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practicas.proyect.entidades.Paciente;
import Practicas.proyect.repository.PacienteRepository;
import Practicas.proyect.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService{
	@Autowired
	PacienteRepository pacienteRepository;

	@Override
	public List<Paciente> findAllPacientes() {
		return pacienteRepository.findAll();
	}

	@Override
	public Optional<Paciente> findPacienteById(int id) {
		Optional<Paciente> paciente = pacienteRepository.findById(id);
				return paciente;
	}

	@Override
	public Paciente savePaciente(Paciente pacienteNuevo) {
			return pacienteRepository.save(pacienteNuevo);
	}

	@Override
	public String deletePaciente(int id) {
		if(pacienteRepository.findById(id).isPresent()) {
			pacienteRepository.deleteById(id);
			return "Paciente eliminado correctamente";
		}
		return "Error el medico no existe";
	}

	@Override
	public String updatePaciente(Paciente pacienteNuevo) {
		int num = pacienteNuevo.getId();
		if(pacienteRepository.findById(num).isPresent()) {
			Paciente pacienteToUpdate = new Paciente();
			pacienteToUpdate.setId(pacienteNuevo.getId());
			pacienteToUpdate.setApellidos(pacienteNuevo.getApellidos());
			pacienteToUpdate.setCita(pacienteNuevo.getCita());
			pacienteToUpdate.setClave(pacienteNuevo.getClave());
			pacienteToUpdate.setDireccion(pacienteNuevo.getDireccion());
			pacienteToUpdate.setMedico(pacienteNuevo.getMedico());
			pacienteToUpdate.setNombre(pacienteNuevo.getNombre());
			pacienteToUpdate.setNss(pacienteNuevo.getNss());
			pacienteToUpdate.setNumTarjeta(pacienteNuevo.getNumTarjeta());
			pacienteToUpdate.setTelefono(pacienteNuevo.getTelefono());
			pacienteToUpdate.setUsuario(pacienteNuevo.getUsuario());
			pacienteToUpdate.setCita(pacienteNuevo.getCita());
			pacienteRepository.save(pacienteToUpdate);
			return "Paciente modificado";
		}
		return "Error al modificar el paciente";
		
	}
	
}
