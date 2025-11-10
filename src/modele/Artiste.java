package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Artiste {
	private String nom;
	private ArrayList<Spectacle> listeSpectacles;
	
	public Artiste(String n) {
		this.nom = n;
		this.listeSpectacles = new ArrayList<Spectacle>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void afficher() {
		System.out.println(this.nom);
	}
	
	public boolean equals(Artiste other) {
		return this.nom.equals(other.getNom());
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
			s.ajouterUnNouvelArtiste(this);
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
			s.enleverUnArtiste(this);
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
