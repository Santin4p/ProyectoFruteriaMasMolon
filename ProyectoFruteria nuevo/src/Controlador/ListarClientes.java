package Controlador;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
	private ObjectOutputStream nuevo;

	public ListarClientes() throws ClassNotFoundException, IOException {
		setListaClientes(new ArrayList<Cliente>());
		try {
			if(new File(fichero).exists()){
				cargarClientes();
			}else{
				nuevo=new ObjectOutputStream(new FileOutputStream(fichero));
			}
		} catch (FileNotFoundException e) {
			
		}
	}
	
	public void guardarNuevoCliente(Cliente cliente) throws FileNotFoundException, IOException {
		getListaCliente().add(cliente);
		new AccesoFicheros().escribirObjeto(getListaCliente(),fichero);
	}
	
	public void cargarClientes() throws ClassNotFoundException, IOException {
		try {
			setListaClientes((ArrayList<Cliente>) new AccesoFicheros().leerObjeto(fichero));
		} catch (EOFException e) {
			
		}
		
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
		new AccesoFicheros().escribirObjeto(getListaCliente(),fichero);
	}
	
	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
	}
	public void crearNuevoElemento(String nombre, String apellidos,String DNI, String colorDePelo) throws FileNotFoundException, IOException {
		Cliente instancia = new Cliente(nombre, apellidos, DNI, colorDePelo);
		guardarNuevoCliente(instancia);
	}
	
	//Introduce la lista de clientes  en un panel
		public void listarCli(JComboBox Clientes) throws ClassNotFoundException, IOException {
			cargarClientes();
			for (Cliente cliente : getListaCliente()) {
				Clientes.addItem(cliente.getNombre() + " " + cliente.getApellidos());
			}
		}

	}

