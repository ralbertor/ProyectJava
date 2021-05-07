package Practicas.proyect.service;

import Practicas.proyect.entidades.*;
import java.util.*;

public interface MedicoService {
	public List<Medico> findAllMedicos();
	
	public Optional<Medico> findMedicoById(int id);
	
	public Medico saveMedico(Medico medicoNuevo);
	
	public String deleteMedico(int id);
	
	public String updateMedico(Medico medicoNuevo);
}
