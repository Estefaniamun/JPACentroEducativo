package modelo.vistas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JToolBar;



public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	public ToolBar() {

		this.add(crearCurso());
		this.add(crearMateria());
		this.add(crearEstudiante());
		this.add(crearProfesor());
		this.add(crearValoracionMateria());
	}

	/**
	 * 
	 * @param titulo
	 * @return
	 */
	private JButton creaBoton(String titulo) {
		JButton jbt = new JButton();

		jbt.setText(titulo);

		return jbt;
	}
	
	/**
	 * Con este método creamos el botón de cursos con su Action Performed
	 * @return
	 */
	private JButton crearCurso() {
		JButton jbtCurso = creaBoton("Cursos");
		jbtCurso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VistaUtils.mostrarPanelEnDialogo(new Vista_Curso(), "Cursos");

			}
		});

		return jbtCurso;
	}

	/**
	 * Con este método creamos el botón de las materias con su Action Performed
	 * @return
	 */
	private JButton crearMateria() {
		JButton jbtMateria = creaBoton("Materias");

		jbtMateria.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaUtils.mostrarPanelEnDialogo(new Vista_Materia(), "Materias");

			}
		});

		return jbtMateria;
	}
	
	/**
	 *  Con este método creamos el botón de estudiante con su Action Performed
	 * @return
	 */
	private JButton crearEstudiante() {
		JButton jbtEstudiante = creaBoton("Estudiantes");
		jbtEstudiante.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VistaUtils.mostrarPanelEnDialogo(new Vista_Estudiante(), "Estudiantes");

			}
		});

		return jbtEstudiante;
	}
	
	/**
	 *  Con este método creamos el botón de profesor con su Action Performed
	 * @return
	 */
	private JButton crearProfesor() {
		JButton jbtProfesor = creaBoton("Profesores");
		jbtProfesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VistaUtils.mostrarPanelEnDialogo(new Vista_Profesor(), "Profesores");

			}
		});

		return jbtProfesor;
	}
	/**
	 * Con este método creamos el botón de valoración materias con su Action Performed
	 * @return
	 */
	private JButton crearValoracionMateria() {
		JButton jbtCurso = creaBoton("Valoración Materias");
		jbtCurso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				VistaUtils.mostrarPanelEnDialogo(new Vista_ValoraciónMateria(), "Valoración Materias");

			}
		});

		return jbtCurso;
	}
}
