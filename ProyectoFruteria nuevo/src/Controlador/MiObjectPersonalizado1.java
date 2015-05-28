package Controlador;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MiObjectPersonalizado1 extends ObjectOutputStream{

	public MiObjectPersonalizado1(OutputStream out) throws IOException {
		super(out);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void writeStreamHeader() throws IOException {
		reset();
	}
}
