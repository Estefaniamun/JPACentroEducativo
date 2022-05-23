package modelo.vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;

import modelo.Curso;
import modelo.Materia;
import modelo.controladores.ControladorCurso;
import modelo.controladores.ControladorMateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Vista_Materia extends JPanel {
	private  JTextField jtfId;
	private  JTextField jtfNombre;
	private  JTextField jtfAcronimo;
	private  JButton btnPrimerRegistro;
	private  JButton btnAnteriorRegistro;
	private  JButton btnSiguienteRegistro;
	private  JButton btnUltimoRegistro;
	private  JComboBox<Curso> comboBoxCurso;
	ControladorMateria controlador = new ControladorMateria();
	private ControladorCurso curso = new ControladorCurso();
	// Variable que actúa como Singleton
	private static Vista_Materia instance = null;

	// Método que devuelve el singleton
	public static Vista_Materia getInstance() {
		if (instance == null) {
			instance = new Vista_Materia();
		}
		return instance;
	}

	/**
	 * 
	 */
	public Vista_Materia() {

		initialize();
		mostrarMateria(controlador.obtenerPrimero());
		comprobarEstadoBotones();

	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		btnPrimerRegistro = new JButton("<<");
		btnPrimerRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarMateria(controlador.obtenerPrimero());
				comprobarEstadoBotones();
			}
		});
		toolBar.add(btnPrimerRegistro);

		btnAnteriorRegistro = new JButton("<");
		btnAnteriorRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarMateria(controlador.obtenerAnterior(devolverMateria().getId()));
				comprobarEstadoBotones();
			}

		});
		toolBar.add(btnAnteriorRegistro);

		btnSiguienteRegistro = new JButton(">");
		btnSiguienteRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarMateria(controlador.obtenerSiguiente(devolverMateria().getId()));
				comprobarEstadoBotones();
			}
		});
		toolBar.add(btnSiguienteRegistro);

		btnUltimoRegistro = new JButton(">>");
		btnUltimoRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarMateria(controlador.obtenerUltimo());
				comprobarEstadoBotones();
			}
		});
		toolBar.add(btnUltimoRegistro);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarDatos();
				comprobarEstadoBotones();
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
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblid = new JLabel("ID:");
		GridBagConstraints gbc_lblid = new GridBagConstraints();
		gbc_lblid.insets = new Insets(0, 0, 5, 5);
		gbc_lblid.gridx = 1;
		gbc_lblid.gridy = 1;
		panel.add(lblid, gbc_lblid);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 2;
		gbc_jtfId.gridy = 1;
		panel.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		panel.add(lblNombre, gbc_lblNombre);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 2;
		gbc_jtfNombre.gridy = 2;
		panel.add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblAcronimo = new JLabel("Acronimo:");
		GridBagConstraints gbc_lblAcronimo = new GridBagConstraints();
		gbc_lblAcronimo.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcronimo.gridx = 1;
		gbc_lblAcronimo.gridy = 3;
		panel.add(lblAcronimo, gbc_lblAcronimo);

		jtfAcronimo = new JTextField();
		GridBagConstraints gbc_jtfAcronimo = new GridBagConstraints();
		gbc_jtfAcronimo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfAcronimo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfAcronimo.gridx = 2;
		gbc_jtfAcronimo.gridy = 3;
		panel.add(jtfAcronimo, gbc_jtfAcronimo);
		jtfAcronimo.setColumns(10);

		JLabel lblCurso = new JLabel("Curso:");
		GridBagConstraints gbc_lblCurso = new GridBagConstraints();
		gbc_lblCurso.insets = new Insets(0, 0, 0, 5);
		gbc_lblCurso.gridx = 1;
		gbc_lblCurso.gridy = 4;
		panel.add(lblCurso, gbc_lblCurso);

		comboBoxCurso = new JComboBox<Curso>();
		GridBagConstraints gbc_comboBoxCurso = new GridBagConstraints();
		gbc_comboBoxCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCurso.gridx = 2;
		gbc_comboBoxCurso.gridy = 4;
		panel.add(comboBoxCurso, gbc_comboBoxCurso);
		insertarValoresDeCursosEnElComboBox();
	}

	/**
	 * Con este método insertamos todos los cursos en el comboBox
	 */
	private void insertarValoresDeCursosEnElComboBox() {
		List<Curso> lista = curso.findAll();
		for (int i = 0; i < lista.size(); i++) {
			comboBoxCurso.addItem(lista.get(i));
		}
	}

	/**
	 * Con este método seleccionamos el curso que coincida con el idCurso
	 * 
	 * @param curso
	 */
	private  void seleccionarCursoEnComboBox(Curso curso) {
		for (int i = 0; i < comboBoxCurso.getItemCount(); i++) {
			if (comboBoxCurso.getItemAt(i).getId() == curso.getId()) {
				comboBoxCurso.setSelectedIndex(i);
			}
		} 
	}

	/**
	 * Con este método obtenemos el id del curso seleccionado
	 * 
	 * @return
	 */
	private  Curso getIdCursoSeleccionadoEnComboBox() {
		return ((Curso) comboBoxCurso.getSelectedItem());
	}

	/**
	 * Con este método insertamos en los JTextField los datos del coche que
	 * recibimos
	 * 
	 * @param c
	 */
	public  void mostrarMateria(Materia materia) {
		jtfId.setText("" + materia.getId());
		jtfNombre.setText(materia.getNombre());
		jtfAcronimo.setText(materia.getAcronimo());
		seleccionarCursoEnComboBox(materia.getCurso());

	}

	/**
	 * Con este método le insertamos al curso los datos que hay en los JTextField
	 * 
	 * @return
	 */
	public  Materia devolverMateria() {
		Materia materia = new Materia();
		materia.setId(Integer.parseInt(jtfId.getText()));
		materia.setNombre(jtfNombre.getText());
		materia.setAcronimo(jtfAcronimo.getText());
		materia.setCurso(getIdCursoSeleccionadoEnComboBox());
		return materia;
	}

	/**
	 * Con este método limpiamos los JTextField para el botón de nuevo
	 */
	public  void limpiarDatos() {
		jtfId.setText("0");
		jtfNombre.setText("");
		jtfAcronimo.setText("");
	}

	/**
	 * Con este método vamos a diferenciar si vamos a insertar uno nuevo o vamos a
	 * modificar
	 */
	public  void guardar() {
		if (Integer.parseInt(jtfId.getText()) == 0) {
			controlador.creacionEntidad(devolverMateria());
			mostrarMateria(controlador.obtenerUltimo());
			comprobarEstadoBotones();
			JOptionPane.showMessageDialog(null, "La inserción se ha realizado con éxito");
		} else {
			controlador.modificacionEntidad(devolverMateria());
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
				int idActual = devolverMateria().getId();
				controlador.remove(devolverMateria());
				JOptionPane.showMessageDialog(null, "¡La eliminación se ha realizado con éxito!");

				if (controlador.obtenerAnterior(idActual) != null) {
					mostrarMateria(controlador.obtenerAnterior(idActual));
					comprobarEstadoBotones();

				} else {
					if (controlador.obtenerSiguiente(idActual) != null) {
						mostrarMateria(controlador.obtenerSiguiente(idActual));
						comprobarEstadoBotones();
					} else {
						limpiarDatos();
						comprobarEstadoBotones();
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

		if (Integer.parseInt(jtfId.getText()) == controlador.obtenerPrimero().getId()) {
			btnPrimerRegistro.setEnabled(false);
			btnAnteriorRegistro.setEnabled(false);
		} else {
			btnPrimerRegistro.setEnabled(true);
			btnAnteriorRegistro.setEnabled(true);
		}

		if (Integer.parseInt(jtfId.getText()) == controlador.obtenerUltimo().getId()) {
			btnUltimoRegistro.setEnabled(false);
			btnSiguienteRegistro.setEnabled(false);
		} else {
			btnUltimoRegistro.setEnabled(true);
			btnSiguienteRegistro.setEnabled(true);

		}

		if (Integer.parseInt(jtfId.getText()) == 0) {
			btnPrimerRegistro.setEnabled(false);
			btnAnteriorRegistro.setEnabled(false);
			btnSiguienteRegistro.setEnabled(false);
			btnUltimoRegistro.setEnabled(false);
		}

	}
}
