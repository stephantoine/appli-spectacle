package modele;

public class CB extends Paiement{
	
	public CB(boolean realise) {
		super(realise);
	}

	public void affiche() {
		System.out.println("Le paiement en CB "+ super.toString());
	}
}
