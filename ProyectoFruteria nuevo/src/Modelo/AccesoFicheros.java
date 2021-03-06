package Modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Controlador.MiObjectPersonalizado1;

public class AccesoFicheros {
	
	public Object leerObjeto(String ruta) throws IOException, ClassNotFoundException {
		try {
			return new ObjectInputStream(new BufferedInputStream(new FileInputStream(ruta))).readObject();
		} catch (EOFException e) {
			
		}
		return new ObjectInputStream(new BufferedInputStream(new FileInputStream(ruta))).readObject();
	}
	
	public void escribirObjeto(Object objeto, String ruta) throws FileNotFoundException, IOException{
		ObjectOutputStream objetoEscritura=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(ruta)));
		objetoEscritura.writeObject(objeto);
		objetoEscritura.close();
	}
}
