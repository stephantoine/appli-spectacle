package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Representation {
	private String jour;
	private String heure;
	private boolean annulée;
	private Spectacle spectacle;
	private ArrayList<Reservation> listeReservations;
	
	public Representation(String j, String h, boolean a) {
		this.jour = j;
		this.heure = h;
		this.annulée = a;
		this.listeReservations = new ArrayList<Reservation>();
	}

	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public boolean isAnnulée() {
		return annulée;
	}

	public void setAnnulée(boolean annulée) {
		this.annulée = annulée;
	}
	
	public Spectacle getSpectacle() {
		return spectacle;
	}

	public void setSpectacle(Spectacle spectacle) {
		this.spectacle = spectacle;
	}

	public String toString() {
		return "Représentation du " + this.jour + " à " + this.heure;
	}
	
	public void afficher() {
		System.out.println("-------------");
		System.out.println(this.toString());
		if(this.annulée) {
			System.out.println("Représentation annulée...");
		}
	}
	
	public boolean equals(Representation other) {
		boolean res = false;
		if(this.jour.equals(other.getJour()) && this.heure.equals(other.getHeure())) {
			res = true;
		}
		return res;
	}
	
	public void ajouterSpectacle(Spectacle s) {
		if(s != null) {
			this.affecterSpectacle(s);
		} else {
			System.out.println("Le spectacle passé en paramètre est null");
		}
	}
	
	private void affecterSpectacle(Spectacle s) {
		if(this.spectacle == null) {
			this.spectacle = s;
		} else {
			System.out.println("Un spectacle a déjà été attribué pour cette représentation");
		}
	}
	
	public void enleverSpectacle(Spectacle s) {
		if(s != null) {
			this.desaffecterSpectacle(s);
		} else {
			System.out.println("Le spectacle à enlever est null");
		}
	}
	
	private void desaffecterSpectacle(Spectacle s) {
		if(this.spectacle !=null && this.spectacle.equals(s)) {
			this.spectacle = null;
		} else {
			System.out.println("Le spectacle à enlever n'est pas identique à celui attribué pour la représentation");
		}
	}
	
	public void listerReservations() {
		System.out.println("Liste des reservations :");

		Iterator<Reservation> it = this.listeReservations.iterator();

		while (it.hasNext()) {
			Reservation current = it.next();
			current.afficher();
		}
	}
	
	private boolean contientReservation(Reservation r) {
		return this.listeReservations.contains(r);
	}
	
	private void ajouterReservation(Reservation r) {
		if (this.listeReservations != null) {
			this.listeReservations.add(r);
		}
	}

	public void ajouterUnNouveauBillet(Reservation r) {
		if (r != null && !this.contientReservation(r)) {
			this.ajouterReservation(r);
		}
	}
	
	private void enleveReservation(Reservation r) {
		if (this.listeReservations != null && this.contientReservation(r)) {
			this.listeReservations.remove(r);
		} else {
			System.out.println("La reservation n'est pas présent dans la liste");
		}
	}
	
	public void enleverUnReservation(Reservation r) {
		if (r != null) {
			this.enleveReservation(r);
		} else {
			System.out.println("La reservation à ajouter est null");
		}
	}
	
}
