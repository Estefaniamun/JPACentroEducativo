package modelo.vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import modelo.controladores.ControladorCurso;
import modelo.Curso;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista_Curso extends JPanel {
	private  JTextField jtfid;
	private  JTextField jtfdesc;
	private  JButton btnPrimerRegistro;
	private  JButton btnAnteriorRegistro;
	private  JButton btnSiguienteRegistro;
	private  JButton btnUltimoRegistro;
	ControladorCurso controlador = new ControladorCurso();

	/**
	 * 
	 */
	public Vista_Curso() {
		initialize();
		mostrarCurso(controlador.obtenerPrimero());
		comprobarEstadoBotones();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		btnPrimerRegistro = new JButton("<<");
		btnPrimerRegistro.setToolTipText("Cargar el primer registro");
		btnPrimerRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCurso(controlador.obtenerPrimero());
				comprobarEstadoBotones();
			}
		});
		toolBar.add(btnPrimerRegistro);

		btnAnteriorRegistro = new JButton("<");
		btnAnteriorRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCurso(controlador.obtenerAnterior(devolverCurso().getId()));
				comprobarEstadoBotones();
			}
		});
		btnAnteriorRegistro.setToolTipText("Cargar el anterior registro");
		toolBar.add(btnAnteriorRegistro);

		btnSiguienteRegistro = new JButton(">");
		btnSiguienteRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCurso(controlador.obtenerSiguiente(devolverCurso().getId()));
				comprobarEstadoBotones();
			}
		});
		btnSiguienteRegistro.setToolTipText("Cargar siguiente registro");
		toolBar.add(btnSiguienteRegistro);

		btnUltimoRegistro = new JButton(">>");
		btnUltimoRegistro.setToolTipText("Cargar el ultimo registro");
		btnUltimoRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarCurso(controlador.obtenerUltimo());
				comprobarEstadoBotones();
			}
		});
		toolBar.add(btnUltimoRegistro);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();

			}
		});
		toolBar.add(btnNuevo);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		toolBar.add(btnGuardar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		toolBar.add(btnEliminar);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblid = new JLabel("ID:");
		GridBagConstraints gbc_lblid = new GridBagConstraints();
		gbc_lblid.insets = new Insets(0, 0, 5, 5);
		gbc_lblid.gridx = 2;
		gbc_lblid.gridy = 1;
		panel.add(lblid, gbc_lblid);

		jtfid = new JTextField();
		jtfid.setEnabled(false);
		GridBagConstraints gbc_jtfid = new GridBagConstraints();
		gbc_jtfid.insets = new Insets(0, 0, 5, 0);
		gbc_jtfid.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfid.gridx = 3;
		gbc_jtfid.gridy = 1;
		panel.add(jtfid, gbc_jtfid);
		jtfid.setColumns(10);

		JLabel lblDescrip = new JLabel("Descripción:");
		GridBagConstraints gbc_lblDescrip = new GridBagConstraints();
		gbc_lblDescrip.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescrip.gridx = 2;
		gbc_lblDescrip.gridy = 2;
		panel.add(lblDescrip, gbc_lblDescrip);

		jtfdesc = new JTextField();
		GridBagConstraints gbc_jtfdesc = new GridBagConstraints();
		gbc_jtfdesc.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfdesc.gridx = 3;
		gbc_jtfdesc.gridy = 2;
		panel.add(jtfdesc, gbc_jtfdesc);
		jtfdesc.setColumns(10);
	}

	/**
	 * Con este método mostramos en pantalla los datos de los cursos
	 * 
	 * @param curso
	 */
	public  void mostrarCurso(Curso curso) {
		jtfid.setText("" + curso.getId());
		jtfdesc.setText(curso.getDescripcion());
	}

	/**
	 * Con este método le insertamos al curso los datos que hay en los JTextField
	 * 
	 * @return
	 */
	public Curso devolverCurso() {
		Curso curso = new Curso();
		curso.setId(Integer.parseInt(jtfid.getText()));
		curso.setDescripcion(jtfdesc.getText());
		return curso;
	}

	/**
	 * Con este método limpiamos los JTextField para el botón de nuevo
	 */
	public  void limpiarDatos() {
		jtfid.setText("0");
		jtfdesc.setText("");
	}

	/**
	 * Con este método vamos a diferenciar si vamos a insertar uno nuevo o vamos a
	 * modificar
	 */
	public  void guardar() {
		if (Integer.parseInt(jtfid.getText()) == 0) {
			controlador.creacionEntidad(devolverCurso());
			mostrarCurso(controlador.obtenerUltimo());

			JOptionPane.showMessageDialog(null, "La inserción se ha realizado con éxito");
		} 
		else {
			controlador.modificacionEntidad(devolverCurso());

			JOptionPane.showMessageDialog(null, "La modificación se ha realizado con éxito");
		}

	}

	/**
	 * Con este método vamos a eliminar y además vamos a comprobar si hay un
	 * anterior, un siguiente o ninguno y con eso comprobamos también los botones
	 */
	public  void borrar() {
		String[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(null, "¿Desea eliminar el registro?", null,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");

		try {
			if (eleccion == JOptionPane.YES_OPTION) {
				int idActual = devolverCurso().getId();
				controlador.remove(devolverCurso());
				JOptionPane.showMessageDialog(null, "¡La eliminación se ha realizado con éxito!");
				if (controlador.obtenerAnterior(idActual) != null) {
					mostrarCurso(controlador.obtenerAnterior(idActual));
					comprobarEstadoBotones();
				} else {
					if (controlador.obtenerSiguiente(idActual) != null) {
						mostrarCurso(controlador.obtenerSiguiente(idActual));
						comprobarEstadoBotones();
					} else {
						limpiarDatos();

					}
				}
			}

		} catch (Exception ex) {
			final JPanel panel = new JPanel();

			JOptionPane.showMessageDialog(panel, "Ha sido imposible realizar el borrado del registro", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Este metodo es para habilitar y deshabilitar los botones si estamos en el
	 * primer o último registro de la tabla Y si se está creando un nuevo registro
	 * en la tabla se deshabilita todos los botones de dirección
	 */
	public  void comprobarEstadoBotones() {

		if (Integer.parseInt(jtfid.getText()) == controlador.obtenerPrimero().getId()) {
			btnPrimerRegistro.setEnabled(false);
			btnAnteriorRegistro.setEnabled(false);
		} else {
			btnPrimerRegistro.setEnabled(true);
			btnAnteriorRegistro.setEnabled(true);
		}

		if (Integer.parseInt(jtfid.getText()) == controlador.obtenerUltimo().getId()) {
			btnUltimoRegistro.setEnabled(false);
			btnSiguienteRegistro.setEnabled(false);
		} else {
			btnUltimoRegistro.setEnabled(true);
			btnSiguienteRegistro.setEnabled(true);

		}

		if (Integer.parseInt(jtfid.getText()) == 0) {
			btnPrimerRegistro.setEnabled(false);
			btnAnteriorRegistro.setEnabled(false);
			btnSiguienteRegistro.setEnabled(false);
			btnUltimoRegistro.setEnabled(false);
		}

	}

}
