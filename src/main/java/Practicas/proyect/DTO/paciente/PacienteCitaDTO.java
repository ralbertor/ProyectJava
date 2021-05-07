package Practicas.proyect.DTO.paciente;

import java.io.Serializable;
import java.util.Date;

import Practicas.proyect.entidades.Diagnostico;

public class PacienteCitaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private Date fechaHora;
	private String motivoCita;
	private PacienteMedicoDTO medico;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String clave;
	private Diagnostico diagnostico;
	
	
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
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
	public PacienteMedicoDTO getMedico() {
		return medico;
	}
	public void setMedico(PacienteMedicoDTO medico) {
		this.medico = medico;
	}
	
}
