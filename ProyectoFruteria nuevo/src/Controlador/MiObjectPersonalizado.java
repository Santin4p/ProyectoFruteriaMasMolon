package Controlador;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectPersonalizado extends ObjectOutputStream {

	public MiObjectPersonalizado(OutputStream arg0) throws IOException {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void writeStreamHeader() throws IOException {
		reset();
	}
	
	

	

	

}
