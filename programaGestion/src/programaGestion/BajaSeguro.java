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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BajaSeguro extends JFrame implements WindowListener, ActionListener
{
		private static final long serialVersionUID = 1L;
		PacienteBajaCorrecto pacientebajacorrecto=new PacienteBajaCorrecto(); 
		
		JLabel lblIncorrecto = new JLabel("¿Estás seguro que quieres dar de baja a este paciente?");
		JButton btnSi= new JButton("Sí");
		JButton btnNo=new JButton("No");
		
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
		
		public BajaSeguro() {
			addWindowListener(this);
			setTitle ("¿Estás seguro?");
			setSize(400,100);
			
			pnlSup.setLayout(new GridLayout(2,1));
			pnlSup.add(lblIncorrecto);
			lblIncorrecto.setHorizontalAlignment(0);
			
			pnlInf.setLayout(new FlowLayout());
			pnlInf.add(btnSi);
			pnlInf.add(btnNo);
			
			add(pnlSup,"Center");
			add(pnlInf,"South");
			
			setLocationRelativeTo(null);
			setLocation(500, 300);
			
			
			btnNo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnSi.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Object a;
					a=e.getSource();
					if(a.equals(btnSi)) {

					}
					setVisible(false);
				}
			});
		}
		public static void main(String[] args)
		{
			new CamasAltaErrorIdPac();

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
