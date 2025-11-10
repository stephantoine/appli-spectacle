package modele;

import java.util.Date;

public class AnnulationClient extends Annulation{

	public AnnulationClient(Date d, boolean remboursementEffectue, Reservation r) {
		super(d, remboursementEffectue, r);
	}
	
	public void afficher() {
		super.afficher();
	}
}