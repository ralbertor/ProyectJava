package Practicas.proyect.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name= "USUARIO")
public abstract class Usuario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private int id;
	@Column(name="USUARIO")
	private String usuario;
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="APELLIDOS")
	private String apellidos;
	@Column(name="CLAVE")
	private String clave;

	public Usuario() {
		
	}

public Usuario( String usuario, String nombre, String apellidos, String clave) {
		super();
		this.usuario = usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.clave = clave;
	}

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
