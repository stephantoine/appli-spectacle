package modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Fauteuil {
	private String rangee;
	private String numero;
	private Zone zone;
	private ArrayList<Billet> listeBillets;
	
	public Fauteuil(String r, String n, Zone z) {
		this.rangee = r;
		this.numero = n;
		this.ajouterZone(z);
		this.listeBillets = new ArrayList<Billet>();
	}
	
	public String getRangee() {
		return rangee;
	}

	public void setRangee(String rangee) {
		this.rangee = rangee;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Zone getZone() {
		return zone;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public ArrayList<Billet> getListeBillets() {
		return listeBillets;
	}

	public void setListeBillets(ArrayList<Billet> listeBillets) {
		this.listeBillets = listeBillets;
	}

	public void afficher() {
		System.out.println("Fauteuil à l'emplacement " + this.rangee + ", " + this.numero);
	}
	
	public boolean equals(Fauteuil other) {
		return this.rangee == other.getNumero() && this.rangee == other.getRangee();
	}
	
	public void ajouterZone(Zone z) {
		if(z != null) {
			this.affecterZone(z);
		} else {
			System.out.println("La zone passée en paramètre est null");
		}
	}
	
	private void affecterZone(Zone z) {
		if(this.zone == null) {
			this.zone = z;
		} else {
			System.out.println("Une zone a déjà été attribuée pour ce tarif");
		}
	}
	
	public void enleverZone(Zone z) {
		if(z != null) {
			this.desaffecterZone(z);
		} else {
			System.out.println("La zone à enlever est null");
		}
	}
	
	private void desaffecterZone(Zone z) {
		if(this.zone !=null && this.zone.equals(z)) {
			this.zone = null;
		} else {
			System.out.println("La zone à enlever n'est pas identique à celle attribuée au tarif");
		}
	}
	
	public void listerBillets() {
		System.out.println("Liste des billets :");

		Iterator<Billet> it = this.listeBillets.iterator();

		while (it.hasNext()) {
			Billet current = it.next();
			current.afficher();
		}
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
}
