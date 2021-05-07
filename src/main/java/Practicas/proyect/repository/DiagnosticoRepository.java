package Practicas.proyect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import Practicas.proyect.entidades.*;

public interface DiagnosticoRepository extends JpaRepository<Diagnostico,Integer>{
	
	Void save(Optional<Diagnostico> diagnosticoToUpdate);
}
