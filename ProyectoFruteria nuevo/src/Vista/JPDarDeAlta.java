package Vista;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.JButton;

import Controlador.ListarClientes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class JPDarDeAlta extends JPanel {
	protected JTextField txtNombre;
	protected JTextField txtApellidos;
	protected JTextField txtDNI;
	protected JTextField txtColorPelo;
	protected JLabel lblApellidos;
	protected JLabel lblDni;
	protected JLabel lblColorDePelo;
	protected JButton btnDarDeAlta;
	protected ListarClientes listica;
	
	/**
	 * Create the panel.
	 */
	
	public JPDarDeAlta() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 70, 81, 92, 72, 41, 0};
		gridBagLayout.rowHeights = new int[]{110, 0, 25, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNombre1 = new JLabel("Nombre:");
		lblNombre1.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblNombre1 = new GridBagConstraints();
		gbc_lblNombre1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre1.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNombre1.gridx = 1;
		gbc_lblNombre1.gridy = 0;
		add(lblNombre1, gbc_lblNombre1);
		
		txtNombre = new JTextField();
	
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.anchor = GridBagConstraints.SOUTH;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 0;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 3;
		gbc_lblApellidos.gridy = 0;
		add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.anchor = GridBagConstraints.SOUTH;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 4;
		gbc_txtApellidos.gridy = 0;
		add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 1;
		add(lblDni, gbc_lblDni);
		
		txtDNI = new JTextField();
		GridBagConstraints gbc_txtDNI = new GridBagConstraints();
		gbc_txtDNI.insets = new Insets(0, 0, 5, 5);
		gbc_txtDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDNI.gridx = 2;
		gbc_txtDNI.gridy = 1;
		add(txtDNI, gbc_txtDNI);
		txtDNI.setColumns(10);
		
		lblColorDePelo = new JLabel("Color de pelo:");
		lblColorDePelo.setFont(new Font("MV Boli", Font.BOLD, 12));
		GridBagConstraints gbc_lblColorDePelo = new GridBagConstraints();
		gbc_lblColorDePelo.anchor = GridBagConstraints.EAST;
		gbc_lblColorDePelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblColorDePelo.gridx = 3;
		gbc_lblColorDePelo.gridy = 1;
		add(lblColorDePelo, gbc_lblColorDePelo);
		
		txtColorPelo = new JTextField();
		GridBagConstraints gbc_txtColorPelo = new GridBagConstraints();
		gbc_txtColorPelo.insets = new Insets(0, 0, 5, 5);
		gbc_txtColorPelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtColorPelo.gridx = 4;
		gbc_txtColorPelo.gridy = 1;
		add(txtColorPelo, gbc_txtColorPelo);
		txtColorPelo.setColumns(10);
		
		btnDarDeAlta=new JButton("Dar de alta");
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					listica=new ListarClientes();
					darDeAlta();
					dejarBlanco();
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
				}
			}
			private void darDeAlta() throws ClassNotFoundException, IOException{
				if (comprobarCampos()==false) {
					if (listica.buscarCliente(txtNombre.getText(),txtApellidos.getText(), txtDNI.getText(), txtColorPelo.getText())==false) {
						listica.crearNuevoElemento(txtNombre.getText(),txtApellidos.getText(),txtDNI.getText(), txtColorPelo.getText());
						JOptionPane.showMessageDialog(null, "El cliente ha sido introducido correctamente","Exito",JOptionPane.INFORMATION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "Cliente repetido","Error",JOptionPane.ERROR_MESSAGE);
					}
				}else{
						JOptionPane.showMessageDialog(null, "No puedes dejar un campo en blanco","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		GridBagConstraints gbc_btnDarDeAlta = new GridBagConstraints();
		gbc_btnDarDeAlta.gridwidth = 2;
		gbc_btnDarDeAlta.anchor = GridBagConstraints.SOUTHEAST;
		gbc_btnDarDeAlta.insets = new Insets(0, 0, 5, 5);
		gbc_btnDarDeAlta.gridx = 3;
		gbc_btnDarDeAlta.gridy = 2;
		add(btnDarDeAlta, gbc_btnDarDeAlta);
	
	}
	
	public void dejarBlanco(){
		txtApellidos.setText("");
		txtNombre.setText("");
		txtDNI.setText("");
		txtColorPelo.setText("");
	}
	
	public boolean comprobarCampos(){
		if (txtApellidos.getText().equals("") || txtNombre.getText().equals("") || txtDNI.getText().equals("") || txtColorPelo.getText().equals("")) {
			return true;
		}else{
			return false;
		}
	}
	
	public JTextField getTxtApellidos() {
		return txtNombre;
	}

	public void setTxtApellidos(JTextField txtApellidos) {
		this.txtNombre = txtApellidos;
	}

	public JTextField getTextField() {
		return txtApellidos;
	}

	public void setTextField(JTextField textField) {
		this.txtApellidos = textField;
	}

	public JTextField getTextField_1() {
		return txtDNI;
	}

	public void setTextField_1(JTextField textField_1) {
		this.txtDNI = textField_1;
	}

	public JTextField getTextField_2() {
		return txtColorPelo;
	}

	public void setTextField_2(JTextField textField_2) {
		this.txtColorPelo = textField_2;
	}

	public JLabel getLblNombre() {
		return lblApellidos;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblApellidos = lblNombre;
	}

	public JLabel getLblDni() {
		return lblDni;
	}

	public void setLblDni(JLabel lblDni) {
		this.lblDni = lblDni;
	}

	public JLabel getLblColorDePelo() {
		return lblColorDePelo;
	}

	public void setLblColorDePelo(JLabel lblColorDePelo) {
		this.lblColorDePelo = lblColorDePelo;
	}


}
