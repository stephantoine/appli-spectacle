package modele;

import javafx.beans.property.*;

public class ResaLot5 {
	private final StringProperty dateResa;
	private final StringProperty dateHeureRepresentation;
	private final IntegerProperty nbBilletsJeunes;
	private final IntegerProperty nbBilletsSeniors;
	private final IntegerProperty nbBilletsGroupes;
	private final IntegerProperty nbBilletsAdultes;
	private final IntegerProperty nbBilletsAbonnes;
	private final DoubleProperty CAAbonnes;
	private final DoubleProperty CAAdulte;
	private final DoubleProperty CAGroupes;
	private final DoubleProperty CASeniors;
	private final DoubleProperty CAJeunes;
	private final DoubleProperty CATotal;
	private final BooleanProperty etatPaiement;
	private Reservation resa;
	
	
	public ResaLot5(String dateResa, String dateHeureRepresentation, int nbBilletsJeunes, int nbBilletsSeniors, int nbBilletsGroupes, int nbBilletsAdultes, int nbBilletsAbonnes, double cAAbonnes, double cAAdulte, double cAGroupes, double cASeniors, double cAJeunes, double cATotal, boolean etatPaiement) {
		this.dateResa = new SimpleStringProperty(dateResa);
		this.dateHeureRepresentation = new SimpleStringProperty(dateHeureRepresentation);
		this.nbBilletsJeunes = new SimpleIntegerProperty(nbBilletsJeunes);
		this.nbBilletsSeniors = new SimpleIntegerProperty(nbBilletsSeniors);
		this.nbBilletsGroupes = new SimpleIntegerProperty(nbBilletsGroupes);
		this.nbBilletsAdultes = new SimpleIntegerProperty(nbBilletsAdultes);
		this.nbBilletsAbonnes = new SimpleIntegerProperty(nbBilletsAbonnes);
		this.CAAbonnes = new SimpleDoubleProperty(cAAbonnes);
		this.CAAdulte = new SimpleDoubleProperty(cAAdulte);
		this.CAGroupes = new SimpleDoubleProperty(cAGroupes);
		this.CASeniors = new SimpleDoubleProperty(cASeniors);
		this.CAJeunes = new SimpleDoubleProperty(cAJeunes);
		this.CATotal = new SimpleDoubleProperty(cATotal);
		this.etatPaiement = new SimpleBooleanProperty(etatPaiement);
	}


	public StringProperty getPropertyDateResa() {
		return dateResa;
	}

	public void setDateResa(String dateResa) {
		this.dateResa.set(dateResa);
	}
	
	public String getDateResa() {
		return this.dateResa.get();
	}
	
	public String getDateHeureRepresentation() {
		return dateHeureRepresentation.get();
	}

	public void setDateHeureRepresentation(String dateHeureRepresentation) {
		this.dateHeureRepresentation.set(dateHeureRepresentation);
	}
	
	public StringProperty getPropertyDateHeureRepresentation() {
		return dateHeureRepresentation;
	}
	
	public int getNbBilletsJeunes() {
		return nbBilletsJeunes.get();
	}

	public void setNbBilletsJeunes(int nbBilletsJeunes) {
		this.nbBilletsJeunes.set(nbBilletsJeunes);
	}
	
	public IntegerProperty getPropertyNbBilletsJeunes() {
		return nbBilletsJeunes;
	}
	


	public int getNbBilletsSeniors() {
		return nbBilletsSeniors.get();
	}

	public void setNbBilletsSeniors(int nbBilletsSeniors) {
		this.nbBilletsSeniors.set(nbBilletsSeniors);
	}
	
	public IntegerProperty getPropertyNbBilletsSeniors() {
		return nbBilletsSeniors;
	}
	


	public int getNbBilletsGroupes() {
		return nbBilletsGroupes.get();
	}

	public void setNbBilletsGroupes(int nbBilletsGroupes) {
		this.nbBilletsGroupes.set(nbBilletsGroupes);
	}
	
	public IntegerProperty getPropertyNbBilletsGroupes() {
		return nbBilletsGroupes;
	}
	


	public int getNbBilletsAdultes() {
		return nbBilletsAdultes.get();
	}

	public void setNbBilletsAdultes(int nbBilletsAdultes) {
		this.nbBilletsAdultes.set(nbBilletsAdultes);
	}
	
	public IntegerProperty getPropertyNbBilletsAdultes() {
		return nbBilletsAdultes;
	}

	

	public int getNbBilletsAbonnes() {
		return nbBilletsAbonnes.get();
	}

	public void setNbBilletsAbonnes(int nbBilletsAbonnes) {
		this.nbBilletsAbonnes.set(nbBilletsAbonnes);
	}
	
	public IntegerProperty getPropertyNbBilletsAbonnes() {
		return nbBilletsAbonnes;
	}


	
	public double getCAAbonnes() {
		return CAAbonnes.get();
	}

	public void setCAAbonnes(double cAAbonnes) {
		CAAbonnes.set(cAAbonnes);
	}
	
	public DoubleProperty getPropertyCAAbonnes() {
		return CAAbonnes;
	}


	
	public double getCAAdulte() {
		return CAAdulte.get();
	}

	public void setCAAdulte(double cAAdulte) {
		CAAdulte.set(cAAdulte);
	}

	public DoubleProperty getPropertyCAAdultes() {
		return CAAdulte;
	}
	

	
	public double getCAGroupes() {
		return CAGroupes.get();
	}

	public void setCAGroupes(double cAGroupes) {
		CAGroupes.set(cAGroupes);
	}
	
	public DoubleProperty getPropertyCAGroupes() {
		return CAGroupes;
	}


	
	public double getCASeniors() {
		return CASeniors.get();
	}

	public void setCASeniors(double cASeniors) {
		CASeniors.set(cASeniors);
	}
	
	public DoubleProperty getPropertyCASeniors() {
		return CASeniors;
	}
	
	


	public double getCAJeunes() {
		return CAJeunes.get();
	}

	public void setCAJeunes(double cAJeunes) {
		CAJeunes.set(cAJeunes);
	}
	
	public DoubleProperty getPropertyCAJeunes() {
		return CAJeunes;
	}

	

	public double getCATotal() {
		return CATotal.get();
	}
	
	public void setCATotal(double cATotal) {
		CATotal.set(cATotal);
	}
	
	public DoubleProperty getPropertyCATotal() {
		return CATotal;
	}

	

	public boolean isEtatPaiement() {
		return etatPaiement.get();
	}

	public void setEtatPaiement(boolean etatPaiement) {
		this.etatPaiement.set(etatPaiement);
	}
	
	public BooleanProperty getPropertyEtatPaiement() {
		return etatPaiement;
	}
	
	public void ajouterResa(Reservation r) {
		this.setResa(r);
	}


	public Reservation getResa() {
		return resa;
	}


	public void setResa(Reservation resa) {
		this.resa = resa;
	}
	
	public void afficher() {
		System.out.println(this.getDateResa()+" "+this.getDateHeureRepresentation()+" "+this.etatPaiement);
	}


}
