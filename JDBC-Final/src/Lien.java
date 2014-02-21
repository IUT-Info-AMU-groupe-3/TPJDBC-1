
public class Lien {

	private Module module;
	private Etudiant etudiant;
	private Prof prof;
	private Notation note;
	
	public Lien (Module Mod, Etudiant Etu) {
		etudiant = Etu;
		module = Mod; 
	}
	public Lien (Module Mod, Etudiant Etu, Prof pro) {
		etudiant = Etu;
		module = Mod;
		prof = pro;
	}

	public Notation getNote() {
		return note;
	}
	public Prof getProf() {
		return prof;
	}
	public void setProf() {
		this.prof = prof;
	}
	public void setNote(Notation note) {
		this.note = note;
	}

	public Module getModule() {
		return module;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}
	
}
