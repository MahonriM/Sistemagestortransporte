import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	public static Connection getconexion() {
		String url="jdbc:sqlserver://localhost;databaseName=Tranporte;integratedSecurity=true";
		try {
			Connection con = DriverManager.getConnection(url);
			return con;
		}
		catch(Exception ex) {
			System.out.println("Ha ocurrido un error");
			return null;
		}
}
	}
