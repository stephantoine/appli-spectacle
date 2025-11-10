package modele;

public class Paiement {

	private boolean realise;	
	private Facture facture;
	
	public Paiement(boolean realise) {
		this.realise=realise;
	}
	
	public String toString() {
		System.out.println("-------------");
		if(realise=true) {
			return "est réalisé, "+ facture.toString();
		}
		else {
			return "n'est pas réalisé, "+facture.toString();
		}
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public boolean getRealise() {
		return realise;
	}
	
	public void setRealise(boolean realise) {
		this.realise=realise;
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
			System.out.println("Une facture a déjà été attribuée pour cette représentation");
		}
	}
	
	public void enleverFacture(Facture f) {
		if(f != null) {
			this.desaffecterFacture(f);
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
}