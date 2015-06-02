package Modelo;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

public class LineasDePedido {

	ArrayList<LineasDePedido> linea = new ArrayList<>();
	String art;
	int cantidad;

	public LineasDePedido() {

	}

	public LineasDePedido(String art, int cantidad) {
		super();
		this.art = art;
		this.cantidad = cantidad;
	}

	public ArrayList<LineasDePedido> getLinea() {
		return linea;
	}

	public void setLinea(ArrayList<LineasDePedido> linea) {
		this.linea = linea;
	}

	public String getArt() {
		return art;
	}

	public void setArt(String art) {
		this.art = art;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}