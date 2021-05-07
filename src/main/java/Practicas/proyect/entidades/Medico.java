package Practicas.proyect.entidades;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="MEDICO")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Medico extends Usuario{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name= "NUMCOLEGIADO")
	private String numColegiado;
	@OneToMany
	@JoinColumn(name="CITA")
	private List<Cita> citas;
	@ManyToMany(targetEntity=Paciente.class)
	@Column(name="PACIENTE")
	private List<Paciente> paciente;
	
	public Medico() {
		
	}

	public Medico(String nombre, String  apellidos, String clave, String usuario,String numColegiado) {
		super(usuario, nombre, apellidos, clave);
		this.numColegiado = numColegiado;
		this.citas = new LinkedList<Cita>();
		this.paciente =new LinkedList<Paciente>();
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public List<Paciente> getPaciente() {
		return paciente;
	}

	public void setPaciente(List<Paciente> paciente) {
		this.paciente = paciente;
	}

}