package Practicas.proyect.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import Practicas.proyect.entidades.*;


public interface CitaRepository extends JpaRepository<Cita,Integer>{
	
	Void save(Optional<Cita> citaToUpdate);

}
