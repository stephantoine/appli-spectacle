package modele;

public class Liquide extends Paiement {
	
	
	public Liquide(boolean realise) {
		super(realise);
	}

	public void affiche() {
		System.out.println("Le paiement en liquide "+ super.toString());
	}
}
