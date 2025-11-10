package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Spectacle {
	private String nom;
	private int duree;
	private int nbreMaxSpect;
	private Genre genre;
	private ArrayList<Artiste> listeArtistes;
	private ArrayList<Zone> listeZones;
	private ArrayList<Representation> listeRepresentations;
	
	public Spectacle(String nom, int duree, int nbreMaxSpect, Genre genre, Artiste a, Zone z, Representation r) {
		this.nom = nom;
		this.duree = duree;
		this.nbreMaxSpect = nbreMaxSpect;
		this.ajouterGenre(genre);
		this.listeArtistes = new ArrayList<Artiste>();
		this.ajouterUnNouvelArtiste(a);
		this.listeZones = new ArrayList<Zone>();
		this.ajouterUneNouvelleZone(z);
		this.listeRepresentations = new ArrayList<Representation>();
		this.ajouterUneNouvelleRepresentation(r);
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public int getNbreMaxSpect() {
		return nbreMaxSpect;
	}

	public void setNbreMaxSpect(int nbreMaxSpect) {
		this.nbreMaxSpect = nbreMaxSpect;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public ArrayList<Artiste> getListeArtistes() {
		return listeArtistes;
	}

	public void setListeArtistes(ArrayList<Artiste> listeArtistes) {
		this.listeArtistes = listeArtistes;
	}

	public ArrayList<Zone> getListeZones() {
		return listeZones;
	}

	public void setListeZones(ArrayList<Zone> listeZones) {
		this.listeZones = listeZones;
	}

	public String toString() {
		return "Spectacle " + this.nom + "\nDurée : " + this.duree + "\nNombre maximum de spectateurs";
	}
	
	public void afficher() {
		System.out.println("-------------");
		System.out.println(this.toString());
	}
	
	public boolean equals(Spectacle other) {
		boolean res = false;
		if(this.nom.equals(other.getNom())) {
			res = true;
		}
		return res;
	}
	
	public void ajouterGenre(Genre g) {
		if(g != null) {
			this.affecterGenre(g);
		} else {
			System.out.println("Le genre passé en paramètre est null");
		}
	}
	
	private void affecterGenre(Genre g) {
		if(this.genre == null) {
			this.genre = g;
		} else {
			System.out.println("Un genre a déjà été attribué pour ce spectacle");
		}
	}
	
	public void enleverGenre(Genre g) {
		if(g != null) {
			this.desaffecterGenre(g);
		} else {
			System.out.println("Le genre à enlever est null");
		}
	}
	
	private void desaffecterGenre(Genre g) {
		if(this.genre !=null && this.genre.equals(g)) {
			this.genre = null;
		} else {
			System.out.println("Le genre à enlever n'est pas identique à celui attribué au spectacle");
		}
	}
	
	public void listerArtistes() {
		System.out.println("Liste des artistes :");

		Iterator<Artiste> it = this.listeArtistes.iterator();

		while (it.hasNext()) {
			Artiste current = it.next();
			current.afficher();
		}
	}

	private boolean contientArtiste(Artiste a) {
		return this.listeArtistes.contains(a);
	}
	
	private void ajouterArtiste(Artiste a) {
		if (this.listeArtistes != null) {
			this.listeArtistes.add(a);
			a.ajouterUnNouveauSpectacle(this);
		}
	}

	public void ajouterUnNouvelArtiste(Artiste a) {
		if (a != null && !this.contientArtiste(a)) {
			this.ajouterArtiste(a);
		}
	}
	
	private void enleveArtiste(Artiste a) {
		if (this.listeArtistes != null && this.contientArtiste(a)) {
			this.listeArtistes.remove(a);
			a.enleverUnSpectacle(this);
		} else {
			System.out.println("L'artiste n'est pas présent dans la liste");
		}
	}
	
	public void enleverUnArtiste(Artiste a) {
		if (a != null) {
			this.enleveArtiste(a);
		} else {
			System.out.println("L'artiste às ajouter est null");
		}
	}
	
	public void listerZones() {
		System.out.println("Liste des zones :");

		Iterator<Zone> it = this.listeZones.iterator();

		while (it.hasNext()) {
			Zone current = it.next();
			current.afficher();
		}
	}
	
	private boolean contientZone(Zone z) {
		return this.listeZones.contains(z);
	}
	
	private void ajouterZone(Zone z) {
		if (this.listeZones != null) {
			this.listeZones.add(z);
			z.ajouterUnNouveauSpectacle(this);
		}
	}

	public void ajouterUneNouvelleZone(Zone z) {
		if (z != null && !this.contientZone(z)) {
			this.ajouterZone(z);
		}
	}
	
	private void enleveZone(Zone z) {
		if (this.listeZones != null && this.contientZone(z)) {
			this.listeZones.remove(z);
			z.enleverUnSpectacle(this);
		} else {
			System.out.println("La zone n'est pas présent dans la liste");
		}
	}
	
	public void enleverUneZone(Zone z) {
		if (z != null) {
			this.enleveZone(z);
		} else {
			System.out.println("La zone à ajouter est null");
		}
	}
	
	public void listerRepresentations() {
		System.out.println("Liste des Representations :");

		Iterator<Representation> it = this.listeRepresentations.iterator();

		while (it.hasNext()) {
			Representation current = it.next();
			current.afficher();
		}
	}
	
	private boolean contientRepresentation(Representation r) {
		return this.listeRepresentations.contains(r);
	}
	
	private void ajouterRepresentation(Representation r) {
		if (this.listeRepresentations != null) {
			this.listeRepresentations.add(r);
			r.ajouterSpectacle(this);
		}
	}

	public void ajouterUneNouvelleRepresentation(Representation r) {
		if (r != null && !this.contientRepresentation(r)) {
			this.ajouterRepresentation(r);
		}
	}
	
	private void enleveRepresentation(Representation r) {
		if (this.listeRepresentations != null && this.contientRepresentation(r)) {
			this.listeRepresentations.remove(r);
			r.enleverSpectacle(this);
		} else {
			System.out.println("La representation n'est pas présente dans la liste");
		}
	}
	
	public void enleverUneRepresentation(Representation r) {
		if (r != null) {
			this.enleveRepresentation(r);
		} else {
			System.out.println("La representation à ajouter est null");
		}
	}
}
