package Practicas.proyect.entidades;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="CITA")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="FECHAHORA")
	private Date fechaHora;
	@Column(name="MOTIVO")
	private String motivoCita;
	@ManyToOne
	@JoinColumn(name="PACIENTE")
	private Paciente paciente;
	@ManyToOne
	@JoinColumn(name="MEDICO")
	private Medico medico;
	@OneToOne
	@JoinTable(name = "CITA_DIAGNOSTICO", 
    joinColumns = 
      { @JoinColumn(name = "CITA_ID", referencedColumnName = "id") },
    inverseJoinColumns = { @JoinColumn(name = "DIAGNOSTICO_ID", referencedColumnName = "id") })
	private Diagnostico diagnostico;
	

	public Cita() {
		
	}
	public Cita(int id, Date fechaHora, String motivoCita, Paciente paciente, Medico medico, Diagnostico diagnostico) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.paciente = paciente;
		this.medico = medico;
		this.diagnostico = diagnostico;
	}
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Diagnostico getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(Diagnostico diagnostico) {
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
}