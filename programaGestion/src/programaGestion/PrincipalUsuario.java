package programaGestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class PrincipalUsuario extends JFrame implements WindowListener, ActionListener
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

	VerAyuda verayuda=new VerAyuda();
	
	// En primer lugar creamos la barra de menú
	JMenuBar barraMenu = new JMenuBar();
	// Ahora creamos los elementos principales del menú
	JMenu menuPacientes = new JMenu("Pacientes");
	JMenu menuServicios = new JMenu("Servicios");
	JMenu menuCitas = new JMenu("Citas");
	JMenu menuAyuda=new JMenu("Ayuda");
	// Y Ahora los elementos de cada opción del menú principal
	// Primero los de Archivo
	// menuArchivoNuevo contendrá otros elementos, por lo que es tipo Menu
	// Los siguientes son MenuItem pues dentro no tienen submenús
	JMenuItem mniPacientesCons =new JMenuItem("Consulta");
	// Luego los de Edición
	JMenuItem mniServiciosCons =new JMenuItem("Consulta");
	// Por último, creamos los elementos dentro de Nuevo

	JMenuItem mniCitasCons =new JMenuItem("Consulta");
	
	JMenuItem mniAyudaVerAyuda=new JMenuItem("Ver Ayuda");
	
	
	public PrincipalUsuario() {
		
		//setLayout (new FlowLayout());
		setTitle("Principal" );
		// Establecemos la barra de menú
		// Empezamos a añadirle los elementos
		// Seguimos con los elementos de archivo
		menuPacientes.add(mniPacientesCons);
		// Añadimos un separador
		//menuPacientes.addSeparator();
		//menuPacientes.add(mniArchivoSalir);
		// Y ahora a edicion los suyos
		menuServicios.add(mniServiciosCons);

		menuCitas.add(mniCitasCons);
		
		menuAyuda.add(mniAyudaVerAyuda);
		
		
		//Por último agregamos los elementos archivo y edicióna la barra
		barraMenu.add(menuPacientes);
		barraMenu.add(menuServicios);
		barraMenu.add(menuCitas);
		barraMenu.add(menuAyuda);
		

		addWindowListener(this);
		setJMenuBar(barraMenu);
		setLocationRelativeTo(null);
		setLocation(480, 200);
		setSize(500,400);
		  
		
		mniPacientesCons.addActionListener((ActionListener) this);
		mniServiciosCons.addActionListener((ActionListener) this);
		mniCitasCons.addActionListener((ActionListener) this);
		mniAyudaVerAyuda.addActionListener((ActionListener) this);
		
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new PrincipalUsuario();

	}
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Object a;
		a=arg0.getSource();

		if (a.equals(mniPacientesCons)) {
			pacientesconsulta.setVisible(true);
		}else if(a.equals(mniServiciosCons)) {
			serviciosconsulta.setVisible(true);
		}else if(a.equals(mniCitasCons)) {
			citasconsulta.setVisible(true);
		}else if(a.equals(mniAyudaVerAyuda)) {
			verayuda.setVisible(true);
		}
		
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
