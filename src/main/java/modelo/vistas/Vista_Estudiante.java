package modelo.vistas;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;

import modelo.Estudiante;
import modelo.controladores.ControladorEstudiante;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Vista_Estudiante extends JPanel {

	private PanelDatosPersonales panelEstudiante = new PanelDatosPersonales();
	ControladorEstudiante controlador = new ControladorEstudiante();
	private JButton btnPrimerRegistro;
	private JButton btnAnteriorRegistro;
	private JButton btnSiguienteRegistro;
	private JButton btnUltimoRegistro;

	/**
	 * Create the panel.
	 */
	public Vista_Estudiante() {
		initialize();
		mostrarEstudiante(controlador.obtenerPrimero());
		comprobarEstadoBotones();

	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		btnPrimerRegistro = new JButton("<<");
		btnPrimerRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEstudiante.limpiarColor();
				mostrarEstudiante(controlador.obtenerPrimero());
				comprobarEstadoBotones();

			}
		});
		toolBar.add(btnPrimerRegistro);

		btnAnteriorRegistro = new JButton("<");
		btnAnteriorRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEstudiante.limpiarColor();
				mostrarEstudiante(controlador.obtenerAnterior(panelEstudiante.getID()));
				comprobarEstadoBotones();

			}
		});
		toolBar.add(btnAnteriorRegistro);

		btnSiguienteRegistro = new JButton(">");
		btnSiguienteRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEstudiante.limpiarColor();
				mostrarEstudiante(controlador.obtenerSiguiente(panelEstudiante.getID()));
				comprobarEstadoBotones();

			}
		});
		toolBar.add(btnSiguienteRegistro);

		btnUltimoRegistro = new JButton(">>");
		btnUltimoRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEstudiante.limpiarColor();
				mostrarEstudiante(controlador.obtenerUltimo());
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

		add(panelEstudiante, BorderLayout.CENTER);

	}

	/**
	 * 
	 * @param e
	 */
	public void mostrarEstudiante(Estudiante e) {
		panelEstudiante.setID(e.getId());
		panelEstudiante.setNombre(e.getNombre());
		panelEstudiante.setApellido1(e.getApellido1());
		panelEstudiante.setApellido2(e.getApellido2());
		panelEstudiante.setSexo(e.getTipologiaSexo());
		;
		panelEstudiante.setDNI(e.getDni());
		panelEstudiante.setDireccion(e.getDireccion());
		panelEstudiante.setEmail(e.getEmail());
		panelEstudiante.setTelefono(e.getTelefono());
		panelEstudiante.setImagen(e.getImagen());

		if(e.getColorPreferido() != null) {
			if (e.getColorPreferido().equalsIgnoreCase("")) {
				panelEstudiante.setBackground(Color.WHITE);
			} else {
				panelEstudiante.setColor(e.getColorPreferido());
			}
		}
		

	}

	/**
	 * 
	 */
	public Estudiante devolverEstudiante() {
		Estudiante e = new Estudiante();

		e.setId(panelEstudiante.getID());
		e.setNombre(panelEstudiante.getNombre());
		e.setApellido1(panelEstudiante.getApellido1());
		e.setApellido2(panelEstudiante.getApellido2());
		e.setTipologiaSexo(panelEstudiante.getSexo());
		e.setDni(panelEstudiante.getDNI());
		e.setDireccion(panelEstudiante.getDireccion());
		e.setEmail(panelEstudiante.getEmail());
		e.setTelefono(panelEstudiante.getTelefono());
		e.setImagen(panelEstudiante.getImagen());
		e.setColorPreferido(panelEstudiante.getColor());

		return e;
	}

	public void limpiarDatos() {
		panelEstudiante.setID(0);
		panelEstudiante.setNombre("");
		panelEstudiante.setApellido1("");
		panelEstudiante.setApellido2("");
		panelEstudiante.setDNI("");
		panelEstudiante.setDireccion("");
		panelEstudiante.setEmail("");
		panelEstudiante.setTelefono("");
	}

	/**
	 * Con este método vamos a diferenciar si vamos a insertar uno nuevo o vamos a
	 * modificar
	 */
	public void guardar() {

		if (panelEstudiante.getID() == 0) {
			controlador.creacionEntidad(devolverEstudiante());;
			mostrarEstudiante(controlador.obtenerUltimo());
			comprobarEstadoBotones();

			JOptionPane.showMessageDialog(null, "La inserción se ha realizado con éxito");
		} else {
			controlador.modificacionEntidad(devolverEstudiante());

			JOptionPane.showMessageDialog(null, "La modificación se ha realizado con éxito");
		}

	}

	/**
	 * Con este método vamos a eliminar y además vamos a comprobar si hay un
	 * anterior, un siguiente o ninguno y con eso comprobamos también los botones
	 */
	public void borrar() {
		String[] opciones = { "Aceptar", "Cancelar" };
		int eleccion = JOptionPane.showOptionDialog(null, "¿Desea eliminar el registro?", null,
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");

		try {
			if (eleccion == JOptionPane.YES_OPTION) {
				int idActual = panelEstudiante.getID();
				controlador.remove(devolverEstudiante());
				JOptionPane.showMessageDialog(null, "¡La eliminación se ha realizado con éxito!");
				if (controlador.obtenerAnterior(idActual) != null) {
					mostrarEstudiante(controlador.obtenerAnterior(idActual));
					comprobarEstadoBotones();
				} else {
					if (controlador.obtenerSiguiente(idActual) != null) {
						mostrarEstudiante(controlador.obtenerSiguiente(idActual));
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
	public void comprobarEstadoBotones() {

		if (panelEstudiante.getID() == controlador.obtenerPrimero().getId()) {
			btnPrimerRegistro.setEnabled(false);
			btnAnteriorRegistro.setEnabled(false);
		} else {
			btnPrimerRegistro.setEnabled(true);
			btnAnteriorRegistro.setEnabled(true);
		}

		if (panelEstudiante.getID() == controlador.obtenerUltimo().getId()) {
			btnUltimoRegistro.setEnabled(false);
			btnSiguienteRegistro.setEnabled(false);
		} else {
			btnUltimoRegistro.setEnabled(true);
			btnSiguienteRegistro.setEnabled(true);

		}

		if (panelEstudiante.getID() == 0) {
			btnPrimerRegistro.setEnabled(false);
			btnAnteriorRegistro.setEnabled(false);
			btnSiguienteRegistro.setEnabled(false);
			btnUltimoRegistro.setEnabled(false);
		}

	}
}
