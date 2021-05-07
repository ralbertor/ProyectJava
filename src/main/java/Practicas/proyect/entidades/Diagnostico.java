package Practicas.proyect.entidades;

import javax.persistence.*;

@Entity
@Table(name="DIAGNOSTICO")
public class Diagnostico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="ENFERMEDAD")
	private String enfermedad;
	
	@Column(name="VALORACION")
	private String valoracionEspecialista;
	
	@OneToOne(mappedBy="diagnostico")
	private Cita cita;

	public Diagnostico() {
		
	}

	public Diagnostico(int id, String enfermedad, String valoracionEspecialista, Cita cita) {
		super();
		this.id = id;
		this.enfermedad = enfermedad;
		this.valoracionEspecialista = valoracionEspecialista;
		this.cita = cita;
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public Cita getCita() {
		return cita;
	}




	public void setCita(Cita cita) {
		this.cita = cita;
	}




	public String getEnfermedad() {
		return enfermedad;
	}


	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}


	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}


	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}


}
