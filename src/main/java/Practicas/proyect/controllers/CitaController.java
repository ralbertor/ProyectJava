package Practicas.proyect.controllers;

import java.util.*;

import Practicas.proyect.DTO.Cita.CitaDTO;

public interface CitaController {
	public List<CitaDTO> getCita();
	public CitaDTO getCitaById(int id);
	public CitaDTO addCita(CitaDTO citaDTO);
	public String deleteCita(int id);
	public String updateCita(CitaDTO citaDTO);
	//public String test();

}
