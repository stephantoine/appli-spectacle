package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Reservation {
	private String numero;
	private String date;
	private String dateEnvoiConf;
	private Representation representation;
	private Client client;
	private ArrayList<Billet> listeBillets;
	private Annulation annulation;
	private Facture facture;
	private ResaLot5 resa2;
	
	public Reservation(String n, String date, String dateEnvoiConf, Representation r, Client c) {
		this.numero = n;
		this.date = date;
		this.dateEnvoiConf = dateEnvoiConf;
		this.ajouterRepresentation(r);
		this.ajouterClient(c);
		this.listeBillets = new ArrayList<Billet>();
		this.annulation = null;
		this.facture = null;
		this.resa2 = null;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDateEnvoiConf() {
		return dateEnvoiConf;
	}

	public void setDateEnvoiConf(String dateEnvoiConf) {
		this.dateEnvoiConf = dateEnvoiConf;
	}
	
	public ResaLot5 getResa2() {
		return resa2;
	}

	public void setResa2(ResaLot5 resa2) {
		this.resa2 = resa2;
	}

	public Representation getRepresentation() {
		return representation;
	}

	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ArrayList<Billet> getListeBillets() {
		return listeBillets;
	}

	public void setListeBillets(ArrayList<Billet> listeBillets) {
		this.listeBillets = listeBillets;
	}

	public Annulation getAnnulation() {
		return annulation;
	}

	public void setAnnulation(Annulation annulation) {
		this.annulation = annulation;
	}
	
	public void afficher() {
		System.out.println("-------------");
		System.out.println("Reservation : " + this.numero + " faite le " + this.date + ". La confirmation de réservation a été faite le " + this.dateEnvoiConf);
		if(this.representation != null) {
			this.representation.afficher();			
		} else {
			System.out.println("Aucune représentation attribuée");
		}
		if(this.client != null) {
			this.client.afficher();
		} else {
			System.out.println("Aucun client attribué");
		}
		if(this.listeBillets.size() > 0) {
			this.listerBillets();
		} else {
			System.out.println("Pas de billets");
		}
		if(this.annulation != null) {
			this.annulation.afficher();
		} else {
			System.out.println("Réservation non annulée");
		}
	}
	
	public boolean equals(Reservation other) {
		boolean res = false;
		if(this.numero == other.getNumero()) {
			res = true;
		}
		return res;
	}
	
	public void ajouterRepresentation(Representation r) {
		if(r != null) {
			this.affecterRepresentation(r);
		} else {
			System.out.println("La representation passée en paramètre est null");
		}
	}
	
	private void affecterRepresentation(Representation r) {
		if(this.representation == null) {
			this.representation = r;
		} else {
			System.out.println("Une representation a déjà été attribué pour cette réservation");
		}
	}
	
	public void enleverRepresentation(Representation r) {
		if(r != null) {
			this.desaffecterRepresentation(r);
		} else {
			System.out.println("La représentation à enlever est null");
		}
	}
	
	private void desaffecterRepresentation(Representation r) {
		if(this.representation !=null && this.representation.equals(r)) {
			this.representation = null;
		} else {
			System.out.println("La representation à enlever n'est pas identique à celle attribuée à la réservation");
		}
	}
	
	public void ajouterClient(Client c) {
		if(c != null) {
			this.affecterClient(c);
		} else {
			System.out.println("Le client passée en paramètre est null");
		}
	}
	
	private void affecterClient(Client c) {
		if(this.client == null) {
			this.client = c;
			c.ajouterUneNouvelleReservation(this);
		} else {
			System.out.println("Un client a déjà été attribué pour cette réservation");
		}
	}
	
	public void enleverClient(Client c) {
		if(c != null) {
			this.desaffecterClient(c);
		} else {
			System.out.println("Le cilent à enlever est null");
		}
	}
	
	private void desaffecterClient(Client c) {
		if(this.client !=null && this.client.equals(c)) {
			this.client = null;
		} else {
			System.out.println("Le client à enlever n'est pas identique à celui attribué à la réservation");
		}
	}
	
	public void listerBillets() {
		System.out.println("-------------");
		System.out.println("Liste des billets :");

		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			current.afficher();
		}
	}
	
	public int nbBilletsJeunes() {
		int somme = 0;
		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			if(current.getTarification().getId().equals("Jeune")) {
				somme += 1;
			}
		}
		return somme;
	}
	
	public int nbBilletsSeniors() {
		int somme = 0;
		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			if(current.getTarification().getId().equals("Senior")) {
				somme += 1;
			}
		}
		return somme;
	}
	
	public int nbBilletsGroupes() {
		int somme = 0;
		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			if(current.getTarification().getId().equals("Groupe")) {
				somme += 1;
			}
		}
		return somme;
	}
	
	public int nbBilletsAdultes() {
		int somme = 0;
		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			if(current.getTarification().getId().equals("Adulte")) {
				somme += 1;
			}
		}
		return somme;
	}
	
	public int nbBilletsAbonnes() {
		int somme = 0;
		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			if(current.getTarification().getId().equals("Abonne")) {
				somme += 1;
			}
		}
		return somme;
	}
	
	
	public double CAJeunes() {
		double somme = 0.0;
		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			if(current.getTarification().getId().equals("Jeune")) {
				somme += current.getFauteuil().getZone().getTarif().getPleinTarif()*Jeune.getReduction();
			}
		}
		return somme;
	}
	
	public double CASeniors() {
		double somme = 0.0;
		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			if(current.getTarification().getId().equals("Senior")) {
				somme += current.getFauteuil().getZone().getTarif().getPleinTarif()*Senior.getReduction();
			}
		}
		return somme;
	}
	
	public int CAAdultes() {
		int somme = 0;
		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			if(current.getTarification().getId().equals("Adulte")) {
				somme += current.getFauteuil().getZone().getTarif().getPleinTarif() * Adulte.getReduction();
			}
		}
		return somme;
	}
	
	public double CAGroupes() {
		double somme = 0.0;
		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			if(current.getTarification().getId().equals("Groupe")) {
				somme += current.getFauteuil().getZone().getTarif().getPleinTarif() * Groupe.getReduction();
			}
		}
		return somme;
	}
	
	public double CAAbonnes() {
		double somme = 0.0;
		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			if(current.getTarification().getId().equals("Abonne")) {
				somme += current.getFauteuil().getZone().getTarif().getPleinTarif() * Abonné.getReduction();
			}
		}
		return somme;
	}
	
	
	
	private boolean contientBillet(Billet b) {
		return this.listeBillets.contains(b);
	}
	
	private void ajouterBillet(Billet b) {
		if (this.listeBillets != null) {
			this.listeBillets.add(b);
		}
	}

	public void ajouterUnNouveauBillet(Billet b) {
		if (b != null && !this.contientBillet(b)) {
			this.ajouterBillet(b);
		}
	}
	
	private void enleveBillet(Billet b) {
		if (this.listeBillets != null && this.contientBillet(b)) {
			this.listeBillets.remove(b);
		} else {
			System.out.println("Le billet n'est pas présent dans la liste");
		}
	}
	
	public void enleverUnBillet(Billet b) {
		if (b != null) {
			this.enleveBillet(b);
		} else {
			System.out.println("Le billet à ajouter est null");
		}
	}
	
	public void ajouterAnnulation(Annulation a) {
		if(a == null) {
			System.out.println("Il faut donner une annulation à ajouter à cette réservation");
		}else if(this.annulation == null){
			this.annulation = a;
		}else {
			System.out.println("Il y a déjà une annulation liée à cette réservation");
		}
	}
	
	public void supprimerAnnulation(Annulation a) {
		if(a == null) {
			System.out.println("Il faut donner une annulation à supprimer de cette réservation");
		}else if(this.annulation != null){
			this.annulation = null;
		}else {
			System.out.println("Il n'y a pas d'annulation liée à cette réservation");
		}
	}
	
	public void ajouterFacture(Facture f) {
		if(f != null) {
			this.affecterFacture(f);
		} else {
			System.out.println("La facture passée en paramètre est null");
		}
	}
	
	private void affecterFacture(Facture f) {
		if(this.facture == null) {
			this.facture = f;
		} else {
			System.out.println("Une facture a déjà été attribuée pour cette réservation");
		}
	}
	
	public void enleverFacture(Facture g) {
		if(g != null) {
			this.desaffecterFacture(g);
		} else {
			System.out.println("La facture à enlever est null");
		}
	}
	
	private void desaffecterFacture(Facture f) {
		if(this.facture !=null && this.facture.equals(f)) {
			this.facture = null;
		} else {
			System.out.println("La facture à enlever n'est pas identique à celle attribuée pour la représentation");
		}
	}
	
	public ResaLot5 faireResa() {
		this.resa2 = new ResaLot5(this.date, this.representation.getJour() + " " + this.representation.getHeure(), this.nbBilletsJeunes(), this.nbBilletsSeniors(), this.nbBilletsGroupes(), this.nbBilletsAdultes(), this.nbBilletsAbonnes(), this.CAAbonnes(), this.CAAdultes(), this.CAGroupes(), this.CASeniors(), this.CAJeunes(), this.CAAbonnes()+this.CAAdultes()+this.CAGroupes()+this.CASeniors()+this.CAJeunes(), this.facture.getPaiement().getRealise());
		resa2.ajouterResa(this);
		return resa2;
	}
}
