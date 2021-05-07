package Practicas.proyect.ControllerImpl;

import java.util.LinkedList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import Practicas.proyect.DTO.UsuarioDTO;

import Practicas.proyect.DTO.paciente.PacienteDTO;
import Practicas.proyect.controllers.PacienteController;
import Practicas.proyect.entidades.Paciente;
import Practicas.proyect.entidades.Usuario;
import Practicas.proyect.service.PacienteService;
import Practicas.proyect.service.UsuarioService;
@CrossOrigin(origins = "http://localhost:4200", maxAge= 3600)
@RestController
public class PacienteControllerImpl implements PacienteController{
	
	@Autowired
	PacienteService pacienteService;
	@Autowired
	UsuarioService usuarioService;
	ModelMapper modelMapper = new ModelMapper();

	private PacienteDTO convertToDTO(Paciente paciente) {
		PacienteDTO pacienteDTO = modelMapper.map(paciente, PacienteDTO.class);
		return pacienteDTO;
	}
	private Paciente convertToEntity(PacienteDTO pacienteDTO) {
		Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);
		return paciente;
	}
	
	@RequestMapping(value = "/pacientes", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<PacienteDTO> getPacientes() {
		List<Paciente> pacientes = pacienteService.findAllPacientes();
		List<PacienteDTO> pacientesDTO = new LinkedList<PacienteDTO>();
		for(int i = 0; i<pacientes.size();i++) {
			pacientesDTO.add(convertToDTO(pacientes.get(i)));
		}
		return pacientesDTO;
	}

	@Override
	@RequestMapping(value = "/pacientes/{id}", method = RequestMethod.GET, produces ="application/json")
	public PacienteDTO getPacienteById(@PathVariable int id) {
		if (pacienteService.findPacienteById(id).isPresent()) {
		return convertToDTO(pacienteService.findPacienteById(id).get());
		}
		return null;
	}

	@Override
	@RequestMapping(value = "/pacientes/add", method = RequestMethod.POST, produces = "application/json")
	public PacienteDTO addPaciente(@RequestBody PacienteDTO pacienteDTO) {
		System.out.println("entro a paciente");
		Paciente paciente = convertToEntity(pacienteDTO);
		return convertToDTO(pacienteService.savePaciente(paciente));
	 		
	}

	@Override
	@RequestMapping(value = "/pacientes/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deletePaciente(@PathVariable int id) {
		return pacienteService.deletePaciente(id);
	}

	@Override
	@RequestMapping(value = "/pacientes/update", method = RequestMethod.PUT, produces = "application/json")
	public String updatePaciente(@RequestBody PacienteDTO pacienteDTO) {
		Paciente paciente = convertToEntity(pacienteDTO);
		return pacienteService.updatePaciente(paciente);
	}
	@Override
	@RequestMapping(value = "/pacientes/login", method = RequestMethod.POST, produces = "application/json")
	public PacienteDTO loginPaciente(@RequestBody UsuarioDTO usuario) {
		
		if(usuario.getUsuario()==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		Usuario usuarioAux = usuarioService.returnUsuario(usuario.getUsuario()); 
		if (usuarioAux==null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		PacienteDTO  paciente = convertToDTO(pacienteService.findPacienteById(usuarioAux.getId()).get());;
		return paciente;
	}
}
