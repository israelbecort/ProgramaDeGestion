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
import javax.swing.JOptionPane;
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

	//CONECTAR CON BASE DE DATOS----------------------para utilizar por otra base de datos sustituir empresa
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/hospital?autoReconnect=true&useSSL=false";
	String login = "root";
	String password = "Studium2018;";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;

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
					String num =txtNum.getText();
					String pac = txtPac.getText();
					String edf = txtEdf.getText();
					
					//ESTABLECER CONEXION CON BASE DE DATOS
					try
					{
						connection = DriverManager.getConnection(url, login, password);
					}
					catch(SQLException arg0)
					{
						System.out.println("Se produjo un error al conectar a la Base de Datos");
					}
					//PREPARAR EL STATEMENT
					try
					{
						statement=connection.createStatement();
						rs=statement.executeQuery("SELECT * FROM camas;");
						
					}
					catch(SQLException arg0)
					{
						System.out.println("Error en la sentencia SQL");
					}
					
					if (num.equals("")) {
						pacientealtaerrornombre.setVisible(true);
						Log.mov("","Alta cama","");
					}else if(pac.equals("")){
						citaaltaerrorfecha.setVisible(true);
						Log.mov("","Alta cama","");
					}else if(edf.equals("")) {
						servicioaltaerrorprecio.setVisible(true);
						Log.mov("","Alta cama","");
					}else {
						String cadena= ("INSERT INTO camas (numCama, idPacienteFK, idEdificioFK) VALUES ('"+num+"','"+pac+"','"+edf+"');");
						
						//CARGAR EL DRIVER
						try
						{
							Class.forName(driver);
						}
						catch(ClassNotFoundException arg0)
						{
							System.out.println("Se ha producido un error al cargar el Driver");
						}
						//PREPARAR EL STATEMENT
						try
						{
							statement=connection.createStatement();
							statement.executeUpdate(cadena);
							if (rs.next())
							{
								System.out.println("Alta Correcta");
								Log.mov("","Alta",cadena);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Error: Datos no validos ","Alta Incorrecta",JOptionPane.WARNING_MESSAGE);
								System.out.println("Alta Incorrecta");
								Log.mov("","ERROR Alta",cadena);
							}
						}
						catch(SQLException arg0)
						{
							System.out.println("Error en la sentencia SQL");
						}
						try
						{
							String cadena1="SELECT * FROM camas";
							
							statement=connection.createStatement();
							rs= statement.executeQuery(cadena1);
							
							CamasModificacionBuscar.lista.removeAll();
							CamasConsultaBuscar.lista.removeAll();
							CamasBaja.lista.removeAll();

							while (rs.next())
							{

								CamasModificacionBuscar.lista.add(rs.getString("idCama")+" "+rs.getString("numCama")+" "+rs.getString("idPacienteFK")+" "+rs.getString("idEdificioFK"));
								CamasConsultaBuscar.lista.add(rs.getString("idCama")+" "+rs.getString("numCama")+" "+rs.getString("idPacienteFK")+" "+rs.getString("idEdificioFK"));
								CamasBaja.lista.add(rs.getString("idCama")+" "+rs.getString("numCama")+" "+rs.getString("idPacienteFK")+" "+rs.getString("idEdificioFK"));
							}
							
							System.out.println("Consulta Correcta");
							Log.mov("","Consulta",cadena1);
						}
						catch(SQLException arg0)
						{
							System.out.println("Error en la sentencia SQL");
						}
						setVisible(false);
						new PacienteAltaCorrecto();
						txtNum.setText("");
						txtPac.setText("");
						txtEdf.setText("");
						Log.mov("","Alta cama","");
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
