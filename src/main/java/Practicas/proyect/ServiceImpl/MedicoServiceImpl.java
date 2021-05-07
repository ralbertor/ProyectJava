package Practicas.proyect.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practicas.proyect.entidades.Medico;
import Practicas.proyect.repository.MedicoRepository;
import Practicas.proyect.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService{
	@Autowired
	MedicoRepository medicoRepository;

	@Override
	public List<Medico> findAllMedicos() {
		return medicoRepository.findAll();
	}

	@Override
	public Optional<Medico> findMedicoById(int id) {
		Optional<Medico> medico = medicoRepository.findById(id);
		return medico;
	}

	@Override
	public Medico saveMedico(Medico medicoNuevo) {
		if(medicoNuevo != null) {
			return medicoRepository.save(medicoNuevo);
		}
		return new Medico();
	}

	@Override
	public String deleteMedico(int id) {
		if(medicoRepository.findById(id).isPresent()) {
			medicoRepository.deleteById(id);
			return "Medico eliminado correctamente";
		}
		return "Error el medico no existe";
	}

	@Override
	public String updateMedico(Medico medicoNuevo) {
		int num = medicoNuevo.getId();
		if(medicoRepository.findById(num).isPresent()) {
			Medico medicoToUpdate = new Medico();
			medicoToUpdate.setId(medicoNuevo.getId());
			medicoToUpdate.setApellidos(medicoNuevo.getApellidos());
			medicoToUpdate.setClave(medicoNuevo.getClave());
			medicoToUpdate.setNombre(medicoNuevo.getNombre());
			medicoToUpdate.setUsuario(medicoNuevo.getUsuario());
			medicoToUpdate.setNumColegiado(medicoNuevo.getNumColegiado());
			medicoToUpdate.setPaciente(medicoNuevo.getPaciente());
			medicoToUpdate.setCitas(medicoNuevo.getCitas());
			medicoRepository.save(medicoToUpdate);
			return "Medico Modificado";
		}
		return "Error al modificar el Medico";
	}

}
