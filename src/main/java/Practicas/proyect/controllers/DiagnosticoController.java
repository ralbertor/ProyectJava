package Practicas.proyect.controllers;

import Practicas.proyect.DTO.DiagnosticoDTO;
import java.util.*;

public interface DiagnosticoController {
	public List<DiagnosticoDTO> getDiagnostico();
	public DiagnosticoDTO getDiagnosticoById(int id);
	public DiagnosticoDTO addDiagnostico(DiagnosticoDTO diagnosticoDTO);
	public String deleteDiagnostico(int id);
	public String updateDiagnostico(DiagnosticoDTO diagnosticoDTO);
	//public String test();
	
}
