package programaGestion;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
				Object a;
				a=b.getSource();
				if(a.equals(btnLogin)) {
					String usuario=txtUsuario.getText();
					char[] arrayC=txtContrasena.getPassword();
					String pass=new String (arrayC);
					if(usuario.equalsIgnoreCase("Administrador")&&pass.equals("Studium2018;")) {
						new Principal();
						setVisible(false);
					}else if (usuario.equalsIgnoreCase("Usuario")&&pass.equals("Studium2018;")) {
						new PrincipalUsuario();
						setVisible(false);
					}else {
						loginerror.setVisible(true);
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
