package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {
	String fecha;
	int numeroPedido;
	String cliente;
	ArrayList precio = new ArrayList();
	ArrayList cantidad = new ArrayList();
	ArrayList total = new ArrayList();
	ArrayList<Articulo> art = new ArrayList();
	ArrayList nombreArt = new ArrayList();

	public Pedido() {

	}

	public Pedido(String fecha, int numeroPedido, String cliente, ArrayList<Articulo> art, ArrayList nombreArt,
			ArrayList precio, ArrayList cantidad, ArrayList total) {
		super();
		this.fecha = fecha;
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
		this.precio = precio;
		this.cantidad = cantidad;
		this.total = total;
		this.art = art;
		this.nombreArt = nombreArt;
	}

	public Pedido(String fecha, int numeroPedido, String cliente, ArrayList<Articulo> art, ArrayList nombreArt) {
		super();
		this.fecha = fecha;
		this.numeroPedido = numeroPedido;
		this.cliente = cliente;
		this.art = art;
		this.nombreArt = nombreArt;
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

	public ArrayList getNombreArt() {
		return nombreArt;
	}

	public void setNombreArt(ArrayList nombreArt) {
		this.nombreArt = nombreArt;
	}

	public ArrayList getPrecio() {
		return precio;
	}

	public void setPrecio(ArrayList precio) {
		this.precio = precio;
	}

	public ArrayList getCantidad() {
		return cantidad;
	}

	public void setCantidad(ArrayList cantidad) {
		this.cantidad = cantidad;
	}

	public ArrayList getTotal() {
		return total;
	}

	public void setTotal(ArrayList total) {
		this.total = total;
	}

}
