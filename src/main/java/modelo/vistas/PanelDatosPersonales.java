package modelo.vistas;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.nio.file.Files;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;

import modelo.TipologiaSexo;
import modelo.controladores.ControladorEstudiante;
import modelo.controladores.ControladorTipologiaSexo;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class PanelDatosPersonales extends JPanel {
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDni;
	private JTextField jtfDireccion;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JLabel lblNewLabel;
	private JTextField jtfid;
	private JLabel lblNewLabel_7;
	private JComboBox<TipologiaSexo> comboBoxSexo;
	byte[] imagenEnArrayDeBytes;
	private List<TipologiaSexo> lista = new ArrayList<TipologiaSexo>();
	private JScrollPane scrollPane;
	private JButton btnCambiarImagen;
	private JLabel lblColor;
	private JTextField jtfColor;
	private JButton btnCambiarColor;
	private JColorChooser jColorChooser;
	private ControladorTipologiaSexo sexo = new ControladorTipologiaSexo();

	/**
	 * Create the panel.
	 */
	public PanelDatosPersonales() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		lblNewLabel = new JLabel("ID:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		jtfid = new JTextField();
		GridBagConstraints gbc_jtfid = new GridBagConstraints();
		gbc_jtfid.insets = new Insets(0, 0, 5, 5);
		gbc_jtfid.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfid.gridx = 1;
		gbc_jtfid.gridy = 0;
		add(jtfid, gbc_jtfid);
		jtfid.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);

		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		add(lblNombre, gbc_lblNombre);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Primer Apellido:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfApellido1 = new JTextField();
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 2;
		add(jtfApellido1, gbc_jtfApellido1);
		jtfApellido1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Segundo Apellido:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		add(lblNewLabel_2, gbc_lblNewLabel_2);

		jtfApellido2 = new JTextField();
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 3;
		add(jtfApellido2, gbc_jtfApellido2);
		jtfApellido2.setColumns(10);

		lblNewLabel_7 = new JLabel("Sexo:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 4;
		add(lblNewLabel_7, gbc_lblNewLabel_7);

		comboBoxSexo = new JComboBox<TipologiaSexo>();
		GridBagConstraints gbc_comboBoxSexo = new GridBagConstraints();
		gbc_comboBoxSexo.insets = new Insets(0, 0, 5, 5);
		gbc_comboBoxSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxSexo.gridx = 1;
		gbc_comboBoxSexo.gridy = 4;
		add(comboBoxSexo, gbc_comboBoxSexo);

		btnCambiarImagen = new JButton("Cambiar Imagen");
		btnCambiarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaImagen();

			}
		});
		GridBagConstraints gbc_btnCambiarImagen = new GridBagConstraints();
		gbc_btnCambiarImagen.insets = new Insets(0, 0, 5, 0);
		gbc_btnCambiarImagen.gridx = 2;
		gbc_btnCambiarImagen.gridy = 4;
		add(btnCambiarImagen, gbc_btnCambiarImagen);

		JLabel lblNewLabel_3 = new JLabel("DNI:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfDni = new JTextField();
		GridBagConstraints gbc_jtfDni = new GridBagConstraints();
		gbc_jtfDni.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDni.gridx = 1;
		gbc_jtfDni.gridy = 5;
		add(jtfDni, gbc_jtfDni);
		jtfDni.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Dirección:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfDireccion = new JTextField();
		GridBagConstraints gbc_jtfDireccion = new GridBagConstraints();
		gbc_jtfDireccion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDireccion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDireccion.gridx = 1;
		gbc_jtfDireccion.gridy = 6;
		add(jtfDireccion, gbc_jtfDireccion);
		jtfDireccion.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 7;
		add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 7;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Teléfono:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfTelefono = new JTextField();
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 8;
		add(jtfTelefono, gbc_jtfTelefono);
		jtfTelefono.setColumns(10);

		lblColor = new JLabel("Color Preferido:");
		GridBagConstraints gbc_lblColor = new GridBagConstraints();
		gbc_lblColor.anchor = GridBagConstraints.EAST;
		gbc_lblColor.insets = new Insets(0, 0, 0, 5);
		gbc_lblColor.gridx = 0;
		gbc_lblColor.gridy = 9;
		add(lblColor, gbc_lblColor);

		jtfColor = new JTextField();
		GridBagConstraints gbc_jtfColor = new GridBagConstraints();
		gbc_jtfColor.insets = new Insets(0, 0, 0, 5);
		gbc_jtfColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColor.gridx = 1;
		gbc_jtfColor.gridy = 9;
		add(jtfColor, gbc_jtfColor);
		jtfColor.setColumns(10);

		btnCambiarColor = new JButton("Cambiar Color");
		btnCambiarColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnCambiarColor = new GridBagConstraints();
		gbc_btnCambiarColor.gridx = 2;
		gbc_btnCambiarColor.gridy = 9;
		add(btnCambiarColor, gbc_btnCambiarColor);

		cargarValores();
		menuPopUp();

	}

	/**
	 * Método para el menú Popup(contextual)
	 */
	private void menuPopUp() {
		// Evento para mostrar el menú en las coordenadas que correspondan
		scrollPane.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				showPopup(e);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				showPopup(e);
			}

			/**
			 * Método llamado cuando se detecta el evento de ratón, mostrará el menú
			 * 
			 * @param e
			 */
			private void showPopup(MouseEvent e) {
				JPopupMenu menu = new JPopupMenu();
				int alto = 0, ancho = 0;
				if (imagenEnArrayDeBytes != null && imagenEnArrayDeBytes.length > 0) {
					ImageIcon icono = new ImageIcon(imagenEnArrayDeBytes);

					alto = icono.getIconHeight();
					ancho = icono.getIconWidth();
				}

				menu.add(crearNuevoMenuItem("Dimensiones: " + alto + " x " + ancho + "píxeles"));
				menu.addSeparator();
				menu.add(crearNuevoMenuItem("Cambiar imagen"));

				if (e.isPopupTrigger()) {
					menu.show(e.getComponent(), e.getX(), e.getY());
				}
			}
		});
	}

	/**
	 * Menú Item para salir de la aplicación Le indico un parámetro de entrada de
	 * tipo String para diferenciar los item, ya que el de Cambiar imagen va a tener
	 * dentro de su ActionListener el método de seleccionar imagen
	 * 
	 * @return
	 */
	private JMenuItem crearNuevoMenuItem(String titulo) {
		JMenuItem item = new JMenuItem(titulo);
		if (titulo.equals("Cambiar imagen")) {
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					seleccionaImagen();
				}
			});
		}
		return item;
	}

	/**
	 * Método para seleccionar el color
	 */
	private void seleccionaColor() {
		Color color = jColorChooser.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no será nulo
		if (color != null) {
			String strColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColor.setText(strColor);
			this.setBackground(color);
		}
	}

	/**
	 * Método para introducir el color
	 * 
	 * @param newColor
	 */
	public void setColor(String newColor) {
		Color color = Color.decode(newColor);
		String strColor = "#" + Integer.toHexString(color.getRGB()).substring(2);
		this.jtfColor.setText(strColor);
		this.setBackground(color);

	}

	/**
	 * Método para limpiar el JTextField y el background
	 */
	public void limpiarColor() {
		this.jtfColor.setText("");
		this.setBackground(Color.WHITE);
	}

	/**
	 * Método para obtener el color
	 * 
	 * @return
	 */
	public String getColor() {
		return this.jtfColor.getText();
	}

	/**
	 * Con este método seleccionamos la imagen que queremos
	 */
	public void seleccionaImagen() {
		JFileChooser jfileChooser = new JFileChooser();

		// Configurando el componente

		// Tipo de selección que se hace en el diálogo
		jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // Sólo selecciona ficheros

		// Filtro del tipo de ficheros que puede abrir
		jfileChooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				return "Archivos de imagen *.jpg *.png *.gif";
			}

			@Override
			public boolean accept(File f) {
				if (f.isDirectory()
						|| (f.isFile() && (f.getAbsolutePath().endsWith(".jpg") || f.getAbsolutePath().endsWith(".jpeg")
								|| f.getAbsolutePath().endsWith(".png") || f.getAbsolutePath().endsWith(".gif"))))
					return true;
				return false;
			}
		});

		// Abro el diálogo para la elección del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);

		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = jfileChooser.getSelectedFile();

			if (fichero.isFile()) {
				try {
					this.imagenEnArrayDeBytes = Files.readAllBytes(fichero.toPath());
					mostrarImagen(imagenEnArrayDeBytes);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	/**
	 * Este método recibe un array de byte
	 */
	public void mostrarImagen(byte[] imagenEnArrayDeBytes) {
		this.imagenEnArrayDeBytes = imagenEnArrayDeBytes;
		if (imagenEnArrayDeBytes != null && imagenEnArrayDeBytes.length > 0) {
			ImageIcon icono = new ImageIcon(this.imagenEnArrayDeBytes);

			JLabel lblIcono = new JLabel(icono);
			scrollPane.setViewportView(lblIcono);

		} else {
			JLabel lblIcono = new JLabel("Sin imagen");
			scrollPane.setViewportView(lblIcono);
		}

	}

	/**
	 * Método para introducir la imagen
	 * 
	 * @param imagenEnArrayDeBytes
	 */
	public void setImagen(byte[] imagenEnArrayDeBytes) {
		mostrarImagen(imagenEnArrayDeBytes);
	}

	/**
	 * Método para obtener la imagen
	 * 
	 * @return
	 */
	public byte[] getImagen() {
		return imagenEnArrayDeBytes;
	}

	/**
	 * 
	 * @param newID
	 */
	public void setID(int newID) {

		this.jtfid.setText("" + newID);
	}

	/**
	 * 
	 * @return
	 */
	public int getID() {
		return Integer.parseInt(this.jtfid.getText());
	}

	/**
	 * 
	 * @param newNombre
	 */
	public void setNombre(String newNombre) {
		this.jtfNombre.setText(newNombre);
	}

	/**
	 * 
	 * @return
	 */
	public String getNombre() {
		return this.jtfNombre.getText();
	}

	/**
	 * 
	 * @param newApellido1
	 */
	public void setApellido1(String newApellido1) {
		this.jtfApellido1.setText(newApellido1);
	}

	/**
	 * 
	 * @return
	 */
	public String getApellido1() {
		return this.jtfApellido1.getText();
	}

	/**
	 * 
	 * @param newApellido2
	 */
	public void setApellido2(String newApellido2) {
		this.jtfApellido2.setText(newApellido2);
	}

	/**
	 * 
	 * @return
	 */
	public String getApellido2() {
		return this.jtfApellido2.getText();
	}

	/**
	 * El método para cargar los valores de tipologiaSexo
	 */
	public void cargarValores() {
		List<TipologiaSexo> lista = sexo.findAll();
		for (int i = 0; i < lista.size(); i++) {
			comboBoxSexo.addItem(lista.get(i));
		}
	}

	/**
	 * 
	 * @param tipologiaSexo
	 */
	public void setSexo(TipologiaSexo tipologiaSexo) {
		for (int i = 0; i < comboBoxSexo.getItemCount(); i++) {
			if (comboBoxSexo.getItemAt(i).getId() == tipologiaSexo.getId()) {
				comboBoxSexo.setSelectedIndex(i);
			} 
		}
	}

	/**
	 * 
	 * @return
	 */
	public TipologiaSexo getSexo() {
		return ((TipologiaSexo) this.comboBoxSexo.getSelectedItem());
	}

	/**
	 * 
	 * @param newDNI
	 */
	public void setDNI(String newDNI) {
		this.jtfDni.setText(newDNI);
	}

	/**
	 * 
	 * @return
	 */
	public String getDNI() {
		return this.jtfDni.getText();
	}

	/**
	 * 
	 * @param newDireccion
	 */
	public void setDireccion(String newDireccion) {
		this.jtfDireccion.setText(newDireccion);
	}

	/**
	 * 
	 * @return
	 */
	public String getDireccion() {
		return this.jtfDireccion.getText();
	}

	/**
	 * 
	 * @param newEmail
	 */
	public void setEmail(String newEmail) {
		this.jtfEmail.setText(newEmail);
	}

	/**
	 * 
	 * @return
	 */
	public String getEmail() {
		return this.jtfEmail.getText();
	}

	/**
	 * 
	 * @param newTelefono
	 */
	public void setTelefono(String newTelefono) {
		this.jtfTelefono.setText(newTelefono);
	}

	/**
	 * 
	 * @return
	 */
	public String getTelefono() {
		return this.jtfTelefono.getText();
	}

}
