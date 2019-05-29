package programaGestion;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VerAyuda extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	
	JTextArea txtAyuda =new JTextArea(20,20);
	JButton btnAceptar =new JButton ("Aceptar");
	
	JPanel pnlSup =new JPanel();
	JPanel pnlInf =new JPanel();
	
	public VerAyuda() {
		addWindowListener(this);
		setTitle ("Ayuda");
		setSize(700,500);
		//setVisible(true);
		
		pnlSup.setLayout(new GridLayout(1,1));
		pnlSup.add(txtAyuda);
		
		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnAceptar);
		
		add(pnlSup,"North");
		add(pnlInf,"South");
		
		txtAyuda.setText("Eclipse DSL Tools\r\n" + 
				"\r\n" + 
				"Version: 2018-09 (4.9.0)\r\n" + 
				"Build id: 20180917-1800\r\n" + 
				"\r\n" + 
				"(c) Copyright Eclipse contributors and others 2000, 2018.\nAll rights reserved. Eclipse and the\n Eclipse logo are trademarks of the Eclipse Foundation, Inc.,\n https://www.eclipse.org/. The Eclipse logo cannot be altered without Eclipse's permission.\n Eclipse logos are provided for use under the Eclipse logo and trademark guidelines, https://www.eclipse.org/logotm/.\n Oracle and Java are trademarks or registered trademarks of Oracle and/or its affiliates.\n Other names may be trademarks of their respective owners.\r\n" + 
				"\r\n" + 
				"This product includes software developed by other\n open source projects including the Apache Software Foundation, https://www.apache.org/.");
		
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
		new VerAyuda();

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
