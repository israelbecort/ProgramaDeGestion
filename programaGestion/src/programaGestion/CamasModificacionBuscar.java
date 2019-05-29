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

public class CamasModificacionBuscar extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	
	CamasModificacion citasmodificacion=new CamasModificacion(); 
	
	JLabel lblBuscar =new JLabel("Buscar:");
	JTextField txtBuscar=new JTextField(20);
	JButton btnBuscar=new JButton("Buscar");
	List lista=new List(6, false);
	JButton btnConsultar=new JButton ("Modificar");
	
	JPanel pnlSup = new JPanel();
	JPanel pnlCent = new JPanel();
	JPanel pnlInf = new JPanel();

	public CamasModificacionBuscar() {
		addWindowListener(this);
		setTitle ("Modificar cama");
		setSize(300,400);
		lista.add("155 454 4");
		
		
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
		pnlInf.add(btnConsultar);
		
		add(pnlSup,"North");
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
					citasmodificacion.setVisible(true);
				}
			}
		});
	}
	public static void main(String[] args)
	{
		new CamasModificacionBuscar();

	}
	@Override
	public void actionPerformed(ActionEvent arg0)
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
