package Practicas.proyect.repository;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

import Practicas.proyect.entidades.Usuario;


public interface UsuarioRepository extends CrudRepository<Usuario,Integer>{
	
	Void save(Optional<Usuario> usuarioToUpdate);
	Usuario findByUsuario(String usuario);
}

