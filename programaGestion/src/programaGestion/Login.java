package programaGestion;

import java.awt.Button;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	//Principal pantallaPrin = new Principal();
	LoginError loginerror=new LoginError();
	
	JLabel lblUsuario = new JLabel("Usuario:");
	JTextField txtUsuario = new JTextField(10);
	JLabel lblContrasena = new JLabel("Contraseña:");
	JPasswordField txtContrasena= new JPasswordField(10);
	JButton btnLogin = new JButton("Login");
	JButton btnLimpiar = new JButton("Limpiar");
	Button btnOlvide =new Button("Olvidé mi contraseña");
	
	//CONECTAR CON BASE DE DATOS----------------------para utilizar por otra base de datos sustituir empresa
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hospital?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	//paneles
	JPanel pnlSup =new JPanel();
	JPanel pnlCent =new JPanel();
	JPanel pnlInf =new JPanel();
	
	
	public Login(){
		addWindowListener(this);
		setTitle ("Login");
		setSize(300,220);
		setVisible(true); 
		
		pnlSup.setLayout(new GridLayout(4,2));
		pnlSup.add(lblUsuario);
		lblUsuario.setHorizontalAlignment(0);
		JPanel pnlSupSup =new JPanel();
		pnlSupSup.add(txtUsuario);
		pnlSup.add(pnlSupSup);
		
		pnlSup.add(lblContrasena);
		lblContrasena.setHorizontalAlignment(0);
		JPanel pnlCent2=new JPanel();
		pnlCent2.add(txtContrasena);
		pnlSup.add(pnlCent2);
		
		pnlCent.setLayout(new FlowLayout());
		pnlCent.add(btnLogin);
		pnlCent.add(btnLimpiar);
		
		pnlInf.setLayout(new GridLayout(1,1));
		pnlInf.add(btnOlvide);
		
		add(pnlSup,"North");
		add(pnlCent,"Center");
		add(pnlInf,"South");
		
		setLocationRelativeTo(null);
		setLocation(480, 200);
		
		//Limpiar todo
		btnLimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtUsuario.setText("");
				txtContrasena.setText("");
			}
		});
		
		//boton Login
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent b) {
				
				String usuario = "";
				String pass = "";
				
				Object a;
				a=b.getSource();
				if(a.equals(btnLogin))
				{
					//ESTABLECER CONEXION CON BASE DE DATOS
					try
					{
						connection = DriverManager.getConnection(url, login, password);
					}
					catch(SQLException e)
					{
						System.out.println("Se produjo un error al conectar a la Base de Datos");
					}
					try
					{
						char[] arrayC=txtContrasena.getPassword();
						String clave=new String (arrayC);
						String cadena ="SELECT * FROM usuarios WHERE nombreUsuario = '"+txtUsuario.getText()+"' AND contrasenaUsuario = MD5('"+clave+"');";
						
						statement=connection.createStatement();
						rs=statement.executeQuery(cadena);
						
						while (rs.next())
						{
							usuario = rs.getString("nombreUsuario");
							pass = rs.getString("contrasenaUsuario");
						}
					}
					catch(SQLException e)
					{
						System.out.println("Error en la sentencia SQL");
					}
					
					if(usuario.equalsIgnoreCase("Administrador")&& pass.equals(pass)) 
					{

						JOptionPane.showMessageDialog(null, "Login realizado correctamente.", "Login Correcto", JOptionPane.INFORMATION_MESSAGE);
						Principal pantallaPri = new Principal();
						pantallaPri.setVisible(true);
						Log.mov(usuario,"Login","");
						setVisible(false);

					} 
					else if (txtUsuario.getText().equalsIgnoreCase("")&& txtContrasena.getText().equals("")){
						{
							JOptionPane.showMessageDialog(null, "Error: Usuario o contraseña no validas ","Login Incorrecto",JOptionPane.WARNING_MESSAGE);
							Log.mov(usuario,"Login ERROR","");
							System.out.println("Login Incorrecto");
						}
					}
					else if (usuario.equalsIgnoreCase(txtUsuario.getText())&& pass.equals(pass)){
						{
							JOptionPane.showMessageDialog(null, "Login realizado correctamente.", "Login Correcto", JOptionPane.INFORMATION_MESSAGE);
							PrincipalUsuario pantallaUsu = new PrincipalUsuario();
							pantallaUsu.setVisible(true);
							Log.mov(usuario,"Login","");
							setVisible(false);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Error: Usuario o contraseña no validas ","Login Incorrecto",JOptionPane.WARNING_MESSAGE);
						Log.mov(usuario,"Login ERROR","");
						System.out.println("Login Incorrecto");
					}
				}
			}	
		});
		
		
		//boton olvide mi contraseña
		
		btnOlvide.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OlvideMiContrasena();
			}
		});
		
	}
	public static void main(String[] args)
	{
		new Login();

	}
	@Override
	public void actionPerformed(ActionEvent e)
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
		//cerrar los elementos de la base de datos
				System.exit(0);
		
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
