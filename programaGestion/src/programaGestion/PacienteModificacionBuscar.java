package programaGestion;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PacienteModificacionBuscar extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	PacienteModificacion pacientemodificacion=new PacienteModificacion(); 

	JLabel lblBuscar =new JLabel("Buscar:");
	JTextField txtBuscar=new JTextField(20);
	JButton btnBuscar=new JButton("Buscar");
	static List lista=new List(6, false);
	JButton btnModificar=new JButton ("Modificar");

	//CONECTAR CON BASE DE DATOS----------------------para utilizar por otra base de datos sustituir empresa
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hospital?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;

	JPanel pnlSup = new JPanel();
	JPanel pnlCent = new JPanel();
	JPanel pnlInf = new JPanel();
	
	static String nombre="";
	static String ape1="";
	static String ape2="";
	static String id="";
	

	public PacienteModificacionBuscar() {
		addWindowListener(this);
		setTitle ("Modificacion Paciente");
		setSize(300,400);
		
		String cadena="";

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
		cadena= ("SELECT * FROM pacientes;");

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
			rs= statement.executeQuery(cadena);

			while (rs.next())
			{

				lista.add(rs.getString("idPaciente")+" "+rs.getString("nombrePaciente")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));

			}
			
			System.out.println("Consulta Correcta");
			Log.mov("","Consulta",cadena);
		}
		catch(SQLException arg0)
		{
			System.out.println("Error en la sentencia SQL");
		}


		pnlSup.setLayout(new GridLayout(4,1));
		pnlSup.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(0);
		JPanel pnlSupSup =new JPanel();
		pnlSupSup.add(txtBuscar);
		pnlSup.add(pnlSupSup);
		JPanel pnlSupBuscar =new JPanel();
		pnlSupBuscar.add(btnBuscar);
		pnlSup.add(pnlSupBuscar);

		pnlCent.setLayout(new GridLayout(1,1));
		pnlCent.add(lista);

		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnModificar);

		add(pnlSup,"North");
		add(pnlCent,"Center");
		add(pnlInf,"South");

		setLocationRelativeTo(null);
		setLocation(480, 200);
		//setVisible(true);

		btnModificar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnModificar)) {
					
					String select = lista.getSelectedItem();
					String[] select_splited = select.split(" ");
					id = select_splited[0];
					nombre = select_splited[1];
					ape1 = select_splited[2];
					ape2 = select_splited[3];
					
					PacienteModificacion.txtNombre.setText(nombre);
					PacienteModificacion.txtApe1.setText(ape1);
					PacienteModificacion.txtApe2.setText(ape2);
					
					pacientemodificacion.setVisible(true);
				}
			}
		});

		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnBuscar)) {
					String busqueda=txtBuscar.getText();
					String cadena="SELECT nombrePaciente, apellido1, apellido2 FROM pacientes WHERE nombrePaciente LIKE '%"+busqueda+"%' OR apellido1 LIKE '%"+busqueda+"%' OR apellido2 LIKE '%"+busqueda+"%'";
					
					try
					{
						statement=connection.createStatement();
						rs= statement.executeQuery(cadena);
						
						lista.removeAll();

						while (rs.next())
						{

							lista.add(rs.getString("nombrePaciente")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));

						}
						
						System.out.println("Consulta Correcta");
						Log.mov("","Consulta",cadena);
					}
					catch(SQLException arg0)
					{
						System.out.println("Error en la sentencia SQL");
					}
				}
			}
		});
		
	}

	public static void main(String[] args)
	{
		new PacienteModificacionBuscar();

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
