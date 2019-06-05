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

public class PacienteConsultar extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;

	JLabel lblNombre = new JLabel("Nombre:");
	static JTextField txtNombre = new JTextField(10);
	JLabel lblApe1 = new JLabel("Primer apellido:");
	static JTextField txtApe1= new JTextField(10);
	JLabel lblApe2=new JLabel("Segundo apellido:");
	static JTextField txtApe2=new JTextField(10);
	JButton btnAceptar = new JButton("Aceptar");


	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();
	public PacienteConsultar(){

		addWindowListener(this);
		setTitle ("Alta Paciente");
		setSize(300,190);
		//setVisible(true);

		pnlSup.setLayout(new GridLayout(4,2));
		pnlSup.add(lblNombre);
		lblNombre.setHorizontalAlignment(0);
		JPanel pnlSupSup =new JPanel();
		pnlSupSup.add(txtNombre);
		pnlSup.add(pnlSupSup);

		pnlSup.add(lblApe1);
		lblApe1.setHorizontalAlignment(0);
		JPanel pnlCent2=new JPanel();
		pnlCent2.add(txtApe1);
		pnlSup.add(pnlCent2);

		pnlSup.add(lblApe2);
		lblApe2.setHorizontalAlignment(0);
		JPanel pnlCent3=new JPanel();
		pnlCent3.add(txtApe2);
		pnlSup.add(pnlCent3);

		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnAceptar);

		add(pnlSup,"North");
		add(pnlInf,"South");
		
		

			//		txtNombre.setText("Juan");
			//		txtApe1.setText("Gonzalez");
			//		txtApe2.setText("Martinez");

			txtNombre.setEditable(false);
		txtApe1.setEditable(false);
		txtApe2.setEditable(false);

		setLocationRelativeTo(null);
		setLocation(480, 200);


		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnAceptar)) {
					setVisible(false);
				}
			}
		});
	}
	public static void main(String[] args)
	{
		new PacienteConsultar();

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
