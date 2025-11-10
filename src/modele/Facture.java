package modele;

public class Facture {

	private String numero;
	private double montantTTC;
	private double staticTauxTva;
	private Paiement paiement;
	private Reservation reservation;
	
	public Facture(String numero,double montantTTC,double staticTauxTva, Paiement paiement, Reservation r) {
		this.numero=numero;
		this.montantTTC=montantTTC;
		this.staticTauxTva=staticTauxTva;
		
		this.ajouterPaiement(paiement);
		this.ajouterReservation(r);
		
	}
		
	public String toString() { 
		return "Facture numéro : " +this.numero+" Montant de "+this.montantTTC+" euros  avec une TVA de "+this.staticTauxTva+" euros ";
	}
	
	public void affiche() {
		System.out.println("-------------");
		System.out.println(this.toString());
	}
	
	public Paiement getPaiement() {
		return paiement;
	}
	
	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	
	public Reservation getReservation() {
		return reservation;
	}
	
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setDate(String numero) {
		this.numero =numero;
	}
	
	public double getMontantTTC() {
		return montantTTC;
	}
	
	public void setMontantTTC(double montantTTC) {
		this.montantTTC=montantTTC;
	}
	
	public double getStaticTauxTva() {
		return staticTauxTva;
	}
	
	public void setStaticTauxTva(double staticTauxTva) {
		this.staticTauxTva=staticTauxTva;
	}
	
	public void ajouterPaiement(Paiement p) {
		if(p != null) {
			this.affecterPaiement(p);
			p.ajouterFacture(this);
		} else {
			System.out.println("Le paiement passé en paramètre est null");
		}
	}
	
	private void affecterPaiement(Paiement p) {
		if(this.paiement == null) {
			this.paiement = p;
		} else {
			System.out.println("Un paiement a déjà été attribué pour cette facture");
		}
	}
	
	public void enleverPaiement(Paiement p) {
		if(p != null) {
			this.desaffecterPaiement(p);
			p.enleverFacture(this);
		} else {
			System.out.println("Le paiement à enlever est null");
		}
	}
	
	private void desaffecterPaiement(Paiement p) {
		if(this.paiement !=null && this.paiement.equals(p)) {
			this.paiement = null;
		} else {
			System.out.println("Le paiement à enlever n'est pas identique à celui attribué pour la facture");
		}
	}
	
	public void ajouterReservation(Reservation r) {
		if(r != null) {
			this.affecterReservation(r);
		} else {
			System.out.println("La reservation passée en paramètre est null");
		}
	}
	
	private void affecterReservation(Reservation r) {
		if(this.reservation == null) {
			this.reservation = r;
			r.ajouterFacture(this);
		} else {
			System.out.println("Une réservation a déjà été attribuée pour cette facture");
		}
	}
	
	public void enleverReservation(Reservation r) {
		if(r != null) {
			this.desaffecterReservation(r);
		} else {
			System.out.println("La réservation à enlever est null");
		}
	}
	
	private void desaffecterReservation(Reservation r) {
		if(this.reservation !=null && this.reservation.equals(r)) {
			this.reservation = null;
			r.enleverFacture(this);
		} else {
			System.out.println("La réservation à enlever n'est pas identique à celle attribuée pour la représentation");
		}
	}
}