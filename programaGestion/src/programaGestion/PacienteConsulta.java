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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PacienteConsulta extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	PacienteConsultar pacienteconsultar=new PacienteConsultar(); 

	static List lista=new List(4, false);
	JButton btnConsulta=new JButton ("Consulta");

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

	public PacienteConsulta() {
		addWindowListener(this);
		setTitle ("Consulta paciente");
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

		pnlCent.setLayout(new GridLayout(1,1));
		pnlCent.add(lista);

		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnConsulta);

		add(pnlCent,"Center");
		add(pnlInf,"South");

		setLocationRelativeTo(null);
		setLocation(480, 200);
		//setVisible(true);

		btnConsulta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnConsulta)) {
					
					String select = lista.getSelectedItem();
					String[] select_splited = select.split(" ");
					String nombre = select_splited[1];
					String ape1 = select_splited[2];
					String ape2 = select_splited[3];
					
					PacienteConsultar.txtNombre.setText(nombre);
					PacienteConsultar.txtApe1.setText(ape1);
					PacienteConsultar.txtApe2.setText(ape2);
					
					pacienteconsultar.setVisible(true);
				}
			}
		});
	}
	public static void main(String[] args)
	{
		new PacienteConsulta();

	}
	@Override
	public void actionPerformed(ActionEvent arg0)
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
