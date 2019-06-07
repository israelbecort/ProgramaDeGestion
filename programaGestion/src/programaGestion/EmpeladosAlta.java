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

public class EmpeladosAlta extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	PacienteAltaErrorNombre pacientealtaerrornombre =new PacienteAltaErrorNombre();
	PacienteAltaErrorApe1 pacientealtaerrorape1= new PacienteAltaErrorApe1();
	PacienteAltaErrorApe2 pacientealtaerrorape2= new PacienteAltaErrorApe2();

	JLabel lblNombre = new JLabel("Nombre Empleado:");
	JTextField txtNombre = new JTextField(20);
	JLabel lblApe1 = new JLabel("Primer Apellido:");
	JTextField txtApe1= new JTextField(20);
	JLabel lblApe2=new JLabel("Segundo apellido:");
	JTextField txtApe2=new JTextField(20);
	JButton btnAlta = new JButton("Aceptar");
	JButton btnLimpiar = new JButton("Limpiar");

	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();

	//CONECTAR CON BASE DE DATOS----------------------para utilizar por otra base de datos sustituir empresa
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hospital?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;

	public EmpeladosAlta(){
		addWindowListener(this);
		setTitle ("Alta Empleado");
		setSize(350,300);
		//setVisible(true);

		pnlSup.setLayout(new GridLayout(6,1));
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
		pnlInf.add(btnAlta);
		pnlInf.add(btnLimpiar);

		add(pnlSup,"North");
		add(pnlInf,"South");

		setLocationRelativeTo(null);
		setLocation(480, 200);

		btnLimpiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtApe1.setText("");
				txtApe2.setText("");
			}
		});
		btnAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnAlta)) {
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
						rs=statement.executeQuery("SELECT * FROM empleados;");
						
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
						String cadena= ("INSERT INTO empleados (nombreEmpleado, apellido1, apellido2) VALUES ('"+nombre+"','"+apellido1+"','"+apellido2+"');");
						
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
							statement=connection.createStatement();
							statement.executeUpdate(cadena);
							if (rs.next())
							{
								System.out.println("Alta Correcta");
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
							String cadena1="SELECT * FROM empleados";
							
							statement=connection.createStatement();
							rs= statement.executeQuery(cadena1);
							
							EmpleadosModificacionBuscar.lista.removeAll();
							EmpleadosConsultaBuscar.lista.removeAll();
							EmpleadosBaja.lista.removeAll();

							while (rs.next())
							{

								EmpleadosModificacionBuscar.lista.add(rs.getString("idEmpleado")+" "+rs.getString("nombreEmpleado")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));
								EmpleadosConsultaBuscar.lista.add(rs.getString("idEmpleado")+" "+rs.getString("nombreEmpleado")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));
								EmpleadosBaja.lista.add(rs.getString("idEmpleado")+" "+rs.getString("nombreEmpleado")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));
							}
							
							System.out.println("Consulta Correcta");
							Log.mov("","Consulta",cadena1);
						}
						catch(SQLException arg0)
						{
							System.out.println("Error en la sentencia SQL");
						}
						setVisible(false);
						txtNombre.setText("");
						txtApe1.setText("");
						txtApe2.setText("");
						new PacienteAltaCorrecto();
					}
				}
			}
		});
	}
	public static void main(String[] args)
	{
		new EmpeladosAlta();

	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub

	}
	@Override
	public void windowActivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}
	@Override
	public void windowClosed(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}
	@Override
	public void windowClosing(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}
	@Override
	public void windowDeactivated(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}
	@Override
	public void windowDeiconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}
	@Override
	public void windowIconified(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}
	@Override
	public void windowOpened(WindowEvent arg0)
	{
		// TODO Auto-generated method stub

	}

}
