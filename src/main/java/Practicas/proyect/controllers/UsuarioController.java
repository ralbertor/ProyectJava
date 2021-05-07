package Practicas.proyect.controllers;

import Practicas.proyect.entidades.*;
import java.util.*;

public interface UsuarioController {
	public List<Usuario> getUsuarios();
	public Optional<Usuario> getUsuarioById(int id);
	public Usuario addUsuario(Usuario usuario);
	public String deleteUsuario(int id);
	public String updateUsuario(Usuario usuario);
}

