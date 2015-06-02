package Vista;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.SwingConstants;

import java.awt.Insets;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import Modelo.Articulo;
import Modelo.Inventario;

import java.awt.Cursor;

public class BuscarArticulo extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JTextField txtNombreProducto;
	private JTextField txtPrecioProducto;
	private JButton btnBuscarProducto;
	private JLabel lblPrecioDelProducto;
	private JLabel lblDescripcin;
	private JLabel lblPvp;
	private JLabel lblPVP;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JComboBox<String> comboBox;
	private Inventario inv;
	private Articulo art;
	private JScrollPane scrollPane;
	private JTextArea textAreaDescripcion;

	/**
	 * Create the panel.
	 */
	public BuscarArticulo() {
		inv = new Inventario();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 501, 0 };
		gridBagLayout.rowHeights = new int[] { 372, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("MV Boli", Font.PLAIN, 21));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 25, 60, 0, 91, 0 };
		gbl_panel_1.rowHeights = new int[] { 49, 0, 30, 33, 50, 35, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0 };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0 };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel = new JLabel("Busqueda de productos");
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 21));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblCodigo = new GridBagConstraints();
		gbc_lblCodigo.anchor = GridBagConstraints.EAST;
		gbc_lblCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigo.gridx = 1;
		gbc_lblCodigo.gridy = 1;
		panel_1.add(lblCodigo, gbc_lblCodigo);

		txtCodigo = new JTextField();
		GridBagConstraints gbc_txtCodigo = new GridBagConstraints();
		gbc_txtCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigo.gridx = 2;
		gbc_txtCodigo.gridy = 1;
		panel_1.add(txtCodigo, gbc_txtCodigo);
		txtCodigo.setColumns(10);

		comboBox = new JComboBox<String>();
		comboBox.setMaximumSize(new Dimension(1555, 1555));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 if (comboBox.getSelectedIndex() == 0) {
				 art = inv.buscarArticulo(txtCodigo.getText());
				 txtCodigo.setEnabled(true);
				 btnBuscarProducto.setEnabled(true);
				 textAreaDescripcion.setText("");
				 txtNombreProducto.setText("");
				 txtPrecioProducto.setText("");
				 lblPVP.setText("");
				 } else {
				try {
					art = inv.buscarArticulo(comboBox.getSelectedItem().toString());
					txtCodigo.setText("");
					txtCodigo.setEnabled(false);
					btnBuscarProducto.setEnabled(false);
					textAreaDescripcion.setText(art.getDescripcion());
					txtNombreProducto.setText(art.getNombre());
					txtPrecioProducto.setText(String.valueOf(art.getPrecio()));
					lblPVP.setText(String.valueOf(art.calcularPVP()));
					textAreaDescripcion.setCaretPosition(0);
				} catch (NullPointerException e) {
					// TODO: handle exception
				}

			}

			}});
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 3;
		gbc_comboBox.gridy = 1;
		panel_1.add(comboBox, gbc_comboBox);

		lblNewLabel_2 = new JLabel("Nombre del producto");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtNombreProducto = new JTextField();
		txtNombreProducto.setEditable(false);
		GridBagConstraints gbc_txtNombreProducto = new GridBagConstraints();
		gbc_txtNombreProducto.anchor = GridBagConstraints.NORTH;
		gbc_txtNombreProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreProducto.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreProducto.gridx = 2;
		gbc_txtNombreProducto.gridy = 2;
		panel_1.add(txtNombreProducto, gbc_txtNombreProducto);
		txtNombreProducto.setColumns(10);

		lblPrecioDelProducto = new JLabel("Precio del producto");
		lblPrecioDelProducto.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblPrecioDelProducto = new GridBagConstraints();
		gbc_lblPrecioDelProducto.anchor = GridBagConstraints.NORTH;
		gbc_lblPrecioDelProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioDelProducto.gridx = 1;
		gbc_lblPrecioDelProducto.gridy = 3;
		panel_1.add(lblPrecioDelProducto, gbc_lblPrecioDelProducto);

		txtPrecioProducto = new JTextField();
		txtPrecioProducto.setEditable(false);
		GridBagConstraints gbc_txtPrecioProducto = new GridBagConstraints();
		gbc_txtPrecioProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPrecioProducto.anchor = GridBagConstraints.NORTH;
		gbc_txtPrecioProducto.insets = new Insets(0, 0, 5, 5);
		gbc_txtPrecioProducto.gridx = 2;
		gbc_txtPrecioProducto.gridy = 3;
		panel_1.add(txtPrecioProducto, gbc_txtPrecioProducto);
		txtPrecioProducto.setColumns(10);

		lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblDescripcin = new GridBagConstraints();
		gbc_lblDescripcin.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblDescripcin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescripcin.gridx = 1;
		gbc_lblDescripcin.gridy = 4;
		panel_1.add(lblDescripcin, gbc_lblDescripcin);

		scrollPane = new JScrollPane();
		scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 4;
		panel_1.add(scrollPane, gbc_scrollPane);

		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setEditable(false);
		scrollPane.setViewportView(textAreaDescripcion);

		lblPvp = new JLabel("PVP");
		lblPvp.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblPvp = new GridBagConstraints();
		gbc_lblPvp.anchor = GridBagConstraints.EAST;
		gbc_lblPvp.insets = new Insets(0, 0, 5, 5);
		gbc_lblPvp.gridx = 1;
		gbc_lblPvp.gridy = 5;
		panel_1.add(lblPvp, gbc_lblPvp);

		lblPVP = new JLabel("");
		GridBagConstraints gbc_lblPVP = new GridBagConstraints();
		gbc_lblPVP.insets = new Insets(0, 0, 5, 5);
		gbc_lblPVP.gridx = 2;
		gbc_lblPVP.gridy = 5;
		panel_1.add(lblPVP, gbc_lblPVP);

		btnBuscarProducto = new JButton("Buscar producto");
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				art = new Articulo();
				try {
					inv = new Inventario();
					art = inv.buscarArticulo(txtCodigo.getText());
					textAreaDescripcion.setText(art.getDescripcion());
					txtNombreProducto.setText(art.getNombre());
					txtPrecioProducto.setText(String.valueOf(art.getPrecio()));
					lblPVP.setText(String.valueOf(art.calcularPVP()));
					textAreaDescripcion.setCaretPosition(0);
				} catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "El articulo no ha sido encontrado", "Lo siento",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		btnBuscarProducto.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_btnBuscarProducto = new GridBagConstraints();
		gbc_btnBuscarProducto.anchor = GridBagConstraints.NORTH;
		gbc_btnBuscarProducto.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscarProducto.gridx = 2;
		gbc_btnBuscarProducto.gridy = 6;
		panel_1.add(btnBuscarProducto, gbc_btnBuscarProducto);
	}

	public void cargarComboBOX() {
		inv = new Inventario();
		for (int i = 0; i < inv.getListaArticulos().size(); i++) {
			comboBox.addItem(inv.getListaArticulos().get(i).getCodigo());
		}
	}

	public void actualizarComboBOX() {
		cargarComboBOX();
		comboBox.removeAllItems();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "Seleccione un c\u00F3digo" }));
		cargarComboBOX();
		

	}
}
