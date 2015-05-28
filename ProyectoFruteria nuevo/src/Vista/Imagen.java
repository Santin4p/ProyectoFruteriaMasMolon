package Vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Imagen extends JPanel {

	public Imagen() {
		this.setSize(300, 400); // se selecciona el tamaño del panel
	}

	public void paint(Graphics grafico) {
		Dimension height = getSize();

		// Se selecciona la imagen que tenemos en el paquete de la //ruta del
		// programa

		ImageIcon Img = new ImageIcon("bill.png");

		// se dibuja la imagen que tenemos en el paquete Images //dentro de un
		// panel

		grafico.drawImage(Img.getImage(), 0, 0, height.width, height.height,
				null);

		setOpaque(false);
		super.paintComponent(grafico);
	}
}
