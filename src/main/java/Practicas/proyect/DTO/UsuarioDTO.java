package Practicas.proyect.DTO;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private int id;
		private String usuario;
		private String nombre;
		private String apellidos;
		private String clave;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsuario() {
			return usuario;
		}
		public void setUsuario(String usuario) {
			this.usuario = usuario;
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
		public String getClave() {
			return clave;
		}
		public void setClave(String clave) {
			this.clave = clave;
		}
		
		
}
