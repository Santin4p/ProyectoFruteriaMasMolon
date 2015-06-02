package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
	String fecha;
	int numeroPedido;
	String cliente;
	ArrayList<Articulo> art = new ArrayList();

	public Pedido() {

	}

	public Pedido(String fecha, int numeroPedido, String cliente) {
		super();
		fecha = fecha;
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
	}
	
	public Pedido(String fecha, int numeroPedido, String cliente, ArrayList<Articulo> art) {
		super();
		this.fecha = fecha;
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
		this.art = art;
	}

	public Pedido(ArrayList<Articulo> art) {
		this.art = art;
	}
	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		fecha = fecha;
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Articulo> getArt() {
		return art;
	}

	public void setArt(ArrayList<Articulo> art) {
		this.art = art;
	}

}
