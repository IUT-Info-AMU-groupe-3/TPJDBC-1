import java.io.Serializable;
import java.util.Map;


public class Module implements Serializable {
	private String Code;
	private String libelle;
	private int hCoursPrev;
	private int h_CoursRea;
	private int hTpPrev;
	private int hTpRea;
	private String discipline;
	private int coefTest;
	private int coefCc;
	private Prof ProfSpecialiste;
	private Module ModulePere;
	private Map<Etudiant,Notation> Etudiants;
	
	public Module getModulePere() {
		return ModulePere;
	}
	public void setModulePere(Module ModulePere) {
		this.ModulePere = ModulePere;
	}
	
	public Prof getProfSpecialiste() {
		return ProfSpecialiste;
	}
	public void setProfSpecialiste(Prof ProfSpecialiste) {
		this.ProfSpecialiste = ProfSpecialiste;
	}
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int gethCoursPrev() {
		return hCoursPrev;
	}
	public void sethCoursPrev(int hCoursPrev) {
		this.hCoursPrev = hCoursPrev;
	}
	public int getH_CoursRea() {
		return h_CoursRea;
	}
	public void setH_CoursRea(int h_CoursRea) {
		this.h_CoursRea = h_CoursRea;
	}
	public int gethTpPrev() {
		return hTpPrev;
	}
	public void sethTpPrev(int hTpPrev) {
		this.hTpPrev = hTpPrev;
	}
	public int gethTpRea() {
		return hTpRea;
	}
	public void sethTpRea(int hTpRea) {
		this.hTpRea = hTpRea;
	}
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	public int getCoefTest() {
		return coefTest;
	}
	public void setCoefTest(int coefTest) {
		this.coefTest = coefTest;
	}
	public int getCoefCc() {
		return coefCc;
	}
	public void setCoefCc(int coefCc) {
		this.coefCc = coefCc;
	}
	@Override
	public String toString() {
		return "Module [Code=" + Code + ", libelle=" + libelle
				+ ", hCoursPrev=" + hCoursPrev + ", h_CoursRea=" + h_CoursRea
				+ ", hTpPrev=" + hTpPrev + ", hTpRea=" + hTpRea
				+ ", discipline=" + discipline + ", coefTest=" + coefTest
				+ ", coefCc=" + coefCc + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Code == null) ? 0 : Code.hashCode());
		result = prime * result + coefCc;
		result = prime * result + coefTest;
		result = prime * result
				+ ((discipline == null) ? 0 : discipline.hashCode());
		result = prime * result + hCoursPrev;
		result = prime * result + hTpPrev;
		result = prime * result + hTpRea;
		result = prime * result + h_CoursRea;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Module other = (Module) obj;
		if (Code == null) {
			if (other.Code != null)
				return false;
		} else if (!Code.equals(other.Code))
			return false;
		if (coefCc != other.coefCc)
			return false;
		if (coefTest != other.coefTest)
			return false;
		if (discipline == null) {
			if (other.discipline != null)
				return false;
		} else if (!discipline.equals(other.discipline))
			return false;
		if (hCoursPrev != other.hCoursPrev)
			return false;
		if (hTpPrev != other.hTpPrev)
			return false;
		if (hTpRea != other.hTpRea)
			return false;
		if (h_CoursRea != other.h_CoursRea)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	

}
 