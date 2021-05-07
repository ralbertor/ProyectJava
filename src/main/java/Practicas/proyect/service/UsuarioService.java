package Practicas.proyect.service;

import Practicas.proyect.DTO.UsuarioDTO;
import Practicas.proyect.entidades.*;
import java.util.*;

public interface UsuarioService {
	public List<Usuario> findAllUsuarios();
	
	public Optional<Usuario> findUsuarioById(int id);
	
	public Usuario saveUsuario(Usuario usuarioNuevo);
	
	public String deleteUsuario(int id);
	
	public String updateUsuario(Usuario usuarioNuevo);
	
	public Usuario returnUsuario(String usuario);
}
