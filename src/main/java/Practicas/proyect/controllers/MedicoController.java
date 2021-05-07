package Practicas.proyect.controllers;

import java.util.*;

import Practicas.proyect.DTO.UsuarioDTO;
import Practicas.proyect.DTO.medico.MedicoDTO;

public interface MedicoController {
	public List<MedicoDTO> getMedicos();
	public MedicoDTO getMedicoById(int id);
	public MedicoDTO addMedico(MedicoDTO medicoDTO);
	public String deleteMedico(int id);
	public String updateMedico(MedicoDTO medicoDTO);
	public MedicoDTO loginMedico(UsuarioDTO usuario);
}
