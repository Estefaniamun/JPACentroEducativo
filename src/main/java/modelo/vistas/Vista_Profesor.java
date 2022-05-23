package modelo.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import modelo.Profesor;
import modelo.controladores.ControladorProfesor;

public class Vista_Profesor extends JPanel {
	private PanelDatosPersonales panelProfesor = new PanelDatosPersonales();
	ControladorProfesor controlador = new ControladorProfesor();
	private JButton btnPrimerRegistro;
	private JButton btnAnteriorRegistro;
	private JButton btnSiguienteRegistro;
	private JButton btnUltimoRegistro;

	/**
	 * Create the panel.
	 */
	public Vista_Profesor() {
		initialize();
		mostrarProfesor(controlador.obtenerPrimero());
		comprobarEstadoBotones();
	}

	private void initialize() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		btnPrimerRegistro = new JButton("<<");
		btnPrimerRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProfesor.limpiarColor();
				mostrarProfesor(controlador.obtenerPrimero());
				comprobarEstadoBotones();
			}
		});
		toolBar.add(btnPrimerRegistro);

		btnAnteriorRegistro = new JButton("<");
		btnAnteriorRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProfesor.limpiarColor();
				mostrarProfesor(controlador.obtenerAnterior(panelProfesor.getID()));
				comprobarEstadoBotones();
			}
		});
		toolBar.add(btnAnteriorRegistro);

		btnSiguienteRegistro = new JButton(">");
		btnSiguienteRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProfesor.limpiarColor();
				mostrarProfesor(controlador.obtenerSiguiente(panelProfesor.getID()));
				comprobarEstadoBotones();
			}
		});
		toolBar.add(btnSiguienteRegistro);

		btnUltimoRegistro = new JButton(">>");
		btnUltimoRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProfesor.limpiarColor();
				mostrarProfesor(controlador.obtenerUltimo());
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

		add(panelProfesor, BorderLayout.CENTER);

	}

	/**
	 * 
	 * @param p
	 */
	private void mostrarProfesor(Profesor p) {

		panelProfesor.setID(p.getId());
		panelProfesor.setNombre(p.getNombre());
		panelProfesor.setApellido1(p.getApellido1());
		panelProfesor.setApellido2(p.getApellido2());
		panelProfesor.setSexo(p.getTipologiaSexo());
		panelProfesor.setDNI(p.getDni());
		panelProfesor.setDireccion(p.getDireccion());
		panelProfesor.setEmail(p.getEmail());
		panelProfesor.setTelefono(p.getTelefono());
		panelProfesor.setImagen(p.getImagen());
		if(p.getColorPreferido() != null) {
			if(p.getColorPreferido().equalsIgnoreCase("")) {
				panelProfesor.setBackground(Color.WHITE);
			}
			else {
				panelProfesor.setColor(p.getColorPreferido());
			}
		}
		
	}

	/**
	 * 
	 */
	public Profesor devolverProfesor() {
		Profesor p = new Profesor();

		p.setId(panelProfesor.getID());
		p.setNombre(panelProfesor.getNombre());
		p.setApellido1(panelProfesor.getApellido1());
		p.setApellido2(panelProfesor.getApellido2());
		p.setTipologiaSexo(panelProfesor.getSexo());
		p.setDni(panelProfesor.getDNI());
		p.setDireccion(panelProfesor.getDireccion());
		p.setEmail(panelProfesor.getEmail());
		p.setTelefono(panelProfesor.getTelefono());
		p.setImagen(panelProfesor.getImagen());
		p.setColorPreferido(panelProfesor.getColor());

		return p;

	}

	public void limpiarDatos() {
		panelProfesor.setID(0);
		panelProfesor.setNombre("");
		panelProfesor.setApellido1("");
		panelProfesor.setApellido2("");
		panelProfesor.setDNI("");
		panelProfesor.setDireccion("");
		panelProfesor.setEmail("");
		panelProfesor.setTelefono("");
	}

	/**
	 * Con este método vamos a diferenciar si vamos a insertar uno nuevo o vamos a
	 * modificar
	 */
	public void guardar() {
		if (panelProfesor.getID() == 0) {
			controlador.creacionEntidad(devolverProfesor());
			mostrarProfesor(controlador.obtenerUltimo());
			comprobarEstadoBotones();

			JOptionPane.showMessageDialog(null, "La inserción se ha realizado con éxito");
		} else {
			controlador.modificacionEntidad(devolverProfesor());

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
				int idActual = panelProfesor.getID();
				controlador.remove(devolverProfesor());
				JOptionPane.showMessageDialog(null, "¡La eliminación se ha realizado con éxito!");
				if (controlador.obtenerAnterior(panelProfesor.getID()) != null) {
					mostrarProfesor(controlador.obtenerAnterior(panelProfesor.getID()));
					comprobarEstadoBotones();
				} else {
					if (controlador.obtenerSiguiente(panelProfesor.getID()) != null) {
						mostrarProfesor(controlador.obtenerSiguiente(panelProfesor.getID()));
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

		if (panelProfesor.getID() == controlador.obtenerPrimero().getId()) {
			btnPrimerRegistro.setEnabled(false);
			btnAnteriorRegistro.setEnabled(false);
		} else {
			btnPrimerRegistro.setEnabled(true);
			btnAnteriorRegistro.setEnabled(true);
		}

		if (panelProfesor.getID() == controlador.obtenerUltimo().getId()) {
			btnUltimoRegistro.setEnabled(false);
			btnSiguienteRegistro.setEnabled(false);
		} else {
			btnUltimoRegistro.setEnabled(true);
			btnSiguienteRegistro.setEnabled(true);

		}

		if (panelProfesor.getID() == 0) {
			btnPrimerRegistro.setEnabled(false);
			btnAnteriorRegistro.setEnabled(false);
			btnSiguienteRegistro.setEnabled(false);
			btnUltimoRegistro.setEnabled(false);
		}

	}

}
