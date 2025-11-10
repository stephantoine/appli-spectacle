package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Client {
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String mail;
	private String numero;
	private ArrayList<Reservation> listeReservations;
	
	public Client(String nom, String prenom, String adresse, String tel, String mail, String numero) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
		this.numero = numero;
		this.listeReservations = new ArrayList<Reservation>();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String toString() {
		return this.nom + " " + this.prenom + " habite à " + this.adresse + "\nTel : " + this.tel + "\nMail : " + this.mail + "\nNumero client : " + this.numero;
	}
	
	public void afficher() {
		System.out.println("-------------\nClient : " + this.toString());
	}
	
	public boolean equals(Client other) {
		boolean res = false;
		if(this.numero == other.getNumero()){
			res = true;
		}
		return res;
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

	public void ajouterUneNouvelleReservation(Reservation r) {
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
