package Modelo;

import java.awt.TextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JComboBox;

public class CrearPedido implements Serializable {
	private ArrayList<Pedido> listaPedido;
	final String fichero = "Pedido.dat";//

	public CrearPedido() throws ClassNotFoundException, IOException {
		setListaPedido(new ArrayList<Pedido>());
		try {
			if (new File(fichero).exists())
				cargarPedido();
		} catch (FileNotFoundException e) {
		}
	}

	public void guardarNuevoPedido(Pedido pedido) throws FileNotFoundException, IOException {
		getListaPedido().add(pedido);
		new AccesoFicheros().escribirObjeto(getListaPedido(), fichero);//
	}

	public void cargarPedido() throws ClassNotFoundException, IOException {
		setListaPedido((ArrayList<Pedido>) new AccesoFicheros().leerObjeto(fichero));
	}

	public void setListaPedido(ArrayList<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}

	public ArrayList<Pedido> getListaPedido() {
		return listaPedido;
	}

	public void crearNuevoPedido(String fecha, int numeroPedido, String cliente, ArrayList<Articulo> arrayList)
			throws FileNotFoundException, IOException {
		Pedido instancia = new Pedido(fecha, numeroPedido, cliente, arrayList);
		guardarNuevoPedido(instancia);
	}

	public void guardarArticulosPedido(ArrayList<Articulo> art) throws FileNotFoundException, IOException {
		Pedido instancia = new Pedido(art);
		guardarNuevoPedido(instancia);
	}

	// Introduce la lista de clientes en un panel
	public void listarPedido() throws ClassNotFoundException, IOException {
		cargarPedido();
		for (Pedido pedido : getListaPedido()) {
			System.out.println("Nombre cliente " + pedido.getCliente());
			System.out.println("fecha " + pedido.getFecha());
			System.out.println("numero pedido " + pedido.getNumeroPedido());
			System.out.println("art " + pedido.getArt());
		}

	}

}
