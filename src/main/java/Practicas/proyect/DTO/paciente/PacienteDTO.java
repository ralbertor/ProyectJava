package Practicas.proyect.DTO.paciente;

import java.io.Serializable;
import java.util.List;

public class PacienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String Nss;
	private String numTarjeta;
	private String telefono;
	private String direccion;
	private List<PacienteCitaDTO> cita;
	private List<PacienteMedicoDTO> medico;
	private int id;
	private String nombre;
	private String apellidos;
	private String usuario;
	private String clave;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getNss() {
		return Nss;
	}
	public void setNss(String nss) {
		Nss = nss;
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<PacienteCitaDTO> getCita() {
		return cita;
	}
	public void setCita(List<PacienteCitaDTO> cita) {
		this.cita = cita;
	}
	public List<PacienteMedicoDTO> getMedico() {
		return medico;
	}
	public void setMedico(List<PacienteMedicoDTO> medico) {
		this.medico = medico;
	}	

}
