package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Zone {
	private String nom;
	private ArrayList<Spectacle> listeSpectacles;
	private Tarif tarif;
	
	public Tarif getTarif() {
		return tarif;
	}

	public void setTarif(Tarif tarif) {
		this.tarif = tarif;
	}

	public Zone(String nom) {
		this.nom = nom;
		this.listeSpectacles = new ArrayList<Spectacle>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void afficher() {
		System.out.println("Zone " + this.nom);
	}
	
	public boolean equals(Zone other) {
		return this.nom.equals(other.nom);
	}
	
	public void ajouterTarif(Tarif t) {
		if(t != null) {
			this.affecterTarif(t);
		} else {
			System.out.println("La tarif passée en paramètre est null");
		}
	}
	
	private void affecterTarif(Tarif t) {
		if(this.tarif == null) {
			this.tarif = t;
		} else {
			System.out.println("Un tarif a déjà été attribuée pour cette zone");
		}
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
