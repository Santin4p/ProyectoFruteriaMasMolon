package Vista;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JButton;

import java.awt.Font;

import javax.swing.JComboBox;

import Controlador.ListarClientes;
import Modelo.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class JPBuscarCliente extends JPanel{
	ListarClientes listica;
	protected JComboBox comboBox;
	protected String nombre;
	protected JLabel lblNombre;
	protected JLabel lblApellidos;
	protected JLabel lblDni;
	protected JLabel lblColorDePelo;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtColorPelo;
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public JPBuscarCliente() throws ClassNotFoundException, IOException {
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{35, 55, 97, 97, 107, 39, 0};
		gridBagLayout.rowHeights = new int[]{35, 11, 52, 52, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (int i = 0; i < listica.getListaCliente().size(); i++) {
					try {
						if (comboBox.getSelectedItem().equals(listica.getListaCliente().get(i).getNombre())) {
							txtNombre.setText(listica.getListaCliente().get(i).getNombre());
							txtApellidos.setText(listica.getListaCliente().get(i).getApellidos());
							txtDNI.setText(listica.getListaCliente().get(i).getDNI());
							txtColorPelo.setText(listica.getListaCliente().get(i).getColorDePelo());
						}
					} catch (NullPointerException e) {
						// TODO: handle exception
					}
				}
			}
		});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.SOUTH;
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		add(comboBox, gbc_comboBox);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("MV Boli", Font.BOLD, 13));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.WEST;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 2;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("MV Boli", Font.BOLD, 13));
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 3;
		gbc_lblApellidos.gridy = 2;
		add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setEditable(false);
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.anchor = GridBagConstraints.WEST;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.gridx = 4;
		gbc_txtApellidos.gridy = 2;
		add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDni.insets = new Insets(0, 0, 0, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 3;
		add(lblDni, gbc_lblDni);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		GridBagConstraints gbc_txtDNI = new GridBagConstraints();
		gbc_txtDNI.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtDNI.insets = new Insets(0, 0, 0, 5);
		gbc_txtDNI.gridx = 2;
		gbc_txtDNI.gridy = 3;
		add(txtDNI, gbc_txtDNI);
		txtDNI.setColumns(10);
		
		lblColorDePelo = new JLabel("Color de pelo:");
		lblColorDePelo.setFont(new Font("MV Boli", Font.BOLD, 13));
		GridBagConstraints gbc_lblColorDePelo = new GridBagConstraints();
		gbc_lblColorDePelo.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblColorDePelo.insets = new Insets(0, 0, 0, 5);
		gbc_lblColorDePelo.gridx = 3;
		gbc_lblColorDePelo.gridy = 3;
		add(lblColorDePelo, gbc_lblColorDePelo);
		
		txtColorPelo = new JTextField();
		txtColorPelo.setEditable(false);
		GridBagConstraints gbc_txtColorPelo = new GridBagConstraints();
		gbc_txtColorPelo.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtColorPelo.insets = new Insets(0, 0, 0, 5);
		gbc_txtColorPelo.gridx = 4;
		gbc_txtColorPelo.gridy = 3;
		add(txtColorPelo, gbc_txtColorPelo);
		txtColorPelo.setColumns(10);
		
	}
	public void cargarComboBox() throws ClassNotFoundException, IOException{
		listica=new ListarClientes();
		for (int i = 0; i < listica.getListaCliente().size(); i++) {
			comboBox.addItem(listica.getListaCliente().get(i).getNombre());
		}
	}
	public void actualizarComboBOX() throws ClassNotFoundException, IOException {
		cargarComboBox();
		comboBox.removeAllItems();
		cargarComboBox();
		
	}
}
