package modelo.vistas;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class MenuPrincipal extends JMenuBar {

	/**
	 * 
	 */

	public MenuPrincipal() {
		// Menú Archivo de la aplicación
		JMenu menuGestion = new JMenu("Gestión");

		menuGestion.add(crearCurso());
		menuGestion.add(crearMateria());
		menuGestion.add(crearEstudiante());
		menuGestion.add(crearProfesor());
		menuGestion.add(crearValoracionMateria());
		this.add(menuGestion);
	}

	/**
	 * Menú Item para salir de la aplicación
	 * 
	 * @return
	 */
	private JMenuItem crearNuevoMenuItem(String titulo) {
		JMenuItem item = new JMenuItem(titulo);

		return item;
	}

	/**
	 * Con este método creamos el item de cursos con su Action Performed
	 * @return
	 */
	private JMenuItem crearCurso() {
		JMenuItem itemCurso = crearNuevoMenuItem("Cursos");
		itemCurso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaUtils.mostrarPanelEnDialogo(new Vista_Curso(), "Cursos");

			}
		});

		return itemCurso;
	}

	/**
	 * Con este método creamos el item de materias con su Action Performed
	 * @return
	 */
	private JMenuItem crearMateria() {
		JMenuItem itemMateria = crearNuevoMenuItem("Materias");

		itemMateria.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaUtils.mostrarPanelEnDialogo(new Vista_Materia(), "Materias");

			}
		});
		return itemMateria;
	}
	
	/**
	 * 
	 * @return
	 */
	private JMenuItem crearEstudiante() {
		JMenuItem itemEstudiante = crearNuevoMenuItem("Estudiantes");
		itemEstudiante.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaUtils.mostrarPanelEnDialogo(new Vista_Estudiante(), "Estudiantes");

			}
		});

		return itemEstudiante;
	}
	
	/**
	 * 
	 * @return
	 */
	private JMenuItem crearProfesor() {
		JMenuItem itemProfesor = crearNuevoMenuItem("Profesores");

		itemProfesor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaUtils.mostrarPanelEnDialogo(new Vista_Profesor(), "Profesores");

			}
		});
		return itemProfesor;
	}
	
	/**
	 * Con este método creamos el item de valoración materias con su Action Performed
	 * @return
	 */
	private JMenuItem crearValoracionMateria() {
		JMenuItem itemValoracion = crearNuevoMenuItem("Valoración Materias");
		itemValoracion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				VistaUtils.mostrarPanelEnDialogo(new Vista_ValoraciónMateria(), "Valoración Materias");

			}
		});

		return itemValoracion;
	}
}
