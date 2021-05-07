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
import Practicas.proyect.DTO.medico.MedicoDTO;
import Practicas.proyect.controllers.MedicoController;
import Practicas.proyect.entidades.Medico;
import Practicas.proyect.entidades.Usuario;
import Practicas.proyect.service.MedicoService;
import Practicas.proyect.service.UsuarioService;
@CrossOrigin(origins = "http://localhost:4200", maxAge= 3600)
@RestController
public class MedicoControllerImpl implements MedicoController{

	@Autowired
	MedicoService medicoService;
	@Autowired
	UsuarioService usuarioService;
	ModelMapper modelMapper = new ModelMapper();

	private MedicoDTO convertToDTO(Medico medico) {
		MedicoDTO medicoDTO = modelMapper.map(medico, MedicoDTO.class);
		return medicoDTO;
	}
	private Medico convertToEntity(MedicoDTO medicoDTO) {
		Medico medico = modelMapper.map(medicoDTO,Medico.class);
		return medico;
	}
	
	@Override
	@RequestMapping(value = "/medicos", method = RequestMethod.GET, produces ="application/json")
	public List<MedicoDTO> getMedicos() {
		List<Medico> medicos = medicoService.findAllMedicos();
		List<MedicoDTO> medicosDTO = new LinkedList<MedicoDTO>();
		for(int i=0; i<medicos.size();i++) {
			medicosDTO.add(convertToDTO(medicos.get(i)));
		}
		return medicosDTO;
	}

	@Override
	@RequestMapping(value = "/medicos/{id}", method = RequestMethod.GET, produces = "application/json")
	public MedicoDTO getMedicoById(@PathVariable int id) {
		if(medicoService.findMedicoById(id).isPresent()) {
		return convertToDTO(medicoService.findMedicoById(id).get());
		}
		return null;
	}

	@Override
	@RequestMapping(value = "/medicos/add", method = RequestMethod.POST, produces = "application/json")
	public MedicoDTO addMedico(@RequestBody MedicoDTO medicoDTO) {
		Medico medico = convertToEntity(medicoDTO);
		return convertToDTO(medicoService.saveMedico(medico));
	}

	@Override
	@RequestMapping(value = "/medicos/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteMedico(@PathVariable int id) {
		return medicoService.deleteMedico(id);
	}

	@Override
	@RequestMapping(value = "/medicos/update", method = RequestMethod.PUT, produces = "application/json")
	public String updateMedico(@RequestBody MedicoDTO medicoDTO) {
		Medico medico = convertToEntity(medicoDTO);
			return medicoService.updateMedico(medico);
	}
	@Override
	@RequestMapping(value = "/medicos/login", method = RequestMethod.POST, produces = "application/json")
	public MedicoDTO loginMedico(@RequestBody UsuarioDTO usuario) {
		if(usuario.getUsuario()==null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			
		}
		Usuario usuarioAux = usuarioService.returnUsuario(usuario.getUsuario()); 
		if (usuarioAux==null){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return convertToDTO(medicoService.findMedicoById(usuarioAux.getId()).get());
	}
	
}
