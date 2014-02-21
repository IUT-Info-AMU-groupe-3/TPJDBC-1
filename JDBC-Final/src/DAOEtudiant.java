import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DAOEtudiant {

	
	private static DAOEtudiant instance;
	
	public Etudiant insert (Etudiant Etu)  {
		Etudiant Et = new Etudiant();
		try {
		ConnexionUnique Conn = ConnexionUnique.getInstance();
		Connection connect = Conn.getConnection();
		
		Statement stmt = connect.createStatement();
		
		
		String req = "INSERT INTO ETUDIANT(NUM_ET , NOM_ET, PRENOM_ET, CPT_ET , VILLE_ET, ANNEE, GROUPE) VALUES ( " +
						Etu.getNumEt() + ',' + Etu.getNomEt() + + ',' + Etu.getPrenomEt() + ',' + Etu.getCpEt() + ',' + Etu.getVilleEt() + 
						',' + Etu.getAnnee() + ',' + Etu.getGroupe() + ");";
		
		stmt.executeQuery(req);
		Et = Etu;
		}
		catch (SQLException Err) {
			System.out.println("Erreur SQL : ");
			Err.printStackTrace();
			return null;
		}
		return Et;
		
		
		
	}
	
	public boolean delete (Etudiant Etu)  {
		
		try {
		ConnexionUnique Conn = ConnexionUnique.getInstance();
		Connection connect = Conn.getConnection();
		Statement stmt = connect.createStatement();
		
		String req = "DELETE FROM ETUDIANT WHERE NUM_ET = " + Etu.getNumEt() + ';';
		
		stmt.executeQuery(req);
		}
		catch(SQLException Err) {
			System.out.println("Erreur SQL");
			Err.printStackTrace();
			return false;
		}
		
		return true;
		
		
	}
	
	public boolean update(Etudiant Etu) {
		/*
		 * private int numEt;
	private String nomEt;
	private String prenomEt;
	private String cpEt;
	private  String villeEt;
	private int annee;
	private int groupe;
		 */
		try {
			ConnexionUnique Conn = ConnexionUnique.getInstance();
			Connection connect = Conn.getConnection();
			Statement stmt = connect.createStatement();
			
			String req = "UPDATE ETUDIANT SET NOM_ET = " + Etu.getNomEt() + ", PRENOM_ET = " + Etu.getPrenomEt() + ", CP_ET= " 
							+ Etu.getCpEt() + ", VILLE_ET= " + Etu.getVilleEt() + ", ANNEE=" + Etu.getAnnee() + ", GROUPE=" + Etu.getGroupe() 
							+ " WHERE NUM_ET = " + Etu.getNumEt() + ";";
			
			stmt.executeQuery(req);
			}
			catch(SQLException Err) {
				System.out.println("Erreur SQL");
				Err.printStackTrace();
				return false;
			}
			
			return true;
		
	}
	
	
	
	// TO DO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
