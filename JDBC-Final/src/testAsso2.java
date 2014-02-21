import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class testAsso2 {
	public static void main(String[] args) throws SQLException {
		AssociationNotation assoc = AssociationNotation.getInstance();
		try {
			ConnexionUnique instance = ConnexionUnique.getInstance();
			Connection connect = instance.getConnection();

			String reqNot = "SELECT * FROM NOTATION N, ETUDIANT E, MODULE M " +
					"WHERE E.NUM_ET = N.NUM_ET " +
					"AND M.CODE = N.CODE;";
			Statement stmt = connect.createStatement();
			ResultSet rset = stmt.executeQuery(reqNot);

			try {
				
				Notation not = new Notation();
				Etudiant etu = new Etudiant();
				Module mod = new Module();

				while(rset.next()) {
					try{
						//Fill Etu
						etu.setNumEt(rset.getInt("NUM_ET"));
						etu.setNomEt(rset.getString("NOM_ET"));
						etu.setPrenomEt(rset.getString("PRENOM_ET"));
						etu.setVilleEt(rset.getString("VILLE_ET"));
						etu.setCpEt(rset.getString("CP_ET"));
						etu.setAnnee(rset.getInt("ANNEE"));
						etu.setGroupe(rset.getInt("GROUPE"));
						//Fill Mod
						mod.setCode(rset.getString("CODE"));
						mod.setLibelle(rset.getString("LIBELLE"));
						mod.setDiscipline(rset.getString("DISCIPLINE"));
						mod.sethCoursPrev(rset.getInt("H_COURS_PREV"));
						mod.setH_CoursRea(rset.getInt("H_COURS_REA"));
						mod.sethTpPrev(rset.getInt("H_TP_PREV"));
						mod.sethTpRea(rset.getInt("H_TP_REA"));
						mod.setCoefCc(rset.getInt("COEFF_CC"));
						mod.setCoefTest(rset.getInt("COEFF_TEST"));
						//Fill Notation
						not.setMoycc(rset.getFloat("MOY_CC"));
						not.setMoytest(rset.getFloat("MOY_TEST"));
						//Link-time
						assoc.creerLien(mod, etu, not);
						
					} 
					catch(SQLException e) {
						System.out.println(e.getLocalizedMessage());
					}
				}
			}
			catch(SQLException e) {
				System.out.println(e.getLocalizedMessage());
			} 
			rset.close();
			stmt.close();
			
		} 

		catch(SQLException e) {
			System.out.println(e.getLocalizedMessage());
		}
		//___________________________________
		//Affichage
		
		System.out.println("\nFin des résultats !\n"); 

	}// END MAIN()
}
