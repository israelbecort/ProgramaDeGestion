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

public class EmpleadosModificacion extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	PacienteAltaErrorNombre pacientealtaerrornombre =new PacienteAltaErrorNombre();
	PacienteAltaErrorApe1 pacientealtaerrorape1= new PacienteAltaErrorApe1();
	PacienteAltaErrorApe2 pacientealtaerrorape2= new PacienteAltaErrorApe2();
	
	JLabel lblNombre = new JLabel("Nombre:");
	JTextField txtNombre = new JTextField(20);
	JLabel lblApe1 = new JLabel("Primer Apellido:");
	JTextField txtApe1= new JTextField(20);
	JLabel lblApe2=new JLabel("Segundo Apellido:");
	JTextField txtApe2=new JTextField(20);
	JButton btnAlta = new JButton("Modificar");
	JButton btnReset = new JButton("Resetear");
	
	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();
	
	public EmpleadosModificacion(){
		addWindowListener(this);
		setTitle ("Modificacion Empleado");
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
		pnlInf.add(btnReset);
		
		add(pnlSup,"North");
		add(pnlInf,"South");
		
		txtNombre.setText("Jorge");
		txtApe1.setText("Garcia");
		txtApe2.setText("Jimenez");
		String nombre =txtNombre.getText();
		String descripcion = txtApe1.getText();
		String precio = txtApe2.getText();
		
		setLocationRelativeTo(null);
		setLocation(480, 200);
		
		
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText(nombre);
				txtApe1.setText(descripcion);
				txtApe2.setText(precio);
			}
		});
		btnAlta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnAlta)) {
					String nombre =txtNombre.getText();
					String descripcion = txtApe1.getText();
					String precio = txtApe2.getText();
					if (nombre.equals("")) {
						pacientealtaerrornombre.setVisible(true);
					}else if(descripcion.equals("")){
						pacientealtaerrorape1.setVisible(true);
					}else if(precio.equals("")) {
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
		new EmpleadosModificacion();

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
