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

public class CamasModificacion extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	PacienteAltaErrorNombre pacientealtaerrornombre =new PacienteAltaErrorNombre();
	CamasAltaErrorIdPac citasaltaerrorfecha= new CamasAltaErrorIdPac();
	CamasAltaErrorIdEdf citasaltaerrorhora= new CamasAltaErrorIdEdf();
	
	JLabel lblNombre = new JLabel("Número cama:");
	JTextField txtNombre = new JTextField(20);
	JLabel lblDesc = new JLabel("idPaciente:");
	JTextField txtDesc= new JTextField(20);
	JLabel lblPrecio=new JLabel("idEdificio:");
	JTextField txtPrecio=new JTextField(20);
	JButton btnAlta = new JButton("Modificar");
	JButton btnReset = new JButton("Resetear");
	
	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();
	
	public CamasModificacion(){
		addWindowListener(this);
		setTitle ("Modificacion Cama");
		setSize(350,300);
		//setVisible(true);
		
		pnlSup.setLayout(new GridLayout(6,1));
		pnlSup.add(lblNombre);
		lblNombre.setHorizontalAlignment(0);
		JPanel pnlSupSup =new JPanel();
		pnlSupSup.add(txtNombre);
		pnlSup.add(pnlSupSup);
		
		pnlSup.add(lblDesc);
		lblDesc.setHorizontalAlignment(0);
		JPanel pnlCent2=new JPanel();
		pnlCent2.add(txtDesc);
		pnlSup.add(pnlCent2);
		
		pnlSup.add(lblPrecio);
		lblPrecio.setHorizontalAlignment(0);
		JPanel pnlCent3=new JPanel();
		pnlCent3.add(txtPrecio);
		pnlSup.add(pnlCent3);
		
		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnAlta);
		pnlInf.add(btnReset);
		
		add(pnlSup,"North");
		add(pnlInf,"South");
		
		txtNombre.setText("155");
		txtDesc.setText("454");
		txtPrecio.setText("4");
		String nombre =txtNombre.getText();
		String descripcion = txtDesc.getText();
		String precio = txtPrecio.getText();
		
		setLocationRelativeTo(null);
		setLocation(480, 200);
		
		
		btnReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText(nombre);
				txtDesc.setText(descripcion);
				txtPrecio.setText(precio);
			}
		});
		btnAlta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnAlta)) {
					String nombre =txtNombre.getText();
					String descripcion = txtDesc.getText();
					String precio = txtPrecio.getText();
					if (nombre.equals("")) {
						pacientealtaerrornombre.setVisible(true);
					}else if(descripcion.equals("")){
						citasaltaerrorfecha.setVisible(true);
					}else if(precio.equals("")) {
						citasaltaerrorhora.setVisible(true);
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
		// TODO Auto-generated method stub

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
