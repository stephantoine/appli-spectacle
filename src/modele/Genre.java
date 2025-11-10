package modele;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Genre {
	private String libelle;
	private ArrayList<Spectacle> listeSpectacles;
	
	public Genre(String l) {
		this.libelle = l;
		listeSpectacles = new ArrayList<Spectacle>();
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public ArrayList<Spectacle> getListeSpectacles() {
		return listeSpectacles;
	}

	public void setListeSpectacles(ArrayList<Spectacle> listeSpectacles) {
		this.listeSpectacles = listeSpectacles;
	}

	public String toString() {
		return this.libelle;
	}
	
	public void afficher() {
		System.out.println(this.toString());
	}
	
	public boolean equals(Genre other) {
		boolean res = false;
		if(this.libelle.equals(other.getLibelle())) {
			res = true;
		}
		return res;
	} 
	
	public void listerSpectacles() {
		System.out.println("Liste des spectacles :");

		Iterator<Spectacle> it = this.listeSpectacles.iterator();

		while (it.hasNext()) {
			Spectacle current = it.next();
			current.afficher();
		}
	}
	
	private boolean contientSpectacle(Spectacle s) {
		return this.listeSpectacles.contains(s);
	}
	
	private void ajouterSpectacle(Spectacle s) {
		if (this.listeSpectacles != null) {
			this.listeSpectacles.add(s);
		}
	}

	public void ajouterUnNouveauSpectacle(Spectacle s) {
		if (s != null && !this.contientSpectacle(s)) {
			this.ajouterSpectacle(s);
		}
	}
	
	private void enleveSpectacle(Spectacle s) {
		if (this.listeSpectacles != null && this.contientSpectacle(s)) {
			this.listeSpectacles.remove(s);
		} else {
			System.out.println("Le spectacle n'est pas présent dans la liste");
		}
	}
	
	public void enleverUnSpectacle(Spectacle s) {
		if (s != null) {
			this.enleveSpectacle(s);
		} else {
			System.out.println("Le spectacle à ajouter est null");
		}
	}
}
