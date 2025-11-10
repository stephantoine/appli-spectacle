package modele;

import java.text.ParseException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Donnees {
	static private ObservableList<ResaLot5> lesResa = FXCollections.observableArrayList();

	@SuppressWarnings("unused")
	static public void chargementDonnees() throws ParseException { 
		Client cli1 = new Client("Girard", "Benji", "crous Lannion", "0606060606", "benji@gmail.com", "1");
		Client cli2 = new Client("Antoine", "Stephane", "Lannion", "0606060606", "benji@gmail.com", "2");

		Abonné a1 = new Abonné();
		
		Senior s1 = new Senior();
		Senior s2 = new Senior();
		
		Adulte ad1 = new Adulte();
		Adulte ad2 = new Adulte();
		
		Groupe g1 = new Groupe();
		Groupe g2 = new Groupe();
		
		Jeune j1 = new Jeune();
		Jeune j2 = new Jeune();
		
		Zone zone1 = new Zone("Balcon");
		Zone zone2 = new Zone("Orchestre");
		Zone zone3 = new Zone("Droite");
		
		Representation repr1 = new Representation("15/06/24", "14h", false);
		Representation repr2 = new Representation("15/06/24", "18h", false);
		Representation repr3 = new Representation("16/06/24", "10h", false);
		
		Fauteuil faut1 = new Fauteuil("1", "b1", zone1);
		Fauteuil faut2 = new Fauteuil("2", "o5", zone2);	
		Fauteuil faut3 = new Fauteuil("3", "d4", zone3);
		Fauteuil faut4 = new Fauteuil("2", "b4", zone1);		
		Fauteuil faut5 = new Fauteuil("5", "o7", zone2);		
		Fauteuil faut6 = new Fauteuil("7", "d2", zone3);		
		Fauteuil faut7 = new Fauteuil("2", "b3", zone1);		
		Fauteuil faut8 = new Fauteuil("2", "b2", zone2);		
		Fauteuil faut9 = new Fauteuil("1", "d3", zone3);
		
		
		Musique musique1 = new Musique("La musique de jojo");
		Artiste artiste1 = new Artiste("Steph");
		Spectacle spectacle1 = new Spectacle("Jojoland", 75, 200, musique1, artiste1, zone1, repr1);
		Spectacle spectacle2 = new Spectacle("Stephland", 75, 200, musique1, artiste1, zone3, repr2);
		
		Reservation r1 = new Reservation("1", "08/06/2024", "08/06/2024", repr1, cli1);
		
		Billet billet1 = new Billet("001", faut1, r1, j1);
		Billet billet2 = new Billet("002", faut2, r1, a1);
		Billet billet3 = new Billet("003", faut3, r1, g1);
		
		r1.ajouterUnNouveauBillet(billet1);
		r1.ajouterUnNouveauBillet(billet2);
		r1.ajouterUnNouveauBillet(billet3);
		
		
		Reservation r2 = new Reservation("2", "10/06/2024", "10/06/2024", repr2, cli1);
		
		Billet billet4 = new Billet("004", faut4, r2, s1);
		Billet billet5 = new Billet("005", faut5, r2, ad1);
		Billet billet6 = new Billet("006", faut6, r2, s2);
		
		r2.ajouterUnNouveauBillet(billet4);
		r2.ajouterUnNouveauBillet(billet5);
		r2.ajouterUnNouveauBillet(billet6);
		
		Reservation r3 = new Reservation("3", "12/06/2024", "12/06/2024", repr3, cli2);
		
		Billet billet7 = new Billet("007", faut7, r3, ad2);
		Billet billet8 = new Billet("008", faut8, r3, g2);
		Billet billet9 = new Billet("009", faut9, r3, j2);
		
		r3.ajouterUnNouveauBillet(billet7);
		r3.ajouterUnNouveauBillet(billet8);
		r3.ajouterUnNouveauBillet(billet9);
		
		CB paiementCb = new CB(true);
		Liquide paiementL = new Liquide(true);
		Chèque paiementCheque = new Chèque(false);
		
		Facture f1 = new Facture("154", 15.0, 4.0, paiementCb, r1);
		Facture f2 = new Facture("155", 150.0, 25.0, paiementL, r2);
		Facture f3 = new Facture("156", 30, 7.0, paiementCheque, r3);
		
		Tarif tarif1 = new Tarif(15.0, spectacle1, zone1);
		Tarif tarif2 = new Tarif(25.0, spectacle1, zone2);
		Tarif tarif3 = new Tarif(5.0, spectacle2, zone3);
		
		ResaLot5 res1 = r1.faireResa();
		ResaLot5 res2 = r2.faireResa();
		ResaLot5 res3 = r3.faireResa();
		
		lesResa.add(res1);
		lesResa.add(res2);
		lesResa.add(res3);
	}
	
	
	static public ArrayList<ResaLot5> getLesResa() {
		ArrayList<ResaLot5> lesReservations = new ArrayList<ResaLot5>();
		for(int i=0 ; i<lesResa.size() ; i++) {
			lesReservations.add(lesResa.get(i));
		}
		return lesReservations;
	}
	
	static public void listerReservations(ArrayList<ResaLot5> lesReservations) {
		for(int i=0; i<lesReservations.size(); i++) {
			lesReservations.get(i).afficher();
		}
	}
	
	static public ObservableList<ResaLot5> getLesReservations() {
		return lesResa;
	}
	
	static public void ajouterResa(ResaLot5 a) {
		lesResa.add(a);
	}
	
	static public void supprimerResa(ResaLot5 a) {
		boolean trouve = false;
		int i=0;
		while (!trouve && i<lesResa.size()) {
			if (lesResa.get(i).equals(a)){
				lesResa.remove(i);
				trouve = true;
			}
			i++;
		}
	}
}