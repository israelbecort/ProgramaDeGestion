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

public class CamasAltaErrorIdEdf extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	JLabel lblIncorrecto = new JLabel("El idEdificio no es válido. Introduzca un id válido.");
	JButton btnAceptar= new JButton("Aceptar");
	
	JPanel pnlSup = new JPanel();
	JPanel pnlInf = new JPanel();
	
	public CamasAltaErrorIdEdf() {
		addWindowListener(this);
		setTitle ("idEdificio incorrecto");
		setSize(320,100);
		
		
		pnlSup.setLayout(new GridLayout(2,1));
		pnlSup.add(lblIncorrecto);
		lblIncorrecto.setHorizontalAlignment(0);
		
		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnAceptar);
		
		add(pnlSup,"Center");
		add(pnlInf,"South");
		
		setLocationRelativeTo(null);
		setLocation(500, 300);
		
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
	public static void main(String[] args)
	{
		new CamasAltaErrorIdEdf();

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
