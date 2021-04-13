package main;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

import model.entities.Cliente;
import model.entities.Fabricante;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;

public class VentanaCliente extends JPanel {
	
Entidad actual = new Cliente();
	
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellidos;
	private JTextField jtfLocalidad;
	private JTextField jtfDniNieNie;
	private JFormattedTextField jtfFechaNac;
	private JComboBox<Cliente> jcbCliente;
	
	private SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");


	/**
	 * Create the panel.
	 */
	
	public VentanaCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0,0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
//		JLabel lblNewLabel_1 = new JLabel("Cliente:");
//		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
//		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
//		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
//		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
//		gbc_lblNewLabel_1.gridx = 0;
//		gbc_lblNewLabel_1.gridy = 1;
//		add(lblNewLabel_1, gbc_lblNewLabel_1);
//		
		jcbCliente = new JComboBox();
//		GridBagConstraints gbc_jcbCliente = new GridBagConstraints();
//		gbc_jcbCliente.insets = new Insets(0, 0, 5, 0);
//		gbc_jcbCliente.fill = GridBagConstraints.HORIZONTAL;
//		gbc_jcbCliente.gridx = 1;
//		gbc_jcbCliente.gridy = 1;
//		add(jcbCliente, gbc_jcbCliente);
		
		JLabel lblNewLabel_2 = new JLabel("Bastidor:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 2;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jtfApellidos = new JTextField();
		GridBagConstraints gbc_jtfApellidos = new GridBagConstraints();
		gbc_jtfApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_jtfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellidos.gridx = 1;
		gbc_jtfApellidos.gridy = 3;
		add(jtfApellidos, gbc_jtfApellidos);
		jtfApellidos.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Localidad:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jtfLocalidad = new JTextField();
		GridBagConstraints gbc_jtfLocalidad = new GridBagConstraints();
		gbc_jtfLocalidad.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLocalidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLocalidad.gridx = 1;
		gbc_jtfLocalidad.gridy = 4;
		add(jtfLocalidad, gbc_jtfLocalidad);
		jtfLocalidad.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("DniNieNie:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		jtfDniNieNie = new JTextField();
		GridBagConstraints gbc_jtfDniNieNie = new GridBagConstraints();
		gbc_jtfDniNieNie.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDniNieNie.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDniNieNie.gridx = 1;
		gbc_jtfDniNieNie.gridy = 5;
		add(jtfDniNieNie, gbc_jtfDniNieNie);
		jtfDniNieNie.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Fecha Nacimiento:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		jtfFechaNac = new JFormattedTextField();
		GridBagConstraints gbc_jtfFechaNac = new GridBagConstraints();
		gbc_jtfFechaNac.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaNac.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaNac.gridx = 1;
		gbc_jtfFechaNac.gridy = 6;
		add(jtfFechaNac, gbc_jtfFechaNac);
		jtfFechaNac.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ClienteControlador.getControlador().findFirst();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnPrimero);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ClienteControlador.getControlador().findPrevious(actual);
				cargarActualEnPantalla();
			}
		});
		panel.add(btnAnterior);
		
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ClienteControlador.getControlador().findNext(actual);
				cargarActualEnPantalla();
			}
		});
		panel.add(btnSiguiente);
		
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ClienteControlador.getControlador().findLast();
				cargarActualEnPantalla();
			}
		});
		panel.add(btnUltimo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);
		
		JButton btnNuevo = new JButton("Nuevo");
		panel.add(btnNuevo);
		
		JButton btnEliminar = new JButton("Eliminar");
		panel.add(btnEliminar);

		
		cargarDatosCliente();
		this.actual = ClienteControlador.getControlador().findFirst();
		cargarActualEnPantalla();

	}
	
	/**
	 * 
	 */
	private void cargarDatosCliente() {
		List<Entidad> clientes = ClienteControlador.getControlador().findAll();
		
		for (Entidad c : clientes) {
			this.jcbCliente.addItem((Cliente) c);
		}
	}
	
	/**
	 * 
	 */
	private void cargarActualEnPantalla() {
		if (this.actual != null) {
			this.jtfId.setText("" + this.actual.getId());
			this.jtfNombre.setText(((Cliente) this.actual).getNombre());
			this.jtfApellidos.setText(((Cliente) this.actual).getApellidos());
			this.jtfLocalidad.setText(((Cliente) this.actual).getLocalidad());
			this.jtfFechaNac.setText(((Cliente) this.actual).getFechaNac());
			
			// Carga del fabricante
			for (int i = 0; i < this.jcbCliente.getItemCount(); i++) {
				if (this.actual.getId() == this.jcbCliente.getItemAt(i).getId()) {
					this.jcbCliente.setSelectedIndex(i);
				}
			}
		}
	}


	
	/**
	 * 
	 */
	private void cargarActualDesdePantalla() {
		((Cliente) this.actual).setId(Integer.parseInt(jtfId.getText()));
		((Cliente) this.actual).setNombre(jtfNombre.getText());
		((Cliente) this.actual).setApellidos(jtfApellidos.getText());
		((Cliente) this.actual).setLocalidad(jtfLocalidad.getText());
		((Cliente) this.actual).setDniNie(jtfDniNieNie.getText());
		((Cliente) this.actual).setFechaNac(jtfFechaNac.getText());
	}
	
	
	/**
	 * 
	 */
	private void guardar () {
		cargarActualDesdePantalla();
		ClienteControlador.getControlador().modify((Cliente) actual);
	}

}