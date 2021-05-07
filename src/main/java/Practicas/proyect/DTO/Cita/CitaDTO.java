package Practicas.proyect.DTO.Cita;
import java.io.Serializable;
import java.util.*;
import Practicas.proyect.DTO.DiagnosticoDTO;

public class CitaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private Date fechaHora;
	private String motivoCita;
	private CitaPacienteDTO paciente;
	private CitaMedicoDTO medico;
	private DiagnosticoDTO diagnostico;
	
	
	public DiagnosticoDTO getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(DiagnosticoDTO diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getMotivoCita() {
		return motivoCita;
	}
	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}
	public CitaPacienteDTO getPaciente() {
		return paciente;
	}
	public void setPaciente(CitaPacienteDTO paciente) {
		this.paciente = paciente;
	}
	public CitaMedicoDTO getMedico() {
		return medico;
	}
	public void setMedico(CitaMedicoDTO medico) {
		this.medico = medico;
	}

	

}
