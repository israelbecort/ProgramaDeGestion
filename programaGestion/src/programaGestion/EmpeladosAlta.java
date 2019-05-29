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

public class EmpeladosAlta extends JFrame implements WindowListener, ActionListener
{
private static final long serialVersionUID = 1L;
	
	PacienteAltaErrorNombre pacientealtaerrornombre =new PacienteAltaErrorNombre();
	PacienteAltaErrorApe1 pacientealtaerrorape1= new PacienteAltaErrorApe1();
	PacienteAltaErrorApe2 pacientealtaerrorape2= new PacienteAltaErrorApe2();
	
	JLabel lblNombre = new JLabel("Nombre Empleado:");
	JTextField txtNombre = new JTextField(20);
	JLabel lblApe1 = new JLabel("Primer Apellido:");
	JTextField txtApe1= new JTextField(20);
	JLabel lblApe2=new JLabel("Segundo apellido:");
	JTextField txtApe2=new JTextField(20);
	JButton btnAlta = new JButton("Aceptar");
	JButton btnLimpiar = new JButton("Limpiar");
	
	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();
	
	public EmpeladosAlta(){
		addWindowListener(this);
		setTitle ("Alta Empleado");
		setSize(350,300);
		//setVisible(true);
		
		pnlSup.setLayout(new GridLayout(6,1));
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
		pnlInf.add(btnAlta);
		pnlInf.add(btnLimpiar);
		
		add(pnlSup,"North");
		add(pnlInf,"South");
		
		setLocationRelativeTo(null);
		setLocation(480, 200);
		
		btnLimpiar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtApe1.setText("");
				txtApe2.setText("");
			}
		});
		btnAlta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnAlta)) {
					String nombre =txtNombre.getText();
					String apellido1 = txtApe1.getText();
					String apellido2 = txtApe2.getText();
					if (nombre.equals("")) {
						pacientealtaerrornombre.setVisible(true);
					}else if(apellido1.equals("")){
						pacientealtaerrorape1.setVisible(true);
					}else if(apellido2.equals("")) {
						pacientealtaerrorape2.setVisible(true);
					}else {
						setVisible(false);
						new PacienteAltaCorrecto();
					}
				}
			}
		});
	}
	public static void main(String[] args)
	{
		new EmpeladosAlta();

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
