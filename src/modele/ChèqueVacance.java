package modele;

public class ChèqueVacance extends Paiement {
	
	
	public ChèqueVacance(boolean realise) {
		super(realise);
	}

	public void affiche() {
		System.out.println("Le paiement en chèque vacance "+ super.toString());
	}
}

