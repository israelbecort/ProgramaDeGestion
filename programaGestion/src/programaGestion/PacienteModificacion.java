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

public class PacienteModificacion extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	
	PacienteAltaErrorNombre pacientealtaerrornombre =new PacienteAltaErrorNombre();
	PacienteAltaErrorApe1 pacientealtaerrorape1= new PacienteAltaErrorApe1();
	PacienteAltaErrorApe2 pacientealtaerrorape2= new PacienteAltaErrorApe2();
	
	JLabel lblNombre = new JLabel("Nombre:");
	static JTextField txtNombre = new JTextField(10);
	JLabel lblApe1 = new JLabel("Primer apellido:");
	static JTextField txtApe1= new JTextField(10);
	JLabel lblApe2=new JLabel("Segundo apellido:");
	static JTextField txtApe2=new JTextField(10);
	JButton btnAceptar = new JButton("Aceptar Cambios");
	JButton btnReset = new JButton("Resetear");
	
	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();
		
	
	public PacienteModificacion(){
		
		addWindowListener(this);
		setTitle ("Modificar Paciente");
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
		pnlInf.add(btnReset);
		
		add(pnlSup,"North");
		add(pnlInf,"South");
		
		
//		txtNombre.setText("Juan");
//		txtApe1.setText("Gonzalez");
//		txtApe2.setText("Martinez");
		
		setLocationRelativeTo(null);
		setLocation(480, 200);
		
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if (a.equals(btnReset)){
					
					txtNombre.setText(PacienteModificacionBuscar.nombre);
					txtApe1.setText(PacienteModificacionBuscar.ape1);
					txtApe2.setText(PacienteModificacionBuscar.ape2);
				}
			}
		});
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnAceptar)) {
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
						new PacienteModCorrecto();
					}
				}
			}
		});
	}

	public static void main(String[] args)
	{
		new PacienteModificacion();

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
