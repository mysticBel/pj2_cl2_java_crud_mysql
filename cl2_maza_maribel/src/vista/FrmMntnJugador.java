package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jvnet.substance.SubstanceLookAndFeel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.toedter.calendar.JDateChooser;

import entidad.Equipo;
import entidad.Jugador;
import mantenimiento.GestionEquipoDAO;
import mantenimiento.GestionJugadorDAO;
import utils.Alertas;
import utils.Validaciones;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class FrmMntnJugador extends JFrame implements ActionListener, MouseListener, KeyListener {

	private JPanel contentPane;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblDNI;
	private JLabel lblFecha;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JDateChooser dcFechaNac;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblEquipo;
	private JLabel lblSueldo;
	private JComboBox cboEquipos;
	private JTextField txtSueldo;
	private JButton btnNuevo;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	private JTable tblJugadores;
	
	
	// Instanciar un objeto para el modelamiento de la tabla tblJugadores
	DefaultTableModel model = new DefaultTableModel();
	//instanciamos
	GestionJugadorDAO gJug = new GestionJugadorDAO();
	GestionEquipoDAO gEq = new GestionEquipoDAO();
	private JPanel panel;
	private JLabel lblTitulo;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JLabel lblErrorCodigo;
	private JLabel lblErrorNombre;
	private JLabel lblErrorDNI;
	private JLabel lblErrorFecha;
	private JLabel lblErrorApellido;
	private JLabel lblErrorEquipo;
	private JLabel lblErrorSueldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMntnJugador frame = new FrmMntnJugador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmMntnJugador() {
		try {
			//look and feel
			//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
			SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.OfficeSilver2007Skin");
		}catch(Exception e){
			e.printStackTrace();
		}

		
		
		setTitle("Mantenimiento Jugador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 784, 572);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodigo.setBounds(27, 52, 69, 19);
		contentPane.add(lblCodigo);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setBounds(27, 77, 69, 19);
		contentPane.add(lblNombre);
		
		lblDNI = new JLabel("DNI");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDNI.setBounds(27, 102, 69, 19);
		contentPane.add(lblDNI);
		
		lblFecha = new JLabel("Fecha Nac.");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(27, 127, 69, 20);
		contentPane.add(lblFecha);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(102, 51, 61, 20);
		contentPane.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(102, 76, 183, 20);
		contentPane.add(txtNombre);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(102, 101, 114, 20);
		contentPane.add(txtDNI);
		
		dcFechaNac = new JDateChooser();
		dcFechaNac.setBounds(102, 127, 138, 20);
		contentPane.add(dcFechaNac);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(312, 79, 69, 14);
		contentPane.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(373, 77, 172, 20);
		contentPane.add(txtApellido);
		
		lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEquipo.setBounds(312, 104, 69, 14);
		contentPane.add(lblEquipo);
		
		lblSueldo = new JLabel("Sueldo");
		lblSueldo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSueldo.setBounds(312, 130, 69, 14);
		contentPane.add(lblSueldo);
		
		cboEquipos = new JComboBox();
		cboEquipos.setBounds(373, 101, 147, 22);
		contentPane.add(cboEquipos);
		
		txtSueldo = new JTextField();
		txtSueldo.setColumns(10);
		txtSueldo.setBounds(373, 128, 114, 20);
		contentPane.add(txtSueldo);
		
		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(FrmMntnJugador.class.getResource("/img/nuevo.png")));
		btnNuevo.addActionListener(this);
		btnNuevo.setBounds(48, 450, 53, 53);
		contentPane.add(btnNuevo);
		
		btnRegistrar = new JButton("");
		btnRegistrar.setIcon(new ImageIcon(FrmMntnJugador.class.getResource("/img/abrir.png")));
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(548, 450, 53, 53);
		contentPane.add(btnRegistrar);
		
		btnActualizar = new JButton("");
		btnActualizar.setIcon(new ImageIcon(FrmMntnJugador.class.getResource("/img/update.png")));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(611, 450, 53, 53);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(FrmMntnJugador.class.getResource("/img/eliminar.png")));
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(674, 450, 53, 53);
		contentPane.add(btnEliminar);
		//columnas
		model.addColumn("Id Jugador");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("DNI");
		model.addColumn("Fecha Nac.");
		model.addColumn("Sueldo");
		model.addColumn("Equipo");
		
		panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setForeground(new Color(70, 130, 180));
		panel.setBounds(0, 0, 768, 33);
		contentPane.add(panel);
		
		lblTitulo = new JLabel("Mantenimiento de Jugadores");
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Candara", Font.BOLD, 21));
		panel.add(lblTitulo);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmMntnJugador.class.getResource("/img/football-penguin.png")));
		lblNewLabel.setBounds(516, 23, 350, 312);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 209, 616, 214);
		contentPane.add(scrollPane);
		
		tblJugadores = new JTable();
		scrollPane.setViewportView(tblJugadores);
		tblJugadores.addKeyListener(this);
		tblJugadores.addMouseListener(this);
		tblJugadores.setFillsViewportHeight(true);
		//Asociar table con objeto model
		tblJugadores.setModel(model);
		
		lblErrorCodigo = new JLabel("*");
		lblErrorCodigo.setForeground(new Color(165, 42, 42));
		lblErrorCodigo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblErrorCodigo.setBounds(170, 55, 46, 14);
		contentPane.add(lblErrorCodigo);
		
		lblErrorNombre = new JLabel("*");
		lblErrorNombre.setForeground(new Color(165, 42, 42));
		lblErrorNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblErrorNombre.setBounds(290, 80, 9, 14);
		contentPane.add(lblErrorNombre);
		
		lblErrorDNI = new JLabel("*");
		lblErrorDNI.setForeground(new Color(165, 42, 42));
		lblErrorDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblErrorDNI.setBounds(226, 105, 9, 14);
		contentPane.add(lblErrorDNI);
		
		lblErrorFecha = new JLabel("*");
		lblErrorFecha.setForeground(new Color(165, 42, 42));
		lblErrorFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblErrorFecha.setBounds(246, 131, 9, 14);
		contentPane.add(lblErrorFecha);
		
		lblErrorApellido = new JLabel("*");
		lblErrorApellido.setForeground(new Color(165, 42, 42));
		lblErrorApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblErrorApellido.setBounds(555, 78, 9, 14);
		contentPane.add(lblErrorApellido);
		
		lblErrorEquipo = new JLabel("*");
		lblErrorEquipo.setForeground(new Color(165, 42, 42));
		lblErrorEquipo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblErrorEquipo.setBounds(529, 105, 9, 14);
		contentPane.add(lblErrorEquipo);
		
		lblErrorSueldo = new JLabel("*");
		lblErrorSueldo.setForeground(new Color(165, 42, 42));
		lblErrorSueldo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblErrorSueldo.setBounds(497, 131, 9, 14);
		contentPane.add(lblErrorSueldo);
		
		//ocultar los lblError 
		lblErrorCodigo.setVisible(false);
		lblErrorNombre.setVisible(false);
		lblErrorApellido.setVisible(false);
		lblErrorDNI.setVisible(false);
		lblErrorFecha.setVisible(false);
		lblErrorSueldo.setVisible(false);
		lblErrorEquipo.setVisible(false);
		
		txtCodigo.setEditable(false);
		//cargar data de la tabla jugadores
		cargarDataJugadores();
		// cargar data desde la bd a el cbobox
		cargarDataCombobox();
		
	}

		
		
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizar(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrar(e);
		}
		if (e.getSource() == btnNuevo) {
			actionPerformedBtnNuevo(e);
		}
	}
	protected void actionPerformedBtnNuevo(ActionEvent e) {
		txtCodigo.setEditable(true);
		limpiarInputs();
	}
	protected void actionPerformedBtnRegistrar(ActionEvent e) {
      registrarJugador();
      
	}
	protected void actionPerformedBtnActualizar(ActionEvent e) {
		actualizarJugador();
		limpiarInputs();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		eliminarJugador();
		limpiarInputs();
	}
	
	private void limpiarInputs() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtDNI.setText("");
		dcFechaNac.setCalendar(null);
		txtSueldo.setText("");
		cboEquipos.setSelectedIndex(0);
		lblErrorCodigo.setVisible(false);
		lblErrorNombre.setVisible(false);
		lblErrorApellido.setVisible(false);
		lblErrorDNI.setVisible(false);
		lblErrorEquipo.setVisible(false);
		lblErrorFecha.setVisible(false);
		lblErrorSueldo.setVisible(false);
		txtCodigo.requestFocus();
		
	}


	private void registrarJugador() {
		String  nom,ape, dni, fecNac, nomEquipo;
		int cod,equipo;
		double sueldo;
		
		try {
			cod  = leerCodigo();
			nom = leerNombre();
			ape = leerApellido();
			dni  = leerDni();
			fecNac = leerFecNac();
			sueldo = leerSueldo();
			equipo = leerEquipo();
			nomEquipo = leerNombreEquipo();

			//validaci�n
			if (cod == -1 || nom == null || ape== null|| dni == null ||nomEquipo == null ||fecNac == null || sueldo == -1 ) {
				return;  //retorna al proceso de ingresar datos nuevamente
				
			}else {
				//Paso 1 : Crear un objeto de la clase jugador 
				Jugador j = new Jugador();
				//Paso 2: setear --> asignar los valores obtenidos desde la GUI a los atributos privados
						j.setIdjugador(cod);
						j.setNombre(nom); 
						j.setApellido(ape);
						j.setDni(dni);
						j.setFechaNacimiento(fecNac);
						j.setSueldo(sueldo);
						j.setIdequipo(equipo);
			
				//Paso 3 : Llamar al proceso de registro 
				int res = gJug.registrarJugador(j);
				//Validar el resultado del proceso de registro
				if(res == 0) {
					Alertas.mensajeError(":( Hubo un error en el registro");
				}else {
					Alertas.mensajeExitoso("Jugador REGISTRADO con �xito !");
					cargarDataJugadores(); //cargar datos a la tabla de jugadores
					lblErrorCodigo.setVisible(false);
					lblErrorNombre.setVisible(false);
					lblErrorApellido.setVisible(false);
					lblErrorDNI.setVisible(false);
					lblErrorEquipo.setVisible(false);
					lblErrorFecha.setVisible(false);
					lblErrorSueldo.setVisible(false);
				}
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
	}

	private String leerNombreEquipo() {
		if(leerEquipo() == 0) {
			Alertas.mensajeError("Seleccionar un equipo");
			lblErrorEquipo.setVisible(true);
		}else {
			lblErrorEquipo.setVisible(false);
			return cboEquipos.getSelectedItem().toString();
			
		}
		return null;
	}

	private double leerSueldo() {
		double sueldo = -1;
		if(txtSueldo.getText().trim().length()== 0) {
			Alertas.mensajeError("Por favor ingresar sueldo del jugador");
			lblErrorSueldo.setVisible(true);
			txtSueldo.setText("");
			txtSueldo.requestFocus();
		}
		else {
			try {
				sueldo = Double.parseDouble(txtSueldo.getText());
				if (sueldo <=0) {
					Alertas.mensajeError("ingresar valores mayores a 0");
					lblErrorSueldo.setVisible(true);
					txtSueldo.setText("");
					txtSueldo.requestFocus();
					sueldo = -1;					
				}else {
					lblErrorSueldo.setVisible(false);
				}
			} catch (NumberFormatException e) {	
				Alertas.mensajeError("ingresar valores enteros");
				lblErrorSueldo.setVisible(true);
				txtSueldo.setText("");
				txtSueldo.requestFocus();
			}
		}
		return sueldo; 
	}

	private int leerEquipo() {
		return cboEquipos.getSelectedIndex();
	}

	private String leerFecNac() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = null;
		try {
			if (sdf.format(dcFechaNac.getDate()).toString().length() == 0) {
				Alertas.mensajeError("Por favor seleccionar una fecha de nacimiento");
				lblErrorFecha.setVisible(true);
			} else {
				fecha = sdf.format(dcFechaNac.getDate()).toString();
				lblErrorFecha.setVisible(false);
			}
		} catch (Exception e) {
			Alertas.mensajeError("Por favor seleccionar una fecha de nacimiento");
			lblErrorFecha.setVisible(true);
		}	
		return fecha;
	}

	private String leerDni() {
		String dni = null;
		//campo vacio - validacion
				if ( txtDNI.getText().trim().length() == 0) {
					Alertas.mensajeError("Por favor ingresar el dni del jugador");
					lblErrorDNI.setVisible(true);
					txtDNI.setText("");
					txtCodigo.requestFocus();
				//8 digitos
				} else if(txtDNI.getText().trim().matches(Validaciones.DNI_JUGADOR)){
					dni= txtDNI.getText().trim();	
					lblErrorDNI.setVisible(false);
				}else {
					Alertas.mensajeError("Formato incorrecto, ingrese 8 d�gitos(solo n�meros)");
					txtDNI.setText("");
					lblErrorDNI.setVisible(true);
					txtDNI.requestFocus();
				}
		return dni;
	}

	private String leerApellido() {
		String ape = null;
		if(txtApellido.getText().trim().length() == 0) {
			Alertas.mensajeError("Por favor ingresar  el apellido del jugador");
			lblErrorApellido.setVisible(true);
			txtApellido.requestFocus();
		}else if(txtApellido.getText().trim().matches(Validaciones.APE_JUGADOR)) {
			ape = txtApellido.getText().trim();
			lblErrorApellido.setVisible(false);
		}else {
			Alertas.mensajeError("Formato incorrecto, ingresar de 2 a 30 letras");
			lblErrorApellido.setVisible(true);
			txtApellido.setText("");
			txtApellido.requestFocus();
		}
		return ape;
	}

	private String leerNombre() {
		String nom = null;
		if(txtNombre.getText().trim().length() == 0) {
			Alertas.mensajeError("Por favor ingresar el nombre del jugador");
			txtNombre.requestFocus();
			lblErrorNombre.setVisible(true);
		}else if(txtNombre.getText().trim().matches(Validaciones.NOM_JUGADOR)) {
			nom = txtNombre.getText().trim();
			lblErrorNombre.setVisible(false);
		}else {
			Alertas.mensajeError("Formato incorrecto, ingresar de 2 a 30 letras");
			lblErrorNombre.setVisible(true);
			txtNombre.setText("");
			txtNombre.requestFocus();
		}
		return nom;
	}

	private int leerCodigo() {
		int cod = -1;
		if(txtCodigo.getText().trim().length() == 0) {
			Alertas.mensajeError("Por favor ingresar el codigo del jugador");
			lblErrorCodigo.setVisible(true);
			txtCodigo.setText("");
			txtCodigo.requestFocus();
		} else {
			try {
				cod = Integer.parseInt(txtCodigo.getText());
				if (cod <=0) {
					Alertas.mensajeError("Ingresar valores mayores a 0");
					lblErrorCodigo.setVisible(true);
					txtCodigo.setText("");
					txtCodigo.requestFocus();
					cod = -1; 
					
				}else {
					lblErrorCodigo.setVisible(false);
				}
			} catch (NumberFormatException e) {
				Alertas.mensajeError("Ingresar valores enteros");
				lblErrorCodigo.setVisible(true);
				txtCodigo.setText("");
				txtCodigo.requestFocus();			
			}
		}	
		return cod;
	} 
	
	
	private void actualizarJugador() {
		String  nom,ape, dni, fecNac, nomEquipo;
		int cod,equipo;
		double sueldo;
		

		cod  = leerCodigo();
		nom = leerNombre();
		ape = leerApellido();
		dni  = leerDni();
		fecNac = leerFecNac();
		sueldo = leerSueldo();
		equipo = leerEquipo();
		nomEquipo = leerNombreEquipo();

		//validaci�n
		if (cod == -1 || nom == null || ape== null|| dni == null ||fecNac == null || sueldo == -1 ) {
			return;  
		}else {
			//Paso 1 : Crear un objeto de la clase jugador 
			Jugador j = new Jugador();
			//Paso 2: setear --> asignar los valores obtenidos desde la GUI a los atributos privados
					j.setIdjugador(cod);
					j.setNombre(nom); 
					j.setApellido(ape);
					j.setDni(dni);
					j.setFechaNacimiento(fecNac);
					j.setSueldo(sueldo);
					j.setIdequipo(equipo);
		
			//Paso 3 : Llamar al proceso de  actualizacion
			int res = gJug.actualizarJugador(j);
			//Validar el resultado del proceso de actualizacion
			if(res == 0) {
				Alertas.mensajeError(":( Hubo un error en la actualizacion");
			}else {
				Alertas.mensajeExitoso("Jugador ACTUALIZADO con �xito !");
				cargarDataJugadores(); //cargar datos a la tabla de jugadores
			}
		
		}
	}

	
	private void eliminarJugador() {
		
		
		int  cod, opcion;
		// 1. Obtener el codigo ingresado
			cod = leerCodigo();
			//validacion
			if(cod == -1) {
				return;
			}else {
				// Mensaje de Confirmacion
				opcion = JOptionPane.showConfirmDialog(this, "...Seguro de eliminar ?", "Sistema", JOptionPane.YES_NO_OPTION);
				if(opcion == 0) { // SI
					//Ejecutar el proceso de tipo int
					int ok = gJug.eliminarJugador(cod);
					// Validar el resultado del proceso
					if(ok == 0) {
						Alertas.mensajeError("Este Jugador no existe en el registro");
					}else {
						Alertas.mensajeExitoso("Jugador ELIMINADO");
						cargarDataJugadores();
					}
				}
			}
	}

	//metodo encargado de cargar los datos a la tabla
	private void cargarDataJugadores(){
		//PASO 1 : Limpiar la tabla
		model.setRowCount(0);
		//PASO 2 : Obtener el resultado
		ArrayList<Jugador> listadoJugadores = gJug.listarJugadores();
		//PASO 3 : bucle para el recorrido
		for( Jugador j : listadoJugadores) {
			Object fila [] = {	j.getIdjugador(),
								j.getNombre(),
								j.getApellido(),
								j.getDni(),
								j.getFechaNacimiento(),
								j.getSueldo(),
								j.getIdequipo()
							};
			//a�adir fila a la tabla
			model.addRow(fila);
		}		
	}
	
	//Metodo cargar data al cbo
	private void cargarDataCombobox() {
		// 1. Obtener el resultado del proceso -- listar
			ArrayList<Equipo> listadoEq = gEq.listarEquipos();
		// 2. Validar el resultado del proceso
			if(listadoEq.size() == 0) {
					Alertas.mensajeError("Lista vacia");
				} else {
					cboEquipos.addItem("Seleccione ...");
					for(Equipo eq : listadoEq) {
						cboEquipos.addItem(eq.getIdequipo()); //Para que pueda jalar los datos al cboEdquipos desde el tblJugadores con el evento MouseClicked.
						//cboEquipos.addItem(eq.getIdequipo() + " " + eq.getNombre());
					}
				}
	}
	
	
	//M�todo para mostrar la info de la table en las cajas de texto
	private void mostrarData(int fila) {
	   if(fila != -1) { //para error fuera de la tabla, los errores dentro de java se controlan con -1 (usualmente)
	// declarar variables donde voy a almacenar la info
		String cod, nom, ape, dni,fecNac, sueldo;
		int equipo;
		// PASO 1 : Obtener los datos de la tabla
		//getValueAt(primer parametro: fila, de donde saco la info : columa)
			cod = tblJugadores.getValueAt(fila, 0).toString();
			nom = tblJugadores.getValueAt(fila, 1).toString();
			ape = tblJugadores.getValueAt(fila, 2).toString();
			dni = tblJugadores.getValueAt(fila, 3).toString();
			fecNac = tblJugadores.getValueAt(fila, 4).toString();
			sueldo = tblJugadores.getValueAt(fila, 5).toString();
			equipo = (int) tblJugadores.getValueAt(fila, 6);
		    // PASO 2 : mostrar los datos obtenido en las cajas de texto
			txtCodigo.setText(cod);
			txtNombre.setText(nom);
			txtApellido.setText(ape);
			txtDNI.setText(dni);
			try {
				dcFechaNac.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(fecNac));
			} catch (ParseException e) {
				System.out.println("Error en el formato de la fecha");
			}
			txtSueldo.setText(sueldo);
			cboEquipos.getModel().setSelectedItem(equipo);
		  }
		}
	
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblJugadores) {
			mouseClickedTblJugadores(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTblJugadores(MouseEvent e) {
		int fila;
		//obtener el valor de la fila seleccionada
		fila = tblJugadores.getSelectedRow();
		//mostrar data
		mostrarData(fila);
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getSource() == tblJugadores) {
			keyReleasedTblJugadores(e);
		}
	}
	public void keyTyped(KeyEvent e) {
	}
	protected void keyReleasedTblJugadores(KeyEvent e) {
		int fila;
		//obtener el valor de la fila seleccionada
		fila = tblJugadores.getSelectedRow();
		//mostrar data
		mostrarData(fila);
	}
}
