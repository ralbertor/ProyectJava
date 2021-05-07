package Practicas.proyect.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practicas.proyect.entidades.Diagnostico;
import Practicas.proyect.repository.DiagnosticoRepository;
import Practicas.proyect.service.DiagnosticoService;
@Service
public class DiagnosticoServiceImpl implements DiagnosticoService{

	@Autowired
	DiagnosticoRepository diagnosticoRepository;
	@Override
	public List<Diagnostico> findAllDiagnosticos() {
		return diagnosticoRepository.findAll();
	}

	@Override
	public Optional<Diagnostico> findDiagnosticoById(int id) {
		Optional<Diagnostico> diagnostico = diagnosticoRepository.findById(id);
		return diagnostico;
	}

	@Override
	public Diagnostico saveDiagnostico(Diagnostico diagnosticoNuevo) {
		if(diagnosticoNuevo !=null) {
			return diagnosticoRepository.save(diagnosticoNuevo);
		}
		return new Diagnostico();
	}

	@Override
	public String deleteDiagnostico(int id) {
		if(diagnosticoRepository.findById(id).isPresent()) {
			diagnosticoRepository.deleteById(id);
			return "Diagnostico eliminado correctamente";
		}
		return "Error el diagnostico no existe";
	}

	@Override
	public String updateDiagnostico(Diagnostico diagnosticoNuevo) {
		int num = diagnosticoNuevo.getId();
		if(diagnosticoRepository.findById(num).isPresent()) {
			Diagnostico diagnosticoToUpdate = new Diagnostico();
			diagnosticoToUpdate.setCita(diagnosticoNuevo.getCita());
			diagnosticoToUpdate.setEnfermedad(diagnosticoNuevo.getEnfermedad());
			diagnosticoToUpdate.setId(diagnosticoNuevo.getId());
			diagnosticoToUpdate.setValoracionEspecialista(diagnosticoNuevo.getValoracionEspecialista());
			diagnosticoRepository.save(diagnosticoNuevo);
			return "Diagnostico modificado";
		}
		return "Error al modificar el diagnostico";
	}

}
