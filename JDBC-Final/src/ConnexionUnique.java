
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ConnexionUnique {

	private Connection m_connection;
	private static ConnexionUnique Instance;
	private static String m_connect_url = "jdbc:mysql://localhost:3306/ETUDE";
	
	public ConnexionUnique() {
		try {
			
			m_connection = DriverManager.getConnection(m_connect_url, "root", "mysql");
			
		}
		catch (SQLException ex) {
			System.out.println("Erreur connectionUnique ");
			ex.printStackTrace();
		}
	}
	
	
	public Connection getConnection() {
		return m_connection;
		}
	
	public static ConnexionUnique getInstance() {
		if (Instance == null) {
			Instance = new ConnexionUnique();
			
		}
		return Instance;
	}
	
}
