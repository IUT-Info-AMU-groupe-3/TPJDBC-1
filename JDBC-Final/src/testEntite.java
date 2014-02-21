import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

	
public class testEntite {
	
	static final String req = "SELECT * FROM ETUDIANT";
	public testEntite() {
	try {
	ConnexionUnique Conn = ConnexionUnique.getInstance();
	Connection connect = Conn.getConnection();
	
	Statement stmt = connect.createStatement();
	
	ResultSet rset = stmt.executeQuery(req);
	ArrayList<Etudiant> ArrayEtu = new ArrayList<Etudiant>();
	while (rset.next()) {
		Etudiant Etu = new Etudiant();
		Etu.setNumEt(rset.getInt("NUM_ET"));
		Etu.setNomEt(rset.getString("Nom_ET"));
		Etu.setPrenomEt(rset.getString("PRENOM_ET"));
		Etu.setCpEt(rset.getString("CP_ET"));
		Etu.setVilleEt(rset.getString("VILLE_ET"));
		Etu.setAnnee(rset.getInt("ANNEE"));
		Etu.setGroupe(rset.getInt("GROUPE"));
		
		ArrayEtu.add(Etu);
		
		
		
	}
	stmt.close();
	for (int i = 0 ; i < ArrayEtu.size() ; i++) {
		System.out.println(ArrayEtu.get(i));
	}
	
	}
	catch (SQLException Ex) {
		System.out.println("Erreur !!");
	}
	
	
	
	}
	
	public static void main(String[] args) {
		try {
			
		
		testEntite  test = new testEntite();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}
		

			
	
}
