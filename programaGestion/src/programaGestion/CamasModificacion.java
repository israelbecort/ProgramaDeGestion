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

public class CamasModificacion extends JFrame implements WindowListener, ActionListener
{
	private static final long serialVersionUID = 1L;
	PacienteAltaErrorNombre pacientealtaerrornombre =new PacienteAltaErrorNombre();
	CamasAltaErrorIdPac citasaltaerrorfecha= new CamasAltaErrorIdPac();
	CamasAltaErrorIdEdf citasaltaerrorhora= new CamasAltaErrorIdEdf();

	JLabel lblNombre = new JLabel("Número cama:");
	static JTextField numCama = new JTextField(20);
	JLabel lblDesc = new JLabel("idPaciente:");
	static JTextField idPac= new JTextField(20);
	JLabel lblPrecio=new JLabel("idEdificio:");
	static JTextField idEdf=new JTextField(20);
	JButton btnAlta = new JButton("Modificar");
	JButton btnReset = new JButton("Resetear");

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

	public CamasModificacion(){
		addWindowListener(this);
		setTitle ("Modificacion Cama");
		setSize(350,300);
		//setVisible(true);

		pnlSup.setLayout(new GridLayout(6,1));
		pnlSup.add(lblNombre);
		lblNombre.setHorizontalAlignment(0);
		JPanel pnlSupSup =new JPanel();
		pnlSupSup.add(numCama);
		pnlSup.add(pnlSupSup);

		pnlSup.add(lblDesc);
		lblDesc.setHorizontalAlignment(0);
		JPanel pnlCent2=new JPanel();
		pnlCent2.add(idPac);
		pnlSup.add(pnlCent2);

		pnlSup.add(lblPrecio);
		lblPrecio.setHorizontalAlignment(0);
		JPanel pnlCent3=new JPanel();
		pnlCent3.add(idEdf);
		pnlSup.add(pnlCent3);

		pnlInf.setLayout(new FlowLayout());
		pnlInf.add(btnAlta);
		pnlInf.add(btnReset);

		add(pnlSup,"North");
		add(pnlInf,"South");

		setLocationRelativeTo(null);
		setLocation(480, 200);


		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				numCama.setText(CamasModificacionBuscar.numCama);
				idPac.setText(CamasModificacionBuscar.idPac);
				idEdf.setText(CamasModificacionBuscar.idEdf);
			}
		});
		btnAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Object a;
				a=e.getSource();
				if(a.equals(btnAlta)) {
					String nCama =numCama.getText();
					String iPac = idPac.getText();
					String iEdf = idEdf.getText();
					
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
					
					if (nCama.equals("")) {
						pacientealtaerrornombre.setVisible(true);
					}else if(iPac.equals("")){
						citasaltaerrorfecha.setVisible(true);
					}else if(iEdf.equals("")) {
						citasaltaerrorhora.setVisible(true);
					}else {
						
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
							String cadena= ("UPDATE camas SET numCama='"+nCama+"', idPacienteFK='"+iPac+"', idEdificioFK='"+iEdf+"' WHERE numCama='"+
									CamasModificacionBuscar.numCama+"' AND idPacienteFK='"+CamasModificacionBuscar.idPac+"' AND idEdificioFK='"+CamasModificacionBuscar.idEdf+"';");
							
							statement=connection.createStatement();
							statement.executeUpdate(cadena);
	
							if (rs.next())
							{
								System.out.println("Modificacion Correcta");
								new PacienteModCorrecto();
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
							JOptionPane.showMessageDialog(null, "el id Paciente o id Edificio introducido no existe.");
						}
						try
						{
							String cadena="SELECT * FROM camas";
							
							statement=connection.createStatement();
							rs= statement.executeQuery(cadena);
							
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
							Log.mov("","Consulta",cadena);
						}
						catch(SQLException arg0)
						{
							System.out.println("Error en la sentencia SQL");
						}
						
						setVisible(false);
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
