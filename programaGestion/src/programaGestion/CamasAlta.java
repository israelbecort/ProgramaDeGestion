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

public class CamasAlta extends JFrame implements WindowListener, ActionListener
{
	
	private static final long serialVersionUID = 1L;
	PacienteAltaErrorNombre pacientealtaerrornombre =new PacienteAltaErrorNombre();
	CamasAltaErrorIdPac citaaltaerrorfecha= new CamasAltaErrorIdPac();
	CamasAltaErrorIdEdf servicioaltaerrorprecio= new CamasAltaErrorIdEdf();
	
	JLabel lblNum = new JLabel("Número Cama:");
	JTextField txtNum = new JTextField(20);
	JLabel lblPac = new JLabel("idPaciente:");
	JTextField txtPac= new JTextField(20);
	JLabel lblEdf=new JLabel("idEdificio:");
	JTextField txtEdf=new JTextField(20);
	JButton btnAlta = new JButton("Alta");
	JButton btnLimpiar = new JButton("Limpiar");
	
	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();
	
	public CamasAlta(){
		addWindowListener(this);
		setTitle ("Alta Cama");
		setSize(350,300);
		//setVisible(true);
		
		pnlSup.setLayout(new GridLayout(6,1));
		pnlSup.add(lblNum);
		lblNum.setHorizontalAlignment(0);
		JPanel pnlSupSup =new JPanel();
		pnlSupSup.add(txtNum);
		pnlSup.add(pnlSupSup);
		
		pnlSup.add(lblPac);
		lblPac.setHorizontalAlignment(0);
		JPanel pnlCent2=new JPanel();
		pnlCent2.add(txtPac);
		pnlSup.add(pnlCent2);
		
		pnlSup.add(lblEdf);
		lblEdf.setHorizontalAlignment(0);
		JPanel pnlCent3=new JPanel();
		pnlCent3.add(txtEdf);
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
				txtNum.setText("");
				txtPac.setText("");
				txtEdf.setText("");
			}
		});
		btnAlta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnAlta)) {
					String nombre =txtNum.getText();
					String apellido1 = txtPac.getText();
					String apellido2 = txtEdf.getText();
					if (nombre.equals("")) {
						pacientealtaerrornombre.setVisible(true);
					}else if(apellido1.equals("")){
						citaaltaerrorfecha.setVisible(true);
					}else if(apellido2.equals("")) {
						servicioaltaerrorprecio.setVisible(true);
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
		new CamasAlta();

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
