package Practicas.proyect.ControllerImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Practicas.proyect.DTO.UsuarioDTO;
import Practicas.proyect.controllers.UsuarioController;
import Practicas.proyect.entidades.Usuario;
import Practicas.proyect.service.UsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UsuarioControllerImpl implements UsuarioController{

	@Autowired
	UsuarioService usuarioService;
	ModelMapper modelMapper = new ModelMapper();

	private UsuarioDTO convertToDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
		return usuarioDTO;
	}
	private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
		Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);
		return usuario;
	}

	@Override
	@RequestMapping(value="/usuarios",method = RequestMethod.GET, produces = "application/json")
	public List<Usuario> getUsuarios() {
		return usuarioService.findAllUsuarios();
	}

	@Override
	@RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Usuario> getUsuarioById(@PathVariable("id") int id) {
		return usuarioService.findUsuarioById(id);
	}

	@Override
	@PostMapping
	@RequestMapping(value = "/usuarios/add", method = RequestMethod.POST, produces = "application/json")
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}

	@Override
	@RequestMapping(value = "/usuarios/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteUsuario(@PathVariable("id") int id) {
		return usuarioService.deleteUsuario(id);
	}

	@Override
	@RequestMapping(value = "/usuarios/update", method = RequestMethod.PUT, produces = "application/json")
	public String updateUsuario(@RequestBody Usuario usuario) {
		return usuarioService.updateUsuario(usuario);
	}
}
