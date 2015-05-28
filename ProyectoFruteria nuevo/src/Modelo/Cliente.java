package Modelo;

import java.io.Serializable;

public class Cliente implements Serializable {
	String nombre;
	String apellidos;
	String DNI;
	String colorDePelo;
	
	public Cliente(){
		
	}
	
	public Cliente(String nombre, String apellidos, String dNI,
			String colorDePelo) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
		this.colorDePelo = colorDePelo;
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

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		DNI = DNI;
	}

	public String getColorDePelo() {
		return colorDePelo;
	}

	public void setColorDePelo(String colorDePelo) {
		this.colorDePelo = colorDePelo;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", DNI=" + DNI + ", colorDePelo=" + colorDePelo + "]";
	}

}
