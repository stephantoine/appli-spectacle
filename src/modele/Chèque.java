package modele;

public class Chèque extends Paiement{
	
	public Chèque(boolean realise) {
		super(realise);
	}
	public void affiche() {
		System.out.println("Le paiement en chèque "+ super.toString());
	}
}
