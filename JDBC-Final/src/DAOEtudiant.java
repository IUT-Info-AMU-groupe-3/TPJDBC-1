import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


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
		return Et;
		}
		catch (SQLException Err) {
			System.out.println("Erreur SQL : ");
			Err.printStackTrace();
			return null;
		}
		
		
		
		
	}
	
	public boolean delete (Etudiant Etu)  {
		
		try {
		ConnexionUnique Conn = ConnexionUnique.getInstance();
		Connection connect = Conn.getConnection();
		Statement stmt = connect.createStatement();
		
		String req = "DELETE FROM ETUDIANT WHERE NUM_ET = " + Etu.getNumEt() + ';';
		
		stmt.executeQuery(req);
		return true;
		}
		catch(SQLException Err) {
			System.out.println("Erreur SQL");
			Err.printStackTrace();
			return false;
		}
		
		
		
		
	}
	
	public boolean update(Etudiant Etu) {
		
		 
		try {
				ConnexionUnique Conn = ConnexionUnique.getInstance();
				Connection connect = Conn.getConnection();
				Statement stmt = connect.createStatement();
				
				String req = "UPDATE ETUDIANT SET NOM_ET = " + Etu.getNomEt() + ", PRENOM_ET = " + Etu.getPrenomEt() + ", CP_ET= " 
								+ Etu.getCpEt() + ", VILLE_ET= " + Etu.getVilleEt() + ", ANNEE=" + Etu.getAnnee() + ", GROUPE=" + Etu.getGroupe() 
								+ " WHERE NUM_ET = " + Etu.getNumEt() ;
				
				stmt.executeQuery(req);
				return true;
			}
			catch(SQLException Err) {
				System.out.println("Erreur SQL");
				Err.printStackTrace();
				return false;
			}
			
			
		
	}
	
	public Etudiant getById(int numEt)  {
		try {
	        String req = "SELECT * FROM ETUDIANT WHERE NUM_ET=" + numEt ;
	        ConnexionUnique conneU = ConnexionUnique.getInstance();
	        Connection conne = (Connection) conneU.getConnection();
	        Statement statement = conne.createStatement();
	        ResultSet resultSet = statement.executeQuery(req);
	        if(!resultSet.next()) return null;
	       
	        Etudiant et = new Etudiant(resultSet.getString("NOM_ET"), resultSet.getInt("NUM_ET"), resultSet.getString("PRENOM_ET"),
	                    resultSet.getString("CP_ET"), resultSet.getString("VILLE_ET"),
	                    resultSet.getInt("ANNEE"), resultSet.getInt("GROUPE"));
	        return et;
		}
		catch (SQLException Err) {
			System.out.println("Erreur SQL");
			Err.printStackTrace();
			return null;
		}
    }
	
	
	public List<Etudiant> findAll()  {
		try {
	        List<Etudiant> lEtu = new LinkedList<Etudiant>();
	        String req = "SELECT * FROM ETUDIANT" ;
	        ConnexionUnique conneU = ConnexionUnique.getInstance();
	        Connection conne = (Connection) conneU.getConnection();
	        Statement statement = conne.createStatement();
	        ResultSet resultSet = statement.executeQuery(req);
	
	        for (;resultSet.next();) {
	            Etudiant et = new Etudiant(
	                    resultSet.getString("NOM_ET"), 
	                    resultSet.getInt("NUM_ET"), 
	                    resultSet.getString("PRENOM_ET"),
	                    resultSet.getString("CP_ET"), 
	                    resultSet.getString("VILLE_ET"),
	                    resultSet.getInt("ANNEE"), 
	                    resultSet.getInt("GROUPE"));
	            lEtu.add(et);
	        }
	        return lEtu;
		}
		catch (SQLException Err) {
			System.out.println("Erreur SQL");
			Err.printStackTrace();
			return null;
		}
    }
	
	public List<Etudiant> findByNom(String NomEt)  {
		try {
	        List<Etudiant> lEtu = new LinkedList<Etudiant>();
	        String req = "SELECT * FROM ETUDIANT WHERE NOM_ET='" + NomEt + "'" ;
	        ConnexionUnique conneU = ConnexionUnique.getInstance();
	        Connection conne = (Connection) conneU.getConnection();
	        Statement statement = conne.createStatement();
	        ResultSet resultSet = statement.executeQuery(req);
	
	        for (;resultSet.next();) {
	            Etudiant et = new Etudiant(
	                    resultSet.getString("NOM_ET"), 
	                    resultSet.getInt("NUM_ET"), 
	                    resultSet.getString("PRENOM_ET"),
	                    resultSet.getString("CP_ET"), 
	                    resultSet.getString("VILLE_ET"),
	                    resultSet.getInt("ANNEE"), 
	                    resultSet.getInt("GROUPE"));
	            lEtu.add(et);
	        }
	        return lEtu;
		}
		catch (SQLException Err) {
			System.out.println("Erreur SQL");
			Err.printStackTrace();
			return null;
		}
    }
	
	public List<Etudiant> findByGroupe(int Groupe)  {
		try  {
	        List<Etudiant> lEtu = new LinkedList<Etudiant>();
	        String req = "SELECT * FROM ETUDIANT WHERE GROUPE="+Groupe;
	        ConnexionUnique conneU = ConnexionUnique.getInstance();
	        Connection conne = (Connection) conneU.getConnection();
	        Statement statement = conne.createStatement();
	        ResultSet resultSet = statement.executeQuery(req);
	
	        for (;resultSet.next();) {
	            Etudiant et = new Etudiant(
	                    resultSet.getString("NOM_ET"), 
	                    resultSet.getInt("NUM_ET"), 
	                    resultSet.getString("PRENOM_ET"),
	                    resultSet.getString("CP_ET"), 
	                    resultSet.getString("VILLE_ET"),
	                    resultSet.getInt("ANNEE"), 
	                    resultSet.getInt("GROUPE"));
	            lEtu.add(et);
	        }
	        return lEtu;
		}
		catch (SQLException Err) {
			System.out.println("Erreur SQL");
			Err.printStackTrace();
			return null;
		}
    }
	
	public List<Etudiant>findByAnnee(int Annee) {
		try {
	        List<Etudiant> lEtu = new LinkedList<Etudiant>();
	        String req = "SELECT * FROM ETUDIANT WHERE ANNEE=" + Annee;
	        ConnexionUnique conneU = ConnexionUnique.getInstance();
	        Connection conne = (Connection) conneU.getConnection();
	        Statement statement = conne.createStatement();
	        ResultSet resultSet = statement.executeQuery(req);
	
	        for (;resultSet.next();) {
	            Etudiant et = new Etudiant(
	                    resultSet.getString("NOM_ET"), 
	                    resultSet.getInt("NUM_ET"), 
	                    resultSet.getString("PRENOM_ET"),
	                    resultSet.getString("CP_ET"), 
	                    resultSet.getString("VILLE_ET"),
	                    resultSet.getInt("ANNEE"), 
	                    resultSet.getInt("GROUPE"));
	            lEtu.add(et);
	        }
	        return lEtu;
		}
		catch (SQLException Err) {
			System.out.println("Erreur SQL");
			Err.printStackTrace();
			return null;
		}
    }
	
	public float computeMoyennePonderee(Etudiant et)  {
		try {
	        String req = "SELECT AVG((MOY_CC*COEFF_CC + MOY_TEST*COEFF_TEST)/(COEFF_CC+COEFF_TEST)) " +
	                "FROM NOTATION N, MODULE M WHERE NUM_ET="  + et.getNumEt();
	        ConnexionUnique conneU = ConnexionUnique.getInstance();
	        Connection conne = (Connection) conneU.getConnection();
	        Statement statement = conne.createStatement();
	        ResultSet resultSet = statement.executeQuery(req);
	        resultSet.next();
	        return resultSet.getFloat(1);
		}
		catch (SQLException Err) {
			System.out.println("Erreur SQL");
			Err.printStackTrace();
			return 0;
		}

    }
	
	public int computeNbEtudiant() {
		try {
	        String req = "SELECT COUNT(NUM_ET) FROM ETUDIANT";
	        ConnexionUnique conneU = ConnexionUnique.getInstance();
	        Connection conne = (Connection) conneU.getConnection();
	        Statement statement = conne.createStatement();
	        ResultSet resultSet = statement.executeQuery(req);
	        resultSet.next();
	        return resultSet.getInt(1);
		}
		catch (SQLException Err) {
			System.out.println("Erreur SQL");
			Err.printStackTrace();
			return 0;
		}
    }

	public static DAOEtudiant getInstance(){
		if (instance == null) {
			instance = new DAOEtudiant();
			return instance;
		}
		return instance;
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
