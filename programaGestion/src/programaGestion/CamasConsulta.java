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

public class CamasConsulta extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	PacienteAltaErrorNombre pacientealtaerrornombre =new PacienteAltaErrorNombre();
	CamasAltaErrorIdPac citasaltaerrorfecha= new CamasAltaErrorIdPac();
	CamasAltaErrorIdEdf citasaltaerrorhora= new CamasAltaErrorIdEdf();
	
	JLabel lblNum = new JLabel("Número cama:");
	static JTextField txtNum = new JTextField(20);
	JLabel lblPac = new JLabel("idPaciente:");
	static JTextField txtPac= new JTextField(20);
	JLabel lblEdf=new JLabel("idEdificio:");
	static JTextField txtEdf=new JTextField(20);
	JButton btnAceptar = new JButton("Aceptar");
	
	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();
	
	public CamasConsulta(){
		addWindowListener(this);
		setTitle ("Consulta Camas");
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
		pnlInf.add(btnAceptar);
		
		add(pnlSup,"North");
		add(pnlInf,"South");
		
		
		txtNum.setEditable(false);
		txtPac.setEditable(false);
		txtEdf.setEditable(false);
		
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
		new CamasConsulta();

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
