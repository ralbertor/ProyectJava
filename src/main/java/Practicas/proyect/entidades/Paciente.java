package Practicas.proyect.entidades;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="PACIENTE")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Paciente extends Usuario{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name= "NSS")
	private String Nss;
	@Column(name= "NUMTARJETA")
	private String numTarjeta;
	@Column(name= "TELEFONO")
	private String telefono;
	@Column(name= "DIRECCION")
	private String direccion;
	@OneToMany(mappedBy="paciente", cascade = CascadeType.ALL)
	@Column(name="CITA")
	private List<Cita> cita;
	@ManyToMany(targetEntity=Medico.class)
	@Column(name="MEDICO")
	private List<Medico> medico;
	
	public Paciente() {
		
	}
	

	public Paciente(String usuario, String nombre, String apellidos, String clave, String nss, String numTarjeta, String telefono, String direccion) {
		super(usuario, nombre, apellidos, clave);
		Nss = nss;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
		this.cita =new LinkedList<Cita>();
		this.medico =new LinkedList<Medico>();
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



	public List<Cita> getCita() {
		return cita;
	}



	public void setCita(List<Cita> cita) {
		this.cita = cita;
	}



	public List<Medico> getMedico() {
		return medico;
	}



	public void setMedico(List<Medico> medico) {
		this.medico = medico;
	}


}
