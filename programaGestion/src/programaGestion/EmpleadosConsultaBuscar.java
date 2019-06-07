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

public class EmpleadosConsultaBuscar extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	EmpleadosConsulta servicioconsulta=new EmpleadosConsulta(); 

	static List lista=new List(6, false);
	JButton btnConsultar=new JButton ("Consulta");

	//CONECTAR CON BASE DE DATOS----------------------para utilizar por otra base de datos sustituir empresa
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hospital?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;

	JPanel pnlCent = new JPanel();
	JPanel pnlInf = new JPanel();

	public EmpleadosConsultaBuscar() {
		addWindowListener(this);
		setTitle ("Consulta Servicio");
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
			rs=statement.executeQuery("SELECT * FROM empleados;");

		}
		catch(SQLException arg0)
		{
			System.out.println("Error en la sentencia SQL");
		}
		cadena= ("SELECT * FROM empleados;");

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

				lista.add(rs.getString("idEmpleado")+" "+rs.getString("nombreEmpleado")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));

			}
			
			System.out.println("Consulta Correcta");
			Log.mov("","Consulta",cadena);
		}
		catch(SQLException arg0)
		{
			System.out.println("Error en la sentencia SQL");
		}

		pnlCent.setLayout(new GridLayout(1,1));
		pnlCent.add(lista);

		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnConsultar);

		add(pnlCent,"Center");
		add(pnlInf,"South");

		setLocationRelativeTo(null);
		setLocation(480, 200);
		//setVisible(true);

		btnConsultar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnConsultar)) {
					String select = lista.getSelectedItem();
					String[] select_splited = select.split(" ");
					String nombre = select_splited[1];
					String ape1 = select_splited[2];
					String ape2 = select_splited[3];
					
					EmpleadosConsulta.txtNombre.setText(nombre);
					EmpleadosConsulta.txtApe1.setText(ape1);
					EmpleadosConsulta.txtApe2.setText(ape2);
					servicioconsulta.setVisible(true);
				}
			}
		});
	}
	public static void main(String[] args)
	{
		new EmpleadosConsultaBuscar();
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
