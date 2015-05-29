package Vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.BoxLayout;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.io.IOException;

public class FrameGlobal extends JFrame {

	private JPanel contentPanel;
	private JPDarDeAlta ventanaAlta;
	private JPBuscarCliente ventanaBuscar;
	private JPModificarCliente ventanaModificar;
	private AltaProducto ventanaAltaProducto;
	private BuscarArticulo ventanaBuscarArticulo;
	CardLayout carta;
	private JPanel panel;
	private JMenu mnGestor;
	private JMenu mnTendero;
	private JMenu mnFrutero;
	private JMenuItem mntmCrearPedido;
	private JMenuItem mntmNuevaLineaPedido;
	private JMenuItem mntmDarDeAltaArticulo;
	private JMenuItem mntmBuscarArticulo;
	private JMenuItem mntmDarDeAlta;
	private JMenuItem mntmModificar;
	private JMenuItem mntmBuscarCliente;
	private JPanel contenedorImagen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameGlobal ventanica = new FrameGlobal();
					ventanica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public FrameGlobal() throws ClassNotFoundException, IOException {
		setResizable(false);
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		
		carta=new CardLayout(0, 0);
		contentPanel.setLayout(carta);
		contenedorImagen=new JPanel();
		contenedorImagen.setLayout(carta);
		
		Imagen nueva=new Imagen();
		nueva.setBounds(0, 0, 594, 400);
		contenedorImagen.add(nueva);
		nueva.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPanel.add(contenedorImagen,"name_1212");
		
		ventanaAlta = new JPDarDeAlta();
		contentPanel.add(ventanaAlta, "ventana1");
		
		ventanaBuscar=new JPBuscarCliente();
		contentPanel.add(ventanaBuscar, "ventana2");
		
		ventanaModificar=new JPModificarCliente();
		contentPanel.add(ventanaModificar,"ventana3");
		
		ventanaAltaProducto=new AltaProducto();
		contentPanel.add(ventanaAltaProducto,"ventana4");
		
		ventanaBuscarArticulo=new BuscarArticulo();
		contentPanel.add(ventanaBuscarArticulo,"ventana5");
		
		//Tamaño
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 390);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnGestor = new JMenu("Gestor");
		menuBar.add(mnGestor);
		
		mntmDarDeAlta = new JMenuItem("Dar de alta cliente");
		mntmDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carta.show(contentPanel,"ventana1");
				setResizable(true);
			}
		});
		
		mnGestor.add(mntmDarDeAlta);
		
		mntmModificar = new JMenuItem("Modificar cliente");
		mntmModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carta.show(contentPanel,"ventana3");
				setResizable(true);
			}
		});
		mnGestor.add(mntmModificar);
		
		mntmBuscarCliente = new JMenuItem("Buscar cliente");
		mntmBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carta.show(contentPanel,"ventana2");
				setResizable(true);
			}
		});
		mnGestor.add(mntmBuscarCliente);
		
		mnTendero = new JMenu("Tendero");
		menuBar.add(mnTendero);
		
		mntmDarDeAltaArticulo = new JMenuItem("Dar de alta articulo");
		mntmDarDeAltaArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carta.show(contentPanel,"ventana4");
				setResizable(true);
			}
		});
		mnTendero.add(mntmDarDeAltaArticulo);
		
		mntmBuscarArticulo = new JMenuItem("Buscar articulo");
		mnTendero.add(mntmBuscarArticulo);
		mntmBuscarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carta.show(contentPanel,"ventana5");
				setResizable(true);
				ventanaBuscarArticulo.cargarComboBOX();
			
			}
		});
		
		
		mnFrutero = new JMenu("Frutero");
		menuBar.add(mnFrutero);
		
		mntmCrearPedido = new JMenuItem("Crear pedido");
		mnFrutero.add(mntmCrearPedido);
		
		mntmNuevaLineaPedido = new JMenuItem("Nueva linea pedido");
		mnFrutero.add(mntmNuevaLineaPedido);
	}
}
