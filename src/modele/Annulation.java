package modele;

import java.util.Date;

public abstract class Annulation {
	private Date date;
	private boolean remboursementEffectue;
	private Reservation reservation;
	
	public Annulation(Date d, boolean r, Reservation resa) {
		this.date = d;
		this.remboursementEffectue = r;
		this.ajouterReservation(resa);
		resa.setAnnulation(this);
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public boolean getRemboursementEffectue() {
		return remboursementEffectue;
	}
	
	public void setRemboursementEffectue(boolean remboursementEffectue) {
		this.remboursementEffectue = remboursementEffectue;
	}
	
	public void ajouterReservation(Reservation r) {
		if(r == null) {
			System.out.println("Il faut donner une réservation à ajouter à cette annulation");
		}else {
			this.reservation = r;
		}
	}
	
	
	public void afficher() {
		System.out.println("-------------");
		if(this.remboursementEffectue == true && this.reservation == null) {
			System.out.println("La date d'annulation : "+this.date+" le remboursement est effectué");
		} else {
			System.out.println("La date d'annulation : "+this.date+" le remboursement n'a pas été effectué");
		}
	}
}
