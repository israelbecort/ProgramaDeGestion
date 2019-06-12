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

public class CamasBaja extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	JLabel lblBuscar =new JLabel("Buscar:");
	JTextField txtBuscar=new JTextField(20);
	JButton btnBuscar=new JButton("Buscar");
	static List lista=new List(6, false);
	JButton btnBaja=new JButton ("Dar de baja");

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
	
	static String id="";
	static String numC="";
	static String idPac="";
	static String idEdf="";

	public CamasBaja() {
		addWindowListener(this);
		setTitle ("Dar de baja Cita");
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
		cadena= ("SELECT * FROM camas;");

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

				lista.add(rs.getString("idcama")+" "+rs.getString("numCama")+" "+rs.getString("idPacienteFK")+" "+rs.getString("idEdificioFK"));

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
		pnlInf.add(btnBaja);

		add(pnlSup,"North");
		add(pnlCent,"Center");
		add(pnlInf,"South");

		setLocationRelativeTo(null);
		setLocation(480, 200);
		//setVisible(true);

		btnBaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnBaja)) {
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int dialogResult = JOptionPane.showConfirmDialog (null, "¿Estás seguro de borrar a esta cama?","Warning",dialogButton);
					
					if(dialogResult == JOptionPane.YES_OPTION){
						String select = lista.getSelectedItem();
						String[] select_splited = select.split(" ");
						id = select_splited[0];
						numC = select_splited[1];
						idPac = select_splited[2];
						idEdf = select_splited[3];

						//Baja paciente
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
							rs=statement.executeQuery("SELECT * FROM camas;");

						}
						catch(SQLException arg0)
						{
							System.out.println("Error en la sentencia SQL");
						}
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
							String cadena= ("DELETE FROM camas WHERE numCama='"+numC+"' AND idPacienteFK='"+idPac+"' AND idEdificioFK='"+idEdf+"';");

							statement=connection.createStatement();
							statement.executeUpdate(cadena);

							if (rs.next())
							{
								System.out.println("Baja Correcta");

								Log.mov("","Baja",cadena);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Error: Datos no validos ","Baja Incorrecta",JOptionPane.WARNING_MESSAGE);
								System.out.println("Baja Incorrecta");
								Log.mov("","ERROR Baja",cadena);
							}
						}
						catch(SQLException arg0)
						{
							System.out.println("Error en la sentencia SQL 2");
						}
						try
						{
							String cadena="SELECT * FROM camas";

							statement=connection.createStatement();
							rs= statement.executeQuery(cadena);

							CamasModificacionBuscar.lista.removeAll();
							CamasConsultaBuscar.lista.removeAll();
							lista.removeAll();

							while (rs.next())
							{

								CamasModificacionBuscar.lista.add(rs.getString("idCama")+" "+rs.getString("numCama")+" "+rs.getString("idPacienteFK")+" "+rs.getString("idEdificioFK"));
								CamasConsultaBuscar.lista.add(rs.getString("idCama")+" "+rs.getString("numCama")+" "+rs.getString("idPacienteFK")+" "+rs.getString("idEdificioFK"));
								lista.add(rs.getString("idCama")+" "+rs.getString("numCama")+" "+rs.getString("idPacienteFK")+" "+rs.getString("idEdificioFK"));

							}

							System.out.println("Consulta Correcta");
							Log.mov("","Consulta",cadena);
						}
						catch(SQLException arg0)
						{
							System.out.println("Error en la sentencia SQL 3");
						}
					}
				}
			}
		});
	}

	public static void main(String[] args)
	{
		new CamasBaja();

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
