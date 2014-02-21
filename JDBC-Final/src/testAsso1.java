import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class testAsso1 {
	static final String req = "SELECT * FROM PROF, MODULE WHERE MAT_SPEC = CODE ";
	public testAsso1() {
	try {
	ConnexionUnique Conn = ConnexionUnique.getInstance();
	Connection connect = Conn.getConnection();
	
	Statement stmt = connect.createStatement();
	
	ResultSet rset = stmt.executeQuery(req);
	ArrayList<Prof> ArrayProf = new ArrayList<Prof>();
	
	while (rset.next()) {
		Prof Pr = new Prof();
		Module Mod = new Module();
		
		Pr.setNumProf(rset.getInt("NUM_ET"));
		Pr.setNomProf(rset.getString("NOM_PROF"));
		Pr.setPrenomProf(rset.getString("PRENOM_PROF"));
		Pr.setAdrProf(rset.getString("ADR_PROF"));
		Pr.setCpProf(rset.getString("CP_PROF"));
		Pr.setVilleProf(rset.getString("VILLE_PROF"));
		
		
		Mod.setCode(rset.getString("CODE"));
		Mod.setLibelle(rset.getString("LIBELLE"));
		Mod.sethCoursPrev(rset.getInt("H_COURS_PREV"));
		Mod.setH_CoursRea(rset.getInt("H_COURS_REA"));
		Mod.sethTpPrev(rset.getInt("H_TP_PREV"));
		Mod.sethTpRea(rset.getInt("H_TP_REA"));
		Mod.setDiscipline(rset.getString("DISCIPLINE"));
		Mod.setCoefTest(rset.getInt("COEF_TEST"));
		Mod.setCoefCc(rset.getInt("COEF_CC"));
		
		Mod.setProfSpecialiste(Pr);
		Pr.setSpecialiste(Mod);
		
		ArrayProf.add(Pr);
		
		
		
		
	}
	stmt.close();
	for (int i = 0 ; i < ArrayProf.size() ; i++) {
		System.out.println(ArrayProf.get(i));
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
