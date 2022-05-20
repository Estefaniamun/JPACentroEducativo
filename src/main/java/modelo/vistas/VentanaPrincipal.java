package modelo.vistas;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	

	/**
	 * 
	 */
	public VentanaPrincipal() {
		super("Ventana Principal");
		this.setBounds(0, 0, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Menú de la aplicación
		this.setJMenuBar(new MenuPrincipal());

		// Establezco el panel principal de la aplicación y la barra de herramientas
		this.setLayout(new BorderLayout());
		this.add(new ToolBar(), BorderLayout.NORTH);
		
	}

	

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}

}
