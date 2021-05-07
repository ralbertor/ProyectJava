package Practicas.proyect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import Practicas.proyect.entidades.*;

public interface PacienteRepository extends JpaRepository<Paciente,Integer>{
	
	Void save(Optional<Paciente> pacienteToUpdate);
}
