package Practicas.proyect.service;
import Practicas.proyect.entidades.*;
import java.util.*;

public interface PacienteService {
	public List<Paciente> findAllPacientes();
	
	public Optional<Paciente> findPacienteById(int id);
	
	public Paciente savePaciente(Paciente pacienteNuevo);
	
	public String deletePaciente(int id);
	
	public String updatePaciente(Paciente pacienteNuevo);

}
