package Vista;

import javax.swing.JOptionPane;
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

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import Controlador.Inventario;
import Modelo.Articulo;

public class AltaProducto extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JTextField txtNombreProducto;
	private JTextField txtPrecioProducto;
	private JButton btnBuscarProducto;
	private JLabel lblPrecioDelProducto;
	private JLabel lblDescripcin;
	private JLabel lblCodigoProducto;
	private JTextField txtCodigoProducto;
	private Inventario inv;
	private JTextArea textAreaDescripcion;
	private JScrollPane scrollPane;
	private BuscarProducto findart;

	/**
	 * Create the panel.
	 */
	public AltaProducto() {
		inv = new Inventario();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 470, 0 };
		gridBagLayout.rowHeights = new int[] { 400, 0 };
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
		gbl_panel_1.columnWidths = new int[] { 74, 120, 0, 72 };
		gbl_panel_1.rowHeights = new int[] { 67, 0, 52, 43, 60, 43, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 1.0 };
		panel_1.setLayout(gbl_panel_1);

		lblNewLabel = new JLabel("Alta de productos");
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 21));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		lblCodigoProducto = new JLabel("Codigo");
		lblCodigoProducto.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblCodigoProducto = new GridBagConstraints();
		gbc_lblCodigoProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoProducto.gridx = 1;
		gbc_lblCodigoProducto.gridy = 1;
		panel_1.add(lblCodigoProducto, gbc_lblCodigoProducto);

		txtCodigoProducto = new JTextField();
		txtCodigoProducto.setColumns(10);
		GridBagConstraints gbc_txtCodigoProducto = new GridBagConstraints();
		gbc_txtCodigoProducto.insets = new Insets(0, 0, 5, 5);
		gbc_txtCodigoProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCodigoProducto.gridx = 2;
		gbc_txtCodigoProducto.gridy = 1;
		panel_1.add(txtCodigoProducto, gbc_txtCodigoProducto);

		lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtNombreProducto = new JTextField();
		GridBagConstraints gbc_txtNombreProducto = new GridBagConstraints();
		gbc_txtNombreProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombreProducto.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreProducto.gridx = 2;
		gbc_txtNombreProducto.gridy = 2;
		panel_1.add(txtNombreProducto, gbc_txtNombreProducto);
		txtNombreProducto.setColumns(10);

		lblPrecioDelProducto = new JLabel("Precio");
		lblPrecioDelProducto.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblPrecioDelProducto = new GridBagConstraints();
		gbc_lblPrecioDelProducto.anchor = GridBagConstraints.NORTH;
		gbc_lblPrecioDelProducto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecioDelProducto.gridx = 1;
		gbc_lblPrecioDelProducto.gridy = 3;
		panel_1.add(lblPrecioDelProducto, gbc_lblPrecioDelProducto);

		txtPrecioProducto = new JTextField();
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

		btnBuscarProducto = new JButton("Dar alta producto");
		btnBuscarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comprobarCeldasVacias()) {
					try {
						Articulo art = new Articulo(txtCodigoProducto.getText(), txtNombreProducto.getText(),
								textAreaDescripcion.getText(), Double.parseDouble(txtPrecioProducto.getText()));

						if (inv.guardarArticulo(art)) {
							JOptionPane.showMessageDialog(null, "Articulo dado de alta correctamente.", "Correcto",
									JOptionPane.INFORMATION_MESSAGE);
							txtCodigoProducto.setText("");
							txtNombreProducto.setText("");
							txtPrecioProducto.setText("");
							textAreaDescripcion.setText("");
						} else
							JOptionPane.showMessageDialog(null, "Articulo ya existente", "Incorrecto",
									JOptionPane.ERROR_MESSAGE);
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null, "El precio indicado no es correcto.", "Incorrecto",
								JOptionPane.ERROR_MESSAGE);
						txtPrecioProducto.setText("");
					}
				}
			}

		});

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 4;
		panel_1.add(scrollPane, gbc_scrollPane);

		textAreaDescripcion = new JTextArea();
		scrollPane.setViewportView(textAreaDescripcion);
		textAreaDescripcion.setLineWrap(true);
		btnBuscarProducto.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_btnBuscarProducto = new GridBagConstraints();
		gbc_btnBuscarProducto.anchor = GridBagConstraints.NORTH;
		gbc_btnBuscarProducto.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBuscarProducto.gridx = 2;
		gbc_btnBuscarProducto.gridy = 5;
		panel_1.add(btnBuscarProducto, gbc_btnBuscarProducto);

	}

	public boolean comprobarCeldasVacias() {
		txtCodigoProducto.setText(txtCodigoProducto.getText().trim());
		txtNombreProducto.setText(txtNombreProducto.getText().trim());
		textAreaDescripcion.setText(textAreaDescripcion.getText().trim());
		if (txtCodigoProducto.getText().isEmpty() || txtNombreProducto.getText().isEmpty()
				|| textAreaDescripcion.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Campo de texto vacío.", "Incorrecto", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;

	}
}
