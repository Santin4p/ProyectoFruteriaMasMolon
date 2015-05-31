package Vista;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import Controlador.ListarClientes;
import Modelo.Articulo;
import Modelo.Cliente;
import Modelo.CrearPedido;
import Modelo.Inventario;
import Modelo.LineasDePedido;
import Modelo.Pedido;

public class PanelFrutero extends JPanel {
	private JTable table;
	private JLabel lblNewLabel;
	private TextField txtFecha;
	private JLabel label;
	private TextField txtNumeroPedido;
	private JLabel lblCliente;
	private JComboBox comboCliente;
	private JButton btnAltaPedido;
	private JButton btnCrearpedido;
	private JButton btnNuevopedido;
	private Inventario inv;
	private JComboBox combo;
	private Articulo art;
	private CrearPedido listape = new CrearPedido();
	LineasDePedido lineas;
	DefaultTableModel modelo;
	int contadorColumnas = 0;

	Pedido pe = new Pedido();

	/**
	 * Create the panel.
	 * 
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public PanelFrutero() throws ClassNotFoundException, IOException {
		ListarClientes instancia = new ListarClientes();
		Cliente cli = new Cliente();

		inv = new Inventario();
		setBounds(100, 100, 521, 342);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 30 };
		gbl_contentPane.rowHeights = new int[] { 10, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		contentPane.setLayout(gbl_contentPane);
		String[] nombreColumnas = { "Articulo", "Precio", "Cantidad", "Total" };
		Object[][] datos = {};
		label = new JLabel("N\u00BA Pedido");
		label.setFont(new Font("MV Boli", Font.PLAIN, 12));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		contentPane.add(label, gbc_label);
		int numero = listape.getListaPedido().size() + 1;

		txtNumeroPedido = new TextField();
		txtNumeroPedido.setText(String.valueOf(numero));
		txtNumeroPedido.setEditable(false);
		GridBagConstraints gbc_txtNumeroPedido = new GridBagConstraints();
		gbc_txtNumeroPedido.gridwidth = 2;
		gbc_txtNumeroPedido.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumeroPedido.insets = new Insets(0, 0, 5, 5);
		gbc_txtNumeroPedido.gridx = 2;
		gbc_txtNumeroPedido.gridy = 1;
		contentPane.add(txtNumeroPedido, gbc_txtNumeroPedido);

		lblNewLabel = new JLabel("Fecha");
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		txtFecha = new TextField();
		txtFecha.setEditable(false);
		GridBagConstraints gbc_txtFecha = new GridBagConstraints();
		gbc_txtFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFecha.insets = new Insets(0, 0, 5, 5);
		gbc_txtFecha.gridx = 7;
		gbc_txtFecha.gridy = 1;
		contentPane.add(txtFecha, gbc_txtFecha);
		// Pone la fecha actual
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		txtFecha.setText(dateFormat.format(date));

		lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("MV Boli", Font.PLAIN, 12));
		GridBagConstraints gbc_lblCliente = new GridBagConstraints();
		gbc_lblCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblCliente.gridx = 1;
		gbc_lblCliente.gridy = 2;
		contentPane.add(lblCliente, gbc_lblCliente);

		comboCliente = new JComboBox();
		GridBagConstraints gbc_comboCliente = new GridBagConstraints();
		gbc_comboCliente.gridwidth = 6;
		gbc_comboCliente.insets = new Insets(0, 0, 5, 5);
		gbc_comboCliente.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboCliente.gridx = 2;
		gbc_comboCliente.gridy = 2;
		contentPane.add(comboCliente, gbc_comboCliente);
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 9;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		contentPane.add(scrollPane, gbc_scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(datos, nombreColumnas));
		scrollPane.setViewportView(table);
		// extraer la columna de la tabla

		TableColumn tc = table.getColumnModel().getColumn(0);
		// extraer e introducir datos een una rejilla
		modelo = (DefaultTableModel) table.getModel();

		btnAltaPedido = new JButton("Crear Linea");
		btnAltaPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] datos = { null, null, null };
				((DefaultTableModel) table.getModel()).addRow(datos);
				btnCrearpedido.setEnabled(true);

				modelo.setValueAt(0, contadorColumnas, 3);
				modelo.setValueAt(0, contadorColumnas, 2);
				modelo.setValueAt("Sin precio", contadorColumnas, 1);
				modelo.setValueAt("Sin articulo", contadorColumnas, 0);

				contadorColumnas++;

				System.out.println(contadorColumnas);
				// for (int i = 0; i < modelo.getRowCount(); i++) {
				// if (modelo.getValueAt(i, 2).equals(0) || modelo.getValueAt(i,
				// 3).equals(0)) {
				// modelo.setValueAt(0, i, 3);
				// modelo.setValueAt(0, i, 2);
				// }

				// }

			}
		});
		btnAltaPedido.setFont(new Font("MV Boli", Font.PLAIN, 12));
		GridBagConstraints gbc_btnAltaPedido = new GridBagConstraints();
		gbc_btnAltaPedido.insets = new Insets(0, 0, 5, 5);
		gbc_btnAltaPedido.gridx = 1;
		gbc_btnAltaPedido.gridy = 7;
		contentPane.add(btnAltaPedido, gbc_btnAltaPedido);

		btnCrearpedido = new JButton("FinalizarPedido");
		btnCrearpedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					listape = new CrearPedido();
					// mostrarLineasJose();
					// guardarLineasDePedido();
					darAltaPedido();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnCrearpedido.setFont(new Font("MV Boli", Font.PLAIN, 12));
		GridBagConstraints gbc_btnCrearpedido = new GridBagConstraints();
		gbc_btnCrearpedido.gridwidth = 2;
		gbc_btnCrearpedido.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrearpedido.gridx = 3;
		gbc_btnCrearpedido.gridy = 7;
		contentPane.add(btnCrearpedido, gbc_btnCrearpedido);
		btnCrearpedido.setEnabled(false);

		btnNuevopedido = new JButton("NuevoPedido");
		btnNuevopedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCrearpedido.setEnabled(true);
				contadorColumnas = 0;
				boolean bandera = false;

				do {

					if (modelo.getRowCount() == 0) {
						System.out.println("TODO BORRADO");
						bandera = true;
					} else {
						modelo.removeRow(0);
					}

				} while (bandera == false);
				int numero = listape.getListaPedido().size() + 1;

				txtNumeroPedido.setText(String.valueOf(numero));

				// lineas.guardarLineasDePedido(modelo);

			}
		});

		btnNuevopedido.setFont(new Font("MV Boli", Font.PLAIN, 12));
		GridBagConstraints gbc_btnNuevopedido = new GridBagConstraints();
		gbc_btnNuevopedido.insets = new Insets(0, 0, 5, 5);
		gbc_btnNuevopedido.gridx = 7;
		gbc_btnNuevopedido.gridy = 7;
		contentPane.add(btnNuevopedido, gbc_btnNuevopedido);
		// como meter un combobox en una celda
		combo = new JComboBox();

		// crear un editor de celdas del tipo combobox
		TableCellEditor tce = new DefaultCellEditor(combo);
		// asociar la columna al nuevo editor de combobox
		tc.setCellEditor(tce);
		TableColumn columna = table.getColumn(table.getColumnName(2));
		TableCellEditor tce2 = new DefaultCellEditor(new JTextField());
		JTextField propio = new JTextField();
		propio.setEditable(false);
		TableCellEditor tce3 = new DefaultCellEditor(propio);
		table.getColumn(table.getColumnName(1)).setCellEditor(tce3);
		columna.setCellEditor(tce2);
		columna.getCellEditor().addCellEditorListener(new CellEditorListener() {
			@Override
			public void editingStopped(ChangeEvent e) {
				try {
					modelo.setValueAt(
							Double.parseDouble((String) table.getValueAt(table.getSelectedRow(), 2))
									* art.calcularPVP(), table.getSelectedRow(), 3);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					System.out.println("Sin valor");
				}
			}

			@Override
			public void editingCanceled(ChangeEvent e) {
				// TODO Auto-generated method stub
			}
		});

		// Se llena con la lista de cliente dados de alta

		JTextField propioDos = new JTextField();
		propioDos.setEditable(false);
		TableCellEditor tce5 = new DefaultCellEditor(propioDos);
		table.getColumn(table.getColumnName(3)).setCellEditor(tce5);

		combo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				art = new Articulo();
				try {
					art = inv.buscarArticulo((String) combo.getSelectedItem());
					if (table.getSelectedRow() != -1)
						modelo.setValueAt(art.calcularPVP(), table.getSelectedRow(), 1);

				} catch (NullPointerException e) {
				}

			}
		});
		cargarCombo();

		// Carga lista de clientes
		instancia.listarCli(comboCliente);

	}

	public void cargarCombo() {
		for (int j = 0; j < inv.getListaArticulos().size(); j++) {
			combo.addItem(inv.getListaArticulos().get(j).getCodigo());
		}
	}

	private void mostrarLineasJose() {
		System.out.println("tipo " + modelo.getColumnClass(0).getName());
		for (int i = 0; i < modelo.getRowCount(); i++) {
			System.out.println("titulo " + modelo.getValueAt(i, 0));
			System.out.println("por articulo " + inv.buscarArticulo(modelo.getValueAt(i, 0).toString()));
			System.out.println("Cantidad " + modelo.getValueAt(i, 2));

		}

	}

	private void darAltaPedido() throws NumberFormatException, FileNotFoundException, IOException {
		boolean bandera = true;
		for (int i = 0; i < modelo.getRowCount(); i++) {
			if (comboCliente.getSelectedItem().equals("") || modelo.getRowCount() <= 0
					|| modelo.getValueAt(i, 3).equals(0) || modelo.getValueAt(i, 2).equals(0.0)
					|| modelo.getValueAt(i, 2).equals("") || modelo.getValueAt(i, 3).equals(0.0)
					|| modelo.getValueAt(i, 0).equals("Sin articulo") || modelo.getValueAt(i, 1).equals("Sin precio")) {
				System.out.println("No debe dejar ningun campo en blanco");
				bandera = false;
			}
		}
		if (modelo.getRowCount() == 0) {
			bandera = false;
		}
		if (bandera == true) {
			for (int j = 0; j < modelo.getRowCount(); j++) {
				pe.getArt().add(inv.buscarArticulo(modelo.getValueAt(j, 0).toString()));
			}
			String fecha = txtFecha.getText().toString();
			listape.crearNuevoPedido(fecha, Integer.parseInt(txtNumeroPedido.getText()), comboCliente.getSelectedItem()
					.toString(), pe.getArt());
			System.out.println("PEDIO CREADO");
			btnCrearpedido.setEnabled(false);
		}
	}

	private void guardarLineasDePedido() {
		for (int i = 0; i < modelo.getRowCount(); i++) {
			System.out.println("valor antes " + modelo.getValueAt(i, 2));
			int cantidad = Integer.valueOf(modelo.getValueAt(i, 2).toString());
			System.out.println("por articulo " + inv.buscarArticulo(modelo.getValueAt(i, 0).toString()).getNombre());
			lineas.getLinea().add(new LineasDePedido(String.valueOf(modelo.getValueAt(i, 0)), cantidad));

		}
	}
}
