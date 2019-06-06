package programaGestion;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PacienteModificacion extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	PacienteAltaErrorNombre pacientealtaerrornombre =new PacienteAltaErrorNombre();
	PacienteAltaErrorApe1 pacientealtaerrorape1= new PacienteAltaErrorApe1();
	PacienteAltaErrorApe2 pacientealtaerrorape2= new PacienteAltaErrorApe2();

	JLabel lblNombre = new JLabel("Nombre:");
	static JTextField txtNombre = new JTextField(10);
	JLabel lblApe1 = new JLabel("Primer apellido:");
	static JTextField txtApe1= new JTextField(10);
	JLabel lblApe2=new JLabel("Segundo apellido:");
	static JTextField txtApe2=new JTextField(10);
	static JButton btnAceptar = new JButton("Aceptar Cambios");
	JButton btnReset = new JButton("Resetear");
	
	//CONECTAR CON BASE DE DATOS----------------------para utilizar por otra base de datos sustituir empresa
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hospital?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;

	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();


	public PacienteModificacion(){

		addWindowListener(this);
		setTitle ("Modificar Paciente");
		setSize(300,190);
		//setVisible(true);

		pnlSup.setLayout(new GridLayout(4,2));
		pnlSup.add(lblNombre);
		lblNombre.setHorizontalAlignment(0);
		JPanel pnlSupSup =new JPanel();
		pnlSupSup.add(txtNombre);
		pnlSup.add(pnlSupSup);

		pnlSup.add(lblApe1);
		lblApe1.setHorizontalAlignment(0);
		JPanel pnlCent2=new JPanel();
		pnlCent2.add(txtApe1);
		pnlSup.add(pnlCent2);

		pnlSup.add(lblApe2);
		lblApe2.setHorizontalAlignment(0);
		JPanel pnlCent3=new JPanel();
		pnlCent3.add(txtApe2);
		pnlSup.add(pnlCent3);

		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnAceptar);
		pnlInf.add(btnReset);

		add(pnlSup,"North");
		add(pnlInf,"South");


		//		txtNombre.setText("Juan");
		//		txtApe1.setText("Gonzalez");
		//		txtApe2.setText("Martinez");

		setLocationRelativeTo(null);
		setLocation(480, 200);

		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if (a.equals(btnReset)){

					txtNombre.setText(PacienteModificacionBuscar.nombre);
					txtApe1.setText(PacienteModificacionBuscar.ape1);
					txtApe2.setText(PacienteModificacionBuscar.ape2);
				}
			}
		});
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnAceptar)) {
					String nombre =txtNombre.getText();
					String apellido1 = txtApe1.getText();
					String apellido2 = txtApe2.getText();
					
					//ESTABLECER CONEXION CON BASE DE DATOS
					try
					{
						connection = DriverManager.getConnection(url, login, password);
					}
					catch(SQLException arg0)
					{
						System.out.println("Se produjo un error al conectar a la Base de Datos");
					}
					//PREPARAR EL STATEMENT
					try
					{
						statement=connection.createStatement();
						rs=statement.executeQuery("SELECT * FROM pacientes;");
						
					}
					catch(SQLException arg0)
					{
						System.out.println("Error en la sentencia SQL");
					}
					
					if (nombre.equals("")) {
						pacientealtaerrornombre.setVisible(true);
					}else if(apellido1.equals("")){
						pacientealtaerrorape1.setVisible(true);
					}else if(apellido2.equals("")) {
						pacientealtaerrorape2.setVisible(true);
					}else {
						//CARGAR EL DRIVER
						try
						{
							Class.forName(driver);
						}
						catch(ClassNotFoundException arg0)
						{
							System.out.println("Se ha producido un error al cargar el Driver");
						}
						//PREPARAR EL STATEMENT
						try
						{
							String cadena= ("UPDATE pacientes SET nombrePaciente='"+nombre+"', apellido1='"+apellido1+"', apellido2='"+apellido2+"' WHERE nombrePaciente='"+
									PacienteModificacionBuscar.nombre+"' AND apellido1='"+PacienteModificacionBuscar.ape1+"' AND apellido2='"+PacienteModificacionBuscar.ape2+"';");
							
							statement=connection.createStatement();
							statement.executeUpdate(cadena);
	
							if (rs.next())
							{
								System.out.println("Modificacion Correcta");
								
								Log.mov("","Alta",cadena);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Error: Datos no validos ","Alta Incorrecta",JOptionPane.WARNING_MESSAGE);
								System.out.println("Alta Incorrecta");
								Log.mov("","ERROR Alta",cadena);
							}
						}
						catch(SQLException arg0)
						{
							System.out.println("Error en la sentencia SQL");
						}
						try
						{
							String cadena="SELECT * FROM pacientes";
							
							statement=connection.createStatement();
							rs= statement.executeQuery(cadena);
							
							PacienteModificacionBuscar.lista.removeAll();
							PacienteConsulta.lista.removeAll();
							PacienteBaja.lista.removeAll();

							while (rs.next())
							{

								PacienteModificacionBuscar.lista.add(rs.getString("idPaciente")+" "+rs.getString("nombrePaciente")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));
								PacienteConsulta.lista.add(rs.getString("idPaciente")+" "+rs.getString("nombrePaciente")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));
								PacienteBaja.lista.add(rs.getString("idPaciente")+" "+rs.getString("nombrePaciente")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));

							}
							
							System.out.println("Consulta Correcta");
							Log.mov("","Consulta",cadena);
						}
						catch(SQLException arg0)
						{
							System.out.println("Error en la sentencia SQL");
						}
						setVisible(false);
						

						new PacienteModCorrecto();
					}
				}
			}
		});
	}

	public static void main(String[] args)
	{
		new PacienteModificacion();

	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowActivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeactivated(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e)
	{
		// TODO Auto-generated method stub

	}

}
