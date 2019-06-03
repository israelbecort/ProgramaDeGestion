package programaGestion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Log 
{
	public static String user = "";
	public static void mov(String usu, String log, String cad)
	{
		if (user.equals("")) {
			user = usu;
		}
		Calendar calendario = new GregorianCalendar();
		int dia, mes, anio, hora, minutos, segundos;
		String movimientos;
		dia = calendario.get(Calendar.DAY_OF_MONTH);
		mes = calendario.get(Calendar.MONTH);
		anio = calendario.get(Calendar.YEAR);
		hora = calendario.get(Calendar.HOUR_OF_DAY);
		minutos = calendario.get(Calendar.MINUTE);
		segundos = calendario.get(Calendar.SECOND);
		movimientos = ("[" + String.format("%02d",dia) + "-" + String.format("%02d",mes) + "-" + String.format("%02d",anio)
			+ " " + String.format("%02d",hora) + ":" + String.format("%02d",minutos) + ":" + String.format("%02d",segundos)
			+ "][" + user + "]["+ log+"]["+cad+"]");
		try
		{
			FileWriter fw = new FileWriter("movimientos.log",true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter salida = new PrintWriter(bw);
			salida.println(movimientos);
			salida.close();
			bw.close();
			fw.close();
			System.out.println("Archivo creado correctamente!");
		}
		catch(IOException i)
		{
			System.out.println("Se produjo un error de Archivo");
		}
	}
}