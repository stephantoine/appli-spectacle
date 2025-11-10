package modele;

import java.util.ArrayList;

public abstract class Tarification {
	private ArrayList<Billet> listeBillets;
	
	public Tarification() {
		this.listeBillets = new ArrayList<Billet>();
	}
	
	public abstract String getId();
	
	public void ajouterBillet(Billet b) {
		if(b == null) {
			System.out.println("Il faut donner un billet à ajouter");
		}else if(this.listeBillets.contains(b)==false) {
			this.listeBillets.add(b);
		}else {
			System.out.println("Le billet est déjà affecté à une tarification");
		}
	}
	
	public void supprimerBillet(Billet b) {
		if(b == null) {
			System.out.println("Il faut donner un billet à supprimer");
		}else if(this.listeBillets.contains(b)==true) {
			this.listeBillets.remove(b);
		}else {
			System.out.println("Le billet n'est pas affecté à une tarification");
		}
	}
	
	public void listerBillets() {
		for(int i=0; i<this.listeBillets.size(); i++) {
			this.listeBillets.get(i).afficher();
		}
	}
	
	public void afficher() {
		System.out.println("-------------");
		System.out.println("La liste des billets associés à cette tarification :");
		this.listerBillets();
	}

	public ArrayList<Billet> getListeBillets() {
		return listeBillets;
	}

	public void setListeBillets(ArrayList<Billet> listeBillets) {
		this.listeBillets = listeBillets;
	}
}