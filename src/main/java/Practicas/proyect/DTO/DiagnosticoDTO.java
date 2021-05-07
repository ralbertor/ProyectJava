package Practicas.proyect.DTO;
import java.io.Serializable;

public class DiagnosticoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String enfermedad;
	private String valoracionEspecialista;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
