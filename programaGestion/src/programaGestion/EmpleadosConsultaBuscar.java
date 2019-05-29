package programaGestion;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EmpleadosConsultaBuscar extends JFrame implements WindowListener, ActionListener
{
private static final long serialVersionUID = 1L;
	
	EmpleadosConsulta servicioconsulta=new EmpleadosConsulta(); 
	
	List lista=new List(6, false);
	JButton btnConsultar=new JButton ("Consulta");
	
	JPanel pnlCent = new JPanel();
	JPanel pnlInf = new JPanel();

	public EmpleadosConsultaBuscar() {
		addWindowListener(this);
		setTitle ("Consulta Servicio");
		setSize(300,400);
		lista.add("Jorge Garcia Jimenez");
		
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
