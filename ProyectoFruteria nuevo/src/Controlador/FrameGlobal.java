package Controlador;

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







import Test.VentanaPruebas;
import Vista.AltaProducto;
import Vista.BuscarArticulo;
import Vista.BuscarPedido;
import Vista.Imagen;
import Vista.JPBuscarCliente;
import Vista.JPDarDeAlta;
import Vista.JPModificarCliente;
import Vista.PanelFruteroFinalDosPanel;

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
	private PanelFruteroFinalDosPanel ventanaFrutero;
	private BuscarArticulo ventanaBuscarArticulo;
	private BuscarPedido ventanaBuscarPedido;
	CardLayout carta;
	private JPanel panel;
	private JMenu mnGestor;
	private JMenu mnTendero;
	private JMenu mnFrutero;
	private JMenuItem mntmCrearPedido;
	private JMenuItem mntmDarDeAltaArticulo;
	private JMenuItem mntmBuscarArticulo;
	private JMenuItem mntmDarDeAlta;
	private JMenuItem mntmModificar;
	private JMenuItem mntmBuscarCliente;
	private JPanel contenedorImagen;
	private JMenuItem mntmBuscarPedido;
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
		
		ventanaFrutero=new PanelFruteroFinalDosPanel();
		contentPanel.add(ventanaFrutero,"ventana6");
		
		ventanaBuscarPedido=new BuscarPedido();
		contentPanel.add(ventanaBuscarPedido,"ventana7");
		
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
				try {
					ventanaModificar.actualizarComboBOX();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				carta.show(contentPanel,"ventana3");
				setResizable(true);
			}
		});
		mnGestor.add(mntmModificar);
		
		mntmBuscarCliente = new JMenuItem("Buscar cliente");
		mntmBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ventanaBuscar.actualizarComboBOX();
				} catch (Exception e2) {
					// TODO: handle exception
				}
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
				
			}
		});
		mnTendero.add(mntmDarDeAltaArticulo);
		
		mntmBuscarArticulo = new JMenuItem("Buscar articulo");
		mnTendero.add(mntmBuscarArticulo);
		mntmBuscarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carta.show(contentPanel,"ventana5");
				setResizable(true);
				ventanaBuscarArticulo.actualizarComboBOX();
			}});
		
		
		mnFrutero = new JMenu("Frutero");
		menuBar.add(mnFrutero);
		
		mntmCrearPedido = new JMenuItem("Crear pedido");
		mntmCrearPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carta.show(contentPanel, "ventana6");
				setResizable(true);
				ventanaFrutero.actualizarComboBOXArticulos();
				try {
					ventanaFrutero.actualizarComboBOXClientes();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnFrutero.add(mntmCrearPedido);
		
		mntmBuscarPedido = new JMenuItem("Buscar pedido");
		mntmBuscarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carta.show(contentPanel, "ventana7");
				setResizable(true);
			}
		});
		mnFrutero.add(mntmBuscarPedido);
	}
}
