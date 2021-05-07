package Practicas.proyect.controllers;

import Practicas.proyect.DTO.UsuarioDTO;
import Practicas.proyect.DTO.paciente.PacienteDTO;

import java.util.*;

public interface PacienteController {
	public List<PacienteDTO> getPacientes();
	public PacienteDTO getPacienteById(int id);
	public PacienteDTO addPaciente(PacienteDTO pacienteDTO);
	public String deletePaciente(int id);
	public String updatePaciente(PacienteDTO pacienteDTO);
	public PacienteDTO loginPaciente(UsuarioDTO usuario);
}
