package controleur;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modele.Donnees;
import modele.ResaLot5;
import modele.Reservation;
import vue.FenListeReservations;
import vue.FenPlanSalle;
import vue.FenPlanSalleApresSuppr;
import vue.FenRechercherResa;

public class Main extends Application {
	static private FenListeReservations fListe;
	static private FenRechercherResa fRecherche;
	static private FenPlanSalle fPlan;
	static private FenPlanSalleApresSuppr fPlanSuppr;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Donnees.chargementDonnees();
		fListe = new FenListeReservations();
		fRecherche = new FenRechercherResa();
		fPlan = new FenPlanSalle();
		fPlanSuppr = new FenPlanSalleApresSuppr();
		fPlan.initModality(Modality.APPLICATION_MODAL);
		Main.ouvrirFenRechercher();
	}
	
	//////////////////////////////////////////////////////////
	// Gestion des fenêtres
	//////////////////////////////////////////////////////////

	public static void ouvrirFenRechercher() {
		fRecherche.show();
		fListe.close();
	}
	
	public static void ouvrirListe() {
		fListe.show();
		Main.fermerRecherche();
	}
	
	static public void ouvrirFenPlanSalle(String dateHeureRepresentation, ArrayList<ResaLot5> listeResa, String etatPaiement, String dateReservation, double caTotalReservation, Reservation reservation, double caAdultes, double caAbonne, double caGroupe, double caSenior, double caJeune, int nbBilletsAdultes, int nbBilletsAbonnes, int nbBilletsSeniors, int nbBilletsGroupes, int nbBilletsJeunes) {
		fPlan.afficher(dateHeureRepresentation, etatPaiement, dateReservation, caTotalReservation);
		fPlan.set(reservation, listeResa, caAdultes, caAbonne, caGroupe, caSenior, caJeune, nbBilletsAdultes, nbBilletsAbonnes, nbBilletsSeniors, nbBilletsGroupes, nbBilletsJeunes);
		fPlan.show();
	}
	
	public static void fermerPlanSalle() {
		fPlan.close();
	}
	
	public static void fermerRecherche() {
		fRecherche.close();
	}
	
	public static void fermerListe() {
		fListe.close();
	}
	
	public static void fermerPlanSalleApresSuppr() {
		fPlanSuppr.close();
	}
	
	public static void fermerAppli() {
		System.exit(0);
	}
	
	public static void rechercheClient(String nom, String ville) {
		boolean trouve = false;
		for(int i=0; i<Donnees.getLesResa().size(); i++) {
			if(Donnees.getLesResa().get(i).getResa().getClient().getNom().equals(nom) && Donnees.getLesResa().get(i).getResa().getClient().getAdresse().contains(ville)) {
				Main.ouvrirListe();
				Main.fermerRecherche();
				trouve = true;
			}
		}
		if(trouve == false) {
			Alert alert = new Alert(
				AlertType.ERROR,
				"Le client demandé n'a pas effectué de reservation",
				ButtonType.OK
			);
			alert.setTitle("Erreur avec le client");
			alert.showAndWait();
		}
	}
	
	//////////////////////////////////////////////////////////
	// Mise à jour des données
	//////////////////////////////////////////////////////////

	
	public static void supprimerReserv(ResaLot5 r) {
		Donnees.supprimerResa(r);
		fPlan.close();
		fPlan.majPlan();
		fPlanSuppr.majPlan();
		fPlanSuppr.set(Donnees.getLesResa());
		fPlanSuppr.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}