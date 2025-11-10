package modele;

import java.util.Date;

public class AnnulationArtiste extends Annulation{
	
	public AnnulationArtiste(Date d, boolean remboursementEffectue, Reservation r) {
		super(d, remboursementEffectue, r);
	}
	
	public void afficher() {
		super.afficher();
	}
}
