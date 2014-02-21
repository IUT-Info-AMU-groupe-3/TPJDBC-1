import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class AssociationNotation {

	private Set<Lien> liens;
	private static AssociationNotation instance;
	
	public void creerLien (Module mod, Etudiant etu, Notation note) {
		Lien L = new Lien(mod, etu);
		L.setNote(note);
		liens.add(L);
	}
	
	public void suprimerLien(Module mod, Etudiant etu) {
		for (Iterator<Lien> i = liens.iterator() ;  ; ) {
			Lien f = i.next();
			if (f.equals(new Lien (mod , etu))) {
				liens.remove(f);
			}
		}
	}
	
	public void SuprimerLien(Lien Link) {
		liens.remove(Link);
	}
	
	public Lien getLien(Module mod, Etudiant etu) {
		for (Iterator<Lien> i = liens.iterator() ; i.hasNext() ; ) {
			Lien f = i.next();
			if (f.equals(new Lien (mod , etu))) {
				return f;
			}
		}
		return null;
	}
	
	public Set<Lien> getLiens(Etudiant etu) {
		Set<Lien> res = new HashSet<Lien>();
		for (Iterator<Lien> i = liens.iterator() ; i.hasNext() ; ) {
			Lien f = i.next();
			if (f.getEtudiant() == etu) {
				res.add(f);
			}
		}
		return res;
		
	}
	
	public Set<Lien> getLiens(Module mod) {
		Set<Lien> res = new HashSet<Lien>();
		for (Iterator<Lien> i = liens.iterator() ; i.hasNext() ; ) {
			Lien f = i.next();
			if (f.getModule() == mod) {
				res.add(f);
			}
		}
		return res;
	}
	
	public Set<Module> getModules(Etudiant etu) {
		Set<Module> res = new HashSet<Module>();
		for (Iterator<Lien> i = liens.iterator() ; i.hasNext() ; ) {
			Lien f = i.next();
			if (f.getEtudiant() == etu) {
				res.add(f.getModule());
			}
		}
		return res;
	}
	
	public Set<Etudiant> getEtudiants(Module mod) {
		Set<Etudiant> res = new HashSet<Etudiant>();
		for (Iterator<Lien> i = liens.iterator() ; i.hasNext() ; ) {
			Lien f = i.next();
			if (f.getModule() == mod) {
				res.add(f.getEtudiant());
			}
		}
		return res;
	}
	
	public static AssociationNotation getInstance() {
		
		if (instance == null) {
			instance = new AssociationNotation();
			return instance;
		}
		return instance;
	}
	
	
	
	
	
	
	
}
