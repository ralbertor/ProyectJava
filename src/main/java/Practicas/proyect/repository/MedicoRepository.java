package Practicas.proyect.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import Practicas.proyect.entidades.*;

public interface MedicoRepository extends JpaRepository<Medico,Integer>{

	Void save(Optional<Medico> medicoToUpdate);
}
