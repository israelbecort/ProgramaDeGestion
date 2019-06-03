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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OlvideMiContrasena extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	
	OlvideIncorrecto olvideincorrecto=new OlvideIncorrecto();
	
	JLabel lblCorreo = new JLabel("Introduce tu correo electronico:");
	JTextField txtCorreo=new JTextField(10);
	JButton btnAceptar= new JButton("Aceptar");
	
	//CONECTAR CON BASE DE DATOS----------------------para utilizar por otra base de datos sustituir empresa
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hospital?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	
	JPanel pnlSup = new JPanel();
	JPanel pnlInf = new JPanel();
	
	public OlvideMiContrasena() {
		addWindowListener(this);
		setTitle ("Olvidé mi contraseña");
		setSize(300,150);
		setVisible(true); 
		
		pnlSup.setLayout(new GridLayout(2,1));
		pnlSup.add(lblCorreo);
		lblCorreo.setHorizontalAlignment(0);
		JPanel pnlSupSup=new JPanel();
		pnlSupSup.add(txtCorreo);
		pnlSup.add(pnlSupSup);
		
		
		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnAceptar);
		
		add(pnlSup,"North");
		add(pnlInf,"South");
		
		setLocationRelativeTo(null);
		setLocation(500, 300);
		
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String email=null;
				
				Object a;
				a=e.getSource();
				if(a.equals(btnAceptar)) {
					String cadena ="SELECT * FROM usuarios WHERE correoElectronico = '"+txtCorreo.getText()+"';";
					
					//ESTABLECER CONEXION CON BASE DE DATOS
					try
					{
						connection = DriverManager.getConnection(url, login, password);
					}
					catch(SQLException arg0)
					{
						System.out.println("Se produjo un error al conectar a la Base de Datos");
					}
					try
					{
						
						statement=connection.createStatement();
						rs=statement.executeQuery(cadena);
						
						while (rs.next())
						{
							email = rs.getString("correoElectronico");
						}
					}
					catch(SQLException arg0)
					{
						System.out.println("Error en la sentencia SQL");
					}
					String correo=txtCorreo.getText();
					if (correo.equalsIgnoreCase(email)) {
						Log.mov("","Olvide mi contraseña",cadena);
						setVisible(false);
						new OlvideCorrecto();
					}else {
						olvideincorrecto.setVisible(true);
						Log.mov("","Olvide mi contraseña ERROR",cadena);
					}
				}
			}
		});
		}
	
	public static void main(String[] args)
	{
		new OlvideMiContrasena();

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
