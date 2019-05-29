package programaGestion;

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
import javax.swing.JTextField;

public class OlvideMiContrasena extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	
	OlvideIncorrecto olvideincorrecto=new OlvideIncorrecto();
	
	JLabel lblCorreo = new JLabel("Introduce tu correo electronico:");
	JTextField txtCorreo=new JTextField(10);
	JButton btnAceptar= new JButton("Aceptar");
	
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
				Object a;
				a=e.getSource();
				if(a.equals(btnAceptar)) {
					String correo=txtCorreo.getText();
					if (correo.equalsIgnoreCase("prueba@gmail.com")) {
						setVisible(false);
						new OlvideCorrecto();
					}else {
						olvideincorrecto.setVisible(true);
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
