package programaGestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Principal extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	PacientesAlta pacientesalta= new PacientesAlta();
	PacienteModificacionBuscar pacientesmod=new PacienteModificacionBuscar();
	PacienteBaja pacientesbaja=new PacienteBaja();
	PacienteConsulta pacientesconsulta=new PacienteConsulta();
	
	EmpeladosAlta serviciosalta=new EmpeladosAlta();
	EmpleadosModificacionBuscar serviciosmod=new EmpleadosModificacionBuscar();
	EmpleadosBaja serviciosbaja=new EmpleadosBaja();
	EmpleadosConsultaBuscar serviciosconsulta=new EmpleadosConsultaBuscar();
	
	CamasAlta citasalta= new CamasAlta();
	CamasModificacionBuscar citasmod=new CamasModificacionBuscar();
	CamasBaja citasbaja=new CamasBaja();
	CamasConsultaBuscar citasconsulta=new CamasConsultaBuscar();
	
	// En primer lugar creamos la barra de menú
	JMenuBar barraMenu = new JMenuBar();
	// Ahora creamos los elementos principales del menú
	JMenu menuPacientes = new JMenu("Pacientes");
	JMenu menuEmpleados = new JMenu("Empleados");
	JMenu menuCamas = new JMenu("Camas");
	JMenu menuAyuda=new JMenu("Ayuda");
	// Los siguientes son MenuItem pues dentro no tienen submenús
	JMenuItem mniPacientesAlta = new JMenuItem("Alta");
	JMenuItem mniPacientesMod = new JMenuItem("Modificacion");
	JMenuItem mniPacientesBaja = new JMenuItem("Baja");
	JMenuItem mniPacientesCons =new JMenuItem("Consulta");

	JMenuItem mniEmpleadosAlta = new JMenuItem("Alta");
	JMenuItem mniEmpleadosMod = new JMenuItem("Modificacion");
	JMenuItem mniEmpleadosBaja = new JMenuItem("Baja");
	JMenuItem mniEmpleadosCons =new JMenuItem("Consulta");

	JMenuItem mniCamasAlta = new JMenuItem("Alta");
	JMenuItem mniCamasMod = new JMenuItem("Modificacion");
	JMenuItem mniCamasBaja = new JMenuItem("Baja");
	JMenuItem mniCamasCons =new JMenuItem("Consulta");
	
	JMenuItem mniAyudaVerAyuda=new JMenuItem("Ver Ayuda");
	
	
	public Principal() {
		
		setTitle ("Principal" );
		// Establecemos la barra de menú
		// Empezamos a añadirle los elementos
		// Seguimos con los elementos de archivo
		menuPacientes.add(mniPacientesAlta);
		menuPacientes.add(mniPacientesMod);
		menuPacientes.add(mniPacientesBaja);
		menuPacientes.add(mniPacientesCons);

		menuEmpleados.add(mniEmpleadosAlta);
		menuEmpleados.add(mniEmpleadosMod);
		menuEmpleados.add(mniEmpleadosBaja);
		menuEmpleados.add(mniEmpleadosCons);
		
		menuCamas.add(mniCamasAlta);
		menuCamas.add(mniCamasMod);
		menuCamas.add(mniCamasBaja);
		menuCamas.add(mniCamasCons);
		
		
		menuAyuda.add(mniAyudaVerAyuda);
		
		
		//Por último agregamos los elementos archivo y edicióna la barra
		barraMenu.add(menuPacientes);
		barraMenu.add(menuEmpleados);
		barraMenu.add(menuCamas);
		barraMenu.add(menuAyuda);
		

		addWindowListener(this);
		setJMenuBar(barraMenu);
		setLocationRelativeTo(null);
		setLocation(480, 200);
		setSize(500,400);
		  
		
		mniPacientesAlta.addActionListener((ActionListener) this);
		mniPacientesMod.addActionListener((ActionListener) this);
		mniPacientesBaja.addActionListener((ActionListener) this);
		mniPacientesCons.addActionListener((ActionListener) this);
		mniEmpleadosAlta.addActionListener((ActionListener) this);
		mniEmpleadosMod.addActionListener((ActionListener) this);
		mniEmpleadosBaja.addActionListener((ActionListener) this);
		mniEmpleadosCons.addActionListener((ActionListener) this);
		mniCamasAlta.addActionListener((ActionListener) this);
		mniCamasMod.addActionListener((ActionListener) this);
		mniCamasBaja.addActionListener((ActionListener) this);
		mniCamasCons.addActionListener((ActionListener) this);
		mniAyudaVerAyuda.addActionListener((ActionListener) this);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Principal();
		}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object a;
		a=arg0.getSource();
		if(a.equals(mniPacientesAlta))
		{
			pacientesalta.setVisible(true);
		}else if(a.equals(mniPacientesMod)) {
			pacientesmod.setVisible(true);
		}else if (a.equals(mniPacientesBaja)) {
			pacientesbaja.setVisible(true);
		}else if (a.equals(mniPacientesCons)) {
			pacientesconsulta.setVisible(true);
		}else if(a.equals(mniEmpleadosAlta)) {
			serviciosalta.setVisible(true);
		}else if(a.equals(mniEmpleadosMod)) {
			serviciosmod.setVisible(true);
		}else if(a.equals(mniEmpleadosBaja)) {
			serviciosbaja.setVisible(true);
		}else if(a.equals(mniEmpleadosCons)) {
			serviciosconsulta.setVisible(true);
		}else if(a.equals(mniCamasAlta)) {
			citasalta.setVisible(true);
		}else if(a.equals(mniCamasMod)) {
			citasmod.setVisible(true);
		}else if(a.equals(mniCamasBaja)) {
			citasbaja.setVisible(true);
		}else if(a.equals(mniCamasCons)) {
			citasconsulta.setVisible(true);
		}else if(a.equals(mniAyudaVerAyuda)) {
			try {
				Runtime.getRuntime().exec("hh.exe ayuda/help.chm");
			}catch (IOException e) {
				e.printStackTrace();
				}
//			verayuda.setVisible(true);
		}
		
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
		System.exit(0);
		
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
