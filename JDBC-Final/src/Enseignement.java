import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class Enseignement {

	private Set<Lien> liens;
	private Enseignement instance;
	
	public void creeEnseignement (Etudiant Etu, Module Mod, Prof prof) {
		Lien link = new Lien(Mod , Etu, prof);
		liens.add(link);
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
	
	
}
