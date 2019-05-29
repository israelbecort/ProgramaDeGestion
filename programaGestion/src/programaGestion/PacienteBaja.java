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

public class PacienteBaja extends JFrame implements WindowListener, ActionListener
{
		private static final long serialVersionUID = 1L;
		
		
		BajaSeguro bajaseguro =new BajaSeguro();
		
		JLabel lblBuscar =new JLabel("Buscar:");
		JTextField txtBuscar=new JTextField(20);
		JButton btnBuscar=new JButton("Buscar");
		List lista=new List(6, false);
		JButton btnBaja=new JButton ("Dar de baja");
		
		JPanel pnlSup = new JPanel();
		JPanel pnlCent = new JPanel();
		JPanel pnlInf = new JPanel();

		public PacienteBaja() {
			addWindowListener(this);
			setTitle ("Baja paciente");
			setSize(300,400);
			lista.add("Juan Gonzalez Martinez");
			
			
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
						bajaseguro.setVisible(true);
					}
				}
			});
		}
		
		public static void main(String[] args)
		{
			new PacienteBaja();
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
