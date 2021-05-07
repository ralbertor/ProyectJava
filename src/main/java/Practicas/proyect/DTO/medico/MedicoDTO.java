package Practicas.proyect.DTO.medico;

import java.io.Serializable;
import java.util.List;

public class MedicoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

		private String numColegiado;
		private List<MedicoCitaDTO> citas;
		private List<MedicoPacienteDTO> paciente;
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
		public String getNumColegiado() {
			return numColegiado;
		}
		public void setNumColegiado(String numColegiado) {
			this.numColegiado = numColegiado;
		}
		
		public List<MedicoCitaDTO> getCitas() {
			return citas;
		}
		public void setCitas(List<MedicoCitaDTO> citas) {
			this.citas = citas;
		}
		public List<MedicoPacienteDTO> getPaciente() {
			return paciente;
		}
		public void setPaciente(List<MedicoPacienteDTO> paciente) {
			this.paciente = paciente;
		}
		
		
}
