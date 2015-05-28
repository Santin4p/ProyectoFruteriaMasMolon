package Controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JComboBox;

import Modelo.AccesoFicheros;
import Modelo.Cliente;

public class ListarClientes implements Serializable{
	private ArrayList<Cliente> listaCliente;
	final String fichero = "clientes.dat";

	public ListarClientes() throws ClassNotFoundException, IOException {
		setListaClientes(new ArrayList<Cliente>());
		try {
			if(new File(fichero).exists())
				cargarClientes();
		} catch (FileNotFoundException e) {
		}
	}
	
	public void guardarNuevoCliente(Cliente cliente) throws FileNotFoundException, IOException {
		getListaCliente().add(cliente);
		new AccesoFicheros().escribirObjeto(getListaCliente(), fichero);
	}
	
	public void cargarClientes() throws ClassNotFoundException, IOException {
		setListaClientes((ArrayList<Cliente>) new AccesoFicheros().leerObjeto(fichero));
	}

	public void setListaClientes(ArrayList<Cliente> listaClient) {
		this.listaCliente = listaClient;
	}
	
public boolean buscarCliente(String nombre, String apellidos,String DNI, String colorDePelo){
		Cliente instancia = new Cliente(nombre, apellidos, DNI, colorDePelo);
		for (int i = 0; i < getListaCliente().size(); i++) {
			if (getListaCliente().get(i).toString().equals(instancia.toString())) {
				return true;
			}
		}return false;
	}
	
	public void modificarCliente(int indice, String colorPelo) throws FileNotFoundException, IOException{
		listaCliente.get(indice).setColorDePelo(colorPelo);
		new AccesoFicheros().escribirObjeto(getListaCliente(), fichero);
	}
	
	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}
	public void crearNuevoElemento(String nombre, String apellidos,String DNI, String colorDePelo) throws FileNotFoundException, IOException {
		Cliente instancia = new Cliente(nombre, apellidos, DNI, colorDePelo);
		guardarNuevoCliente(instancia);
	}
}
