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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CrearPedido implements Serializable {
	public ArrayList<Pedido> listaPedido;
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

	public void crearNuevoPedido(String fecha, int numeroPedido, String cliente, ArrayList<Articulo> arrayList,
			ArrayList nombreart) throws FileNotFoundException, IOException {
		Pedido instancia = new Pedido(fecha, numeroPedido, cliente, arrayList, nombreart);
		guardarNuevoPedido(instancia);
	}

	public void guardarArticulosPedido(ArrayList<Articulo> art) throws FileNotFoundException, IOException {
		Pedido instancia = new Pedido(art);
		guardarNuevoPedido(instancia);
	}

	// Introduce la lista de clientes en un panel
	public void listarPedido(JTable table, JTextField numero, JTextField nombre, JTextField fecha)
			throws ClassNotFoundException, IOException {
		int num = Integer.valueOf(numero.getText()) - 1;

		if (Integer.valueOf(numero.getText()) <= 0 || num >= listaPedido.size()) {

			JOptionPane.showMessageDialog(null, "El numero de pedido no existe", "Error",
					JOptionPane.ERROR_MESSAGE);
			nombre.setText("");
			fecha.setText("");
		} else {
			cargarPedido();

			nombre.setText(listaPedido.get(num).getCliente());
			fecha.setText(listaPedido.get(num).getFecha());
			for (int j = 0; j < listaPedido.get(num).getArt().size(); j++) {
				Object[] datos = { null, null, null };
				((DefaultTableModel) table.getModel()).addRow(datos);
				table.setValueAt(listaPedido.get(num).getNombreArt().get(j), j, 0);
			}
		}

	}

	public void listarPedido() throws ClassNotFoundException, IOException {
		cargarPedido();
		System.out.println(listaPedido.get(0).getArt().get(1));

		System.out.println();
		for (Pedido pedido : listaPedido) {
			System.out.println(pedido.getArt());
			System.out.println(pedido.getNombreArt());
		}

	}

}
