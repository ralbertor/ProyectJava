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

import Practicas.proyect.DTO.Cita.CitaDTO;
import Practicas.proyect.controllers.CitaController;
import Practicas.proyect.entidades.Cita;
import Practicas.proyect.service.CitaService;
@CrossOrigin(origins = "http://localhost:4200", maxAge= 3600)
@RestController
public class CitaControllerImpl implements CitaController{
	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	CitaService citaService;
	
	private CitaDTO convertToDTO(Cita cita) {
		CitaDTO citaDTO = modelMapper.map(cita, CitaDTO.class);
		return citaDTO;
	}
	private Cita convertToEntity(CitaDTO citaDTO) {
		Cita cita = modelMapper.map(citaDTO, Cita.class);
		return cita;
	}
	
	@Override
	@RequestMapping(value = "/citas", method = RequestMethod.GET, produces = "application/json")
	public List<CitaDTO> getCita() {
		List<Cita> citas = citaService.findAllCita();
		List<CitaDTO> citasDTO = new LinkedList<CitaDTO>();
		for(int i=0; i<citas.size();i++) {
			citasDTO.add(convertToDTO(citas.get(i)));
		}
		return citasDTO;
	}

	@Override
	@RequestMapping(value = "/citas/{id}", method = RequestMethod.GET, produces = "application/json")
	public CitaDTO getCitaById(@PathVariable int id) {
		if(citaService.findCitaById(id).isPresent()) {
		return convertToDTO(citaService.findCitaById(id).get());
		}
		return null;
	}

	@Override
	@RequestMapping(value = "/citas/add", method = RequestMethod.POST, produces = "application/json")
	public CitaDTO addCita(@RequestBody CitaDTO citaDTO) {
		Cita cita = convertToEntity(citaDTO);
		return convertToDTO(citaService.saveCita(cita));
	}

	@Override
	@RequestMapping(value = "/citas/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public String deleteCita(@PathVariable int id) {
		return citaService.deleteCita(id);
	}

	@Override
	@RequestMapping(value = "/citas/update", method = RequestMethod.PUT, produces = "application/json")
	public String updateCita(@RequestBody CitaDTO citaDTO) {
		Cita cita = convertToEntity(citaDTO);
		return citaService.updateCita(cita);
	}
	
}
