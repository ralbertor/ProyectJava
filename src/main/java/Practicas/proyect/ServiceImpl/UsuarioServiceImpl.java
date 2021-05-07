package Practicas.proyect.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Practicas.proyect.entidades.*;
import Practicas.proyect.repository.*;
import Practicas.proyect.service.*;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> findAllUsuarios() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findUsuarioById(int id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario;
	}

	@Override
	public Usuario saveUsuario(Usuario usuarioNuevo) {
			return usuarioRepository.save(usuarioNuevo);
	
	}

	@Override
	public String deleteUsuario(int id) {
		if(usuarioRepository.findById(id).isPresent()) {
			usuarioRepository.deleteById(id);;
			return "Usuario eliminado correctamente";
		}
		return "Error! El Usuario no existe";
	}

	@Override
	public String updateUsuario(Usuario usuarioNuevo) {
		return null;
	}	

	public Usuario returnUsuario(String usuario) {
		return usuarioRepository.findByUsuario(usuario);
		
	}
}
