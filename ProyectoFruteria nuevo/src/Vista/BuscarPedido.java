package Vista;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JComboBox;

import java.awt.GridBagConstraints;

import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import Modelo.CrearPedido;
import Modelo.Pedido;

import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.font.NumericShaper;
import java.io.IOException;

public class BuscarPedido extends JPanel {
	DefaultTableModel modelo;
	private JTable table;
	private JComboBox combo;
	private final JTextField txtnumeroPedido = new JTextField();
	String[] nombreColumnas = { "Articulo" };
	Object[][] datos = {};
	private final JTextField txtNombreCliente = new JTextField();
	private final JTextField textField = new JTextField();

	/**
	 * Create the panel.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public BuscarPedido() throws ClassNotFoundException, IOException {
		CrearPedido pedido= new CrearPedido();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 30, 0, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30 };
		gridBagLayout.rowHeights = new int[] { 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel labelPedido = new JLabel("Buscar Pedido");
		labelPedido.setFont(new Font("MV Boli", Font.PLAIN, 12));
		GridBagConstraints gbc_labelPedido = new GridBagConstraints();
		gbc_labelPedido.insets = new Insets(0, 0, 5, 5);
		gbc_labelPedido.gridwidth = 3;
		gbc_labelPedido.gridx = 1;
		gbc_labelPedido.gridy = 1;
		add(labelPedido, gbc_labelPedido);
		GridBagConstraints gbc_txtnumeroPedido = new GridBagConstraints();
		gbc_txtnumeroPedido.fill = GridBagConstraints.BOTH;
		gbc_txtnumeroPedido.gridwidth = 2;
		gbc_txtnumeroPedido.insets = new Insets(0, 0, 5, 5);
		gbc_txtnumeroPedido.gridx = 4;
		gbc_txtnumeroPedido.gridy = 1;
	
		txtnumeroPedido.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("MV Boli", Font.PLAIN, 12));
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 10;
		gbc_lblFecha.gridy = 1;
		add(lblFecha, gbc_lblFecha);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 11;
		gbc_textField.gridy = 1;
		textField.setEditable(false);
		textField.setFont(new Font("MV Boli", Font.PLAIN, 12));
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNombreCliente = new JLabel("Nombre Cliente");
		lblNombreCliente.setFont(new Font("MV Boli", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNombreCliente = new GridBagConstraints();
		gbc_lblNombreCliente.gridwidth = 3;
		gbc_lblNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreCliente.anchor = GridBagConstraints.EAST;
		gbc_lblNombreCliente.gridx = 1;
		gbc_lblNombreCliente.gridy = 3;
		add(lblNombreCliente, gbc_lblNombreCliente);
		GridBagConstraints gbc_txtNombreCliente = new GridBagConstraints();
		gbc_txtNombreCliente.fill = GridBagConstraints.BOTH;
		gbc_txtNombreCliente.gridwidth = 8;
		gbc_txtNombreCliente.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombreCliente.gridx = 4;
		gbc_txtNombreCliente.gridy = 3;
		txtNombreCliente.setEditable(false);
		txtNombreCliente.setFont(new Font("MV Boli", Font.PLAIN, 12));
		add(txtNombreCliente, gbc_txtNombreCliente);
		txtNombreCliente.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 14;
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(datos, nombreColumnas));
		scrollPane.setViewportView(table);
		// extraer la columna de la tabla
		// extraer e introducir datos een una rejilla
		modelo = (DefaultTableModel) table.getModel();
		TableColumn columna = table.getColumn(table.getColumnName(0));

		// como meter un combobox en una celda
		combo = new JComboBox();

		// crear un editor de celdas del tipo combobox
		JTextField propio = new JTextField();
		propio.setEditable(false);
		TableCellEditor tce3 = new DefaultCellEditor(propio);
		table.getColumn(table.getColumnName(0)).setCellEditor(tce3);
		columna.setCellEditor(tce3);
		columna.getCellEditor().addCellEditorListener(new CellEditorListener() {
			@Override
			public void editingStopped(ChangeEvent e) {
				
			}

			@Override
			public void editingCanceled(ChangeEvent e) {
				// TODO Auto-generated method stub
			}
		});

		columna.getCellEditor().addCellEditorListener(new CellEditorListener() {
			@Override
			public void editingStopped(ChangeEvent e) {
				
			}

			@Override
			public void editingCanceled(ChangeEvent e) {
				// TODO Auto-generated method stub
			}
		});
		txtnumeroPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtnumeroPedido.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "No se a insetado ningun numero", "Error",
							JOptionPane.ERROR_MESSAGE);
					txtNombreCliente.setText("");
					textField.setText("");
				}
				else {
					boolean bandera = false;

					do {
						if (modelo.getRowCount() == 0) {
							bandera = true;
						} else {
							modelo.removeRow(0);
						}

					} while (bandera == false);
				
						try {
							pedido.listarPedido(table,txtnumeroPedido,txtNombreCliente,textField);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				}
				

					
			}
		});
		add(txtnumeroPedido, gbc_txtnumeroPedido);
	}

}
