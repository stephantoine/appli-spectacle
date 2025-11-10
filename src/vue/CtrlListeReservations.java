
package vue;

import javafx.beans.binding.Bindings;
import modele.ResaLot5;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import controleur.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import modele.Abonné;
import modele.Adulte;
import modele.Donnees;
import modele.Groupe;
import modele.Jeune;
import modele.Reservation;
import modele.Senior;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


public class CtrlListeReservations {

    @FXML
    private Button bnSupprimer;
    @FXML
    private TableView<ResaLot5> tvListeReservations;
    @FXML
    private Button bnFermer;
    @FXML
    private Button bnRecherche;
    @FXML 
    private Button bnModifier;
    @FXML 
    private Button bnAjouter;

    @FXML void initialize() {
    	TableColumn<ResaLot5,String> colonne1 = new TableColumn<ResaLot5,String>("Date resa");
		colonne1.setCellValueFactory(new PropertyValueFactory<ResaLot5,String>("dateResa"));	
		tvListeReservations.getColumns().set(0, colonne1);
		TableColumn<ResaLot5,String> colonne2 = new TableColumn<ResaLot5,String>("Representation");
		colonne2.setCellValueFactory(new PropertyValueFactory<ResaLot5,String>("dateHeureRepresentation"));
		tvListeReservations.getColumns().set(1, colonne2);
		TableColumn<ResaLot5,Integer> colonne3 = new TableColumn<ResaLot5,Integer>("Billets Jeune");
		colonne3.setCellValueFactory(new PropertyValueFactory<ResaLot5,Integer>("nbBilletsJeunes"));
		tvListeReservations.getColumns().set(2, colonne3);
		TableColumn<ResaLot5,Integer> colonne4 = new TableColumn<ResaLot5,Integer>("Billets Senior");
		colonne4.setCellValueFactory(new PropertyValueFactory<ResaLot5,Integer>("nbBilletsSeniors"));	
		tvListeReservations.getColumns().set(3, colonne4);
		TableColumn<ResaLot5,Integer> colonne5 = new TableColumn<ResaLot5,Integer>("Billets Groupe");
		colonne5.setCellValueFactory(new PropertyValueFactory<ResaLot5,Integer>("nbBilletsGroupes"));
		tvListeReservations.getColumns().set(4, colonne5);
		TableColumn<ResaLot5,Integer> colonne6 = new TableColumn<ResaLot5,Integer>("Billets Adulte");
		colonne6.setCellValueFactory(new PropertyValueFactory<ResaLot5,Integer>("nbBilletsAdultes"));
		tvListeReservations.getColumns().set(5, colonne6);
		TableColumn<ResaLot5,Integer> colonne7 = new TableColumn<ResaLot5,Integer>("Billets Abonne");
		colonne7.setCellValueFactory(new PropertyValueFactory<ResaLot5,Integer>("nbBilletsAbonnes"));
		tvListeReservations.getColumns().set(6, colonne7);
		TableColumn<ResaLot5,Double> colonne8 = new TableColumn<ResaLot5,Double>("CA Jeune");
		colonne8.setCellValueFactory(new PropertyValueFactory<ResaLot5,Double>("CAJeunes"));
		tvListeReservations.getColumns().set(7, colonne8);
		TableColumn<ResaLot5,Double> colonne9 = new TableColumn<ResaLot5,Double>("CA Senior");
		colonne9.setCellValueFactory(new PropertyValueFactory<ResaLot5,Double>("CASeniors"));	
		tvListeReservations.getColumns().set(8, colonne9);
		TableColumn<ResaLot5,Double> colonne10 = new TableColumn<ResaLot5,Double>("CA Groupe");
		colonne10.setCellValueFactory(new PropertyValueFactory<ResaLot5,Double>("CAGroupes"));
		tvListeReservations.getColumns().set(9, colonne10);
		TableColumn<ResaLot5,Double> colonne11 = new TableColumn<ResaLot5,Double>("CA Adulte");
		colonne11.setCellValueFactory(new PropertyValueFactory<ResaLot5,Double>("CAAdulte"));
		tvListeReservations.getColumns().set(10, colonne11);
		TableColumn<ResaLot5,Double> colonne12 = new TableColumn<ResaLot5,Double>("CA Abonne");
		colonne12.setCellValueFactory(new PropertyValueFactory<ResaLot5,Double>("CAAbonnes"));
		tvListeReservations.getColumns().set(11, colonne12);
		TableColumn<ResaLot5,Double> colonne13 = new TableColumn<ResaLot5,Double>("CA Total");
		colonne13.setCellValueFactory(new PropertyValueFactory<ResaLot5,Double>("CATotal"));
		tvListeReservations.getColumns().set(12, colonne13);
		TableColumn<ResaLot5,Boolean> colonne14 = new TableColumn<ResaLot5,Boolean>("Etat paiement");
		colonne14.setCellValueFactory(new PropertyValueFactory<ResaLot5,Boolean>("etatPaiement"));
		tvListeReservations.getColumns().set(13, colonne14);
		
		tvListeReservations.setItems(Donnees.getLesReservations());
		
		//tvListeEmployes.setItems(Donnees.getLesEmployes());
		tvListeReservations.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
			
		////griser le bouton Supprimer quand aucune sélection
		BooleanBinding rien = Bindings.equal(tvListeReservations.getSelectionModel().selectedIndexProperty(), -1);
		bnSupprimer.disableProperty().bind(rien);
    }
    
    @FXML void clicFermer(ActionEvent event) {
    	Main.fermerAppli();
    }
    
    @FXML void clicRechercher(ActionEvent event) {
    	Main.ouvrirFenRechercher();
    }
    
    public int recupererNbBilletsAdultes() {
    	ResaLot5 r = tvListeReservations.getSelectionModel().getSelectedItem();
		int res = 0;
		for(int i=0; i<r.getResa().getListeBillets().size(); i++) {
			if(r.getResa().getListeBillets().get(i).getTarification().getId() == "Adulte") {
				res +=1;
			}
		}
		return res;
	}
	
	public double calculerCaAdulte() {
		double t = 0.0;
		for(int i = 0; i<tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().size(); i++) {
			if(tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().get(i).getTarification().getId().equals("Adulte")){
				t = tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().get(i).getFauteuil().getZone().getTarif().getPleinTarif();
			}
		}
		
		int nbBillets = recupererNbBilletsAdultes();
		double reduction = Adulte.getReduction();
		return nbBillets * t * reduction;
	}
	
	public int recupererNbBilletsAbonne() {
		Reservation r = tvListeReservations.getSelectionModel().getSelectedItem().getResa();
		int res = 0;
		for(int i=0; i<r.getListeBillets().size(); i++) {
			if(r.getListeBillets().get(i).getTarification().getId() == "Abonne") {
				res +=1;
			}
		}
		return res;
	}
	
	public double calculerCaAbonne() {
		double t = 0.0;
		for(int i = 0; i<tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().size(); i++) {
			if(tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().get(i).getTarification().getId().equals("Abonne")){
				t = tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().get(i).getFauteuil().getZone().getTarif().getPleinTarif();
			}
		}
		
		int nbBillets = recupererNbBilletsAbonne();
		double reduction = Abonné.getReduction();
		return nbBillets * t * reduction;
	}
	
	public int recupererNbBilletsSenior() {
		Reservation r = tvListeReservations.getSelectionModel().getSelectedItem().getResa();
		int res = 0;
		for(int i=0; i<r.getListeBillets().size(); i++) {
			if(r.getListeBillets().get(i).getTarification().getId() == "Senior") {
				res +=1;
			}
		}
		return res;
	}
	
	public double calculerCaSenior() {
		double t = 0.0;
		for(int i = 0; i<tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().size(); i++) {
			if(tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().get(i).getTarification().getId().equals("Senior")){
				t = tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().get(i).getFauteuil().getZone().getTarif().getPleinTarif();
			}
		}
		
		int nbBillets = recupererNbBilletsSenior();
		double reduction = Senior.getReduction();
		return nbBillets * t * reduction;
	}
	
	public int recupererNbBilletsJeune() {
		Reservation r = tvListeReservations.getSelectionModel().getSelectedItem().getResa();
		int res = 0;
		for(int i=0; i<r.getListeBillets().size(); i++) {
			if(r.getListeBillets().get(i).getTarification().getId() == "Jeune") {
				res +=1;
			}
		}
		return res;
	}
	
	public double calculerCaJeune() {
		double t = 0.0;
		for(int i = 0; i<tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().size(); i++) {
			if(tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().get(i).getTarification().getId().equals("Jeune")){
				t = tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().get(i).getFauteuil().getZone().getTarif().getPleinTarif();
			}
		}
	
		int nbBillets = recupererNbBilletsJeune();
		double reduction = Jeune.getReduction();
		return nbBillets * t * reduction;
	}
	
	public int recupererNbBilletsGroupe() {
		Reservation r = tvListeReservations.getSelectionModel().getSelectedItem().getResa();
		int res = 0;
		for(int i=0; i<r.getListeBillets().size(); i++) {
			if(r.getListeBillets().get(i).getTarification().getId() == "Groupe") {
				res +=1;
			}
		}
		return res;
	}
	
	public double calculerCaGroupe() {
		double t = 0.0;
		for(int i = 0; i<tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().size(); i++) {
			if(tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().get(i).getTarification().getId().equals("Groupe")){
				t = tvListeReservations.getSelectionModel().getSelectedItem().getResa().getListeBillets().get(i).getFauteuil().getZone().getTarif().getPleinTarif();
			}
		}
		int nbBillets = recupererNbBilletsGroupe();
		double reduction = Groupe.getReduction();
		return nbBillets * t * reduction;
	}
   
     //clic sur bouton Supprimer
     @FXML void clicSupprimer(ActionEvent event) {
    	 String dateResa = tvListeReservations.getSelectionModel().getSelectedItem().getResa().getDate();
    	 boolean etatPaiement = tvListeReservations.getSelectionModel().getSelectedItem().getResa().getFacture().getPaiement().getRealise();
    	 String dateHeureRepresentation = tvListeReservations.getSelectionModel().getSelectedItem().getResa().getRepresentation().getJour() + " " + tvListeReservations.getSelectionModel().getSelectedItem().getResa().getRepresentation().getHeure();
    	 Reservation resa = tvListeReservations.getSelectionModel().getSelectedItem().getResa();
    	 String paiement;
    	 
    	 ArrayList<ResaLot5> listeResa = Donnees.getLesResa();
    	 
    	 if(etatPaiement == true) {
    		 paiement = "Payée";
    	 }else {
    		 paiement = "Non payée";
    	 }
    	 
    	 double CATotalReservation = 0.0;
    	 
    	 double caAdultes = this.calculerCaAdulte();
    	 double caAbonne = this.calculerCaAbonne();
    	 double caGroupe = this.calculerCaGroupe();
    	 double caSenior = this.calculerCaSenior();
    	 double caJeune = this.calculerCaJeune();
    	 
    	 int nbBilletsAdultes = this.recupererNbBilletsAdultes();
    	 int nbBilletsAbonnes = this.recupererNbBilletsAbonne();
    	 int nbBilletsSeniors = this.recupererNbBilletsSenior();
    	 int nbBilletsGroupes = this.recupererNbBilletsGroupe();
    	 int nbBilletsJeunes = this.recupererNbBilletsJeune();
    	 
    	 CATotalReservation = caAdultes + caAbonne + caGroupe + caJeune + caSenior; 
    	 
    	 Main.ouvrirFenPlanSalle(dateResa, listeResa, paiement, dateHeureRepresentation, CATotalReservation, resa, caAdultes, caAbonne, caGroupe, caSenior, caJeune, nbBilletsAdultes, nbBilletsAbonnes, nbBilletsSeniors, nbBilletsGroupes, nbBilletsJeunes);
    }
}

