package Practicas.proyect.ControllerImpl;

import java.util.LinkedList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Practicas.proyect.DTO.DiagnosticoDTO;
import Practicas.proyect.controllers.DiagnosticoController;
import Practicas.proyect.entidades.Diagnostico;
import Practicas.proyect.service.DiagnosticoService;
@CrossOrigin(origins = "http://localhost:4200", maxAge= 3600)
@RestController
public class DiagnosticoControllerImpl implements DiagnosticoController{

	@Autowired
	DiagnosticoService diagnosticoService;
	ModelMapper modelMapper = new ModelMapper();

	private DiagnosticoDTO convertToDTO(Diagnostico diagnostico) {
		DiagnosticoDTO diagnosticoDTO = modelMapper.map(diagnostico, DiagnosticoDTO.class);
		return diagnosticoDTO;
	}
	private Diagnostico convertToEntity(DiagnosticoDTO diagnosticoDTO) {
		Diagnostico diagnostico = modelMapper.map(diagnosticoDTO, Diagnostico.class);
		return diagnostico;
	}
	
	@Override
	@RequestMapping(value = "/diagnosticos", method = RequestMethod.GET, produces ="application/json")
	public List<DiagnosticoDTO> getDiagnostico() {
		List<Diagnostico> diagnosticos = diagnosticoService.findAllDiagnosticos();
		List<DiagnosticoDTO> diagnosticosDTO = new LinkedList<DiagnosticoDTO>();
		for(int i=0; i<diagnosticos.size();i++) {
			diagnosticosDTO.add(convertToDTO(diagnosticos.get(i)));
		}
		return diagnosticosDTO;
	}

	@Override
	@RequestMapping(value = "/diagnosticos/{id}", method = RequestMethod.GET, produces = "application/json")
	public DiagnosticoDTO getDiagnosticoById(@PathVariable int id) {
		if(diagnosticoService.findDiagnosticoById(id).isPresent()) {
		return convertToDTO(diagnosticoService.findDiagnosticoById(id).get());
	}
		return null;
	}

	@Override
	@RequestMapping(value = "/diagnosticos/add", method = RequestMethod.POST, produces = "application/json")
	public DiagnosticoDTO addDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO) {
		Diagnostico diagnostico = convertToEntity(diagnosticoDTO);
		return convertToDTO(diagnosticoService.saveDiagnostico(diagnostico));
	}

	@Override
	@RequestMapping(value = "/diagnosticos/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteDiagnostico(@PathVariable int id) {
		return diagnosticoService.deleteDiagnostico(id);
	}

	@Override
	@RequestMapping(value = "/diagnosticos/update", method = RequestMethod.PUT, produces = "application/json")
	public String updateDiagnostico(@RequestBody DiagnosticoDTO diagnosticoDTO) {
		Diagnostico diagnostico = convertToEntity(diagnosticoDTO);
		return diagnosticoService.updateDiagnostico(diagnostico);
	}

}
