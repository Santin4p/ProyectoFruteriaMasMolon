package Modelo;

import java.io.Serializable;

public class Articulo implements Serializable {
	private String nombre, descripcion, codigo;
	private double precio;

	public Articulo() {
		// TODO Auto-generated constructor stub
	}

	public Articulo(String codigo, String nombre, String descripcion, double precio) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double calcularPVP() {
		return (precio + (precio * .21));
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
