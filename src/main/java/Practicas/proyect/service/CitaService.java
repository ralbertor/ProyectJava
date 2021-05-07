package Practicas.proyect.service;

import Practicas.proyect.entidades.*;
import java.util.*;

public interface CitaService {
	public List<Cita> findAllCita();
	
	public Optional<Cita> findCitaById(int id);
	
	public Cita saveCita(Cita citaNuevo);
	
	public String deleteCita(int id);
	
	public String updateCita(Cita citaNuevo);

}
