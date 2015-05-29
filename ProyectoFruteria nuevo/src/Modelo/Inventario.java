package Modelo;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Controlador.MiObjectPersonalizado;


public class Inventario implements Serializable {
	private File articulo;
	private FileInputStream flujoEscritura;
	private ObjectInputStream objetoLectura;
	private ObjectOutputStream objetoEscritura;
	private ArrayList<Articulo> listaArticulos;
	protected MiObjectPersonalizado oospers;

	public Inventario() {
		listaArticulos = new ArrayList<Articulo>();
		articulo = new File("articulos.obj");
		if (!articulo.exists()) {
			try {
				objetoEscritura = new ObjectOutputStream(new FileOutputStream(articulo));
				objetoLectura = new ObjectInputStream(new FileInputStream(articulo));
				oospers = new MiObjectPersonalizado(new FileOutputStream(articulo, true));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				oospers = new MiObjectPersonalizado(new FileOutputStream(articulo, true));
				objetoLectura = new ObjectInputStream(new FileInputStream(articulo));
				listaArticulos = leerObjToArray();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public ArrayList<Articulo> leerObjToArray() {
		ArrayList<Articulo> auxLista;
		auxLista = new ArrayList<Articulo>();
		try {
			objetoLectura = new ObjectInputStream(new FileInputStream(articulo));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			Articulo a = (Articulo) objetoLectura.readObject();
			while (a != null) {
				auxLista.add(a);
				a = (Articulo) objetoLectura.readObject();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			// Esto salta cuando termina de leer el archivo
			try {
				objetoLectura.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return auxLista;

	}

	private boolean comprobarArray(Articulo articulo) {
		boolean encontrado = false;
		int tamanoArray = listaArticulos.size() - 1;
		while (!encontrado && tamanoArray >= 0) {
			if (articulo.getCodigo().equals(listaArticulos.get(tamanoArray).getCodigo())) {
				encontrado = true;
			} else {
				tamanoArray--;
			}

		}

		return encontrado;
	}

	private boolean escribirObj(Articulo art) {
		boolean escrito = false;
		try {
			oospers = new MiObjectPersonalizado(new FileOutputStream(articulo,true));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (!comprobarArray(art)) {
			try {
				escrito = true;
				oospers.writeObject(art);
				oospers.reset();
				listaArticulos = leerObjToArray();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			oospers.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return escrito;
	}

	public boolean guardarArticulo(Articulo art) {
		boolean guardado = false;
		guardado = escribirObj(art);
		return guardado;
	}
	
	public Articulo buscarArticulo(String codigo){
		boolean encontrado = false;
		Articulo art=null;
		int tamanoArray = listaArticulos.size()-1;
		while (!encontrado && tamanoArray >= 0) {
			if (codigo.equals(listaArticulos.get(tamanoArray).getCodigo())) {
				art=listaArticulos.get(tamanoArray);
				encontrado = true;
			} else {
				tamanoArray--;
			}

		}
		return art;
	}

	public ArrayList<Articulo> getListaArticulos() {
		return listaArticulos;
	}

	public void setListaArticulos(ArrayList<Articulo> listaArticulos) {
		this.listaArticulos = listaArticulos;
	}

}
