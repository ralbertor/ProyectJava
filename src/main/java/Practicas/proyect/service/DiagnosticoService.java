package Practicas.proyect.service;

import Practicas.proyect.entidades.*;
import java.util.*;

public interface DiagnosticoService {
	public List<Diagnostico> findAllDiagnosticos();
	
	public Optional<Diagnostico> findDiagnosticoById(int id);
	
	public Diagnostico saveDiagnostico(Diagnostico diagnosticoNuevo);
	
	public String deleteDiagnostico(int id);
	
	public String updateDiagnostico(Diagnostico diagnosticoNuevo);
}
