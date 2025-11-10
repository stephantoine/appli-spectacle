package vue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import controleur.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modele.ResaLot5;
import modele.Reservation;

public class CtrlPlanSalle {

    @FXML private Rectangle b10;
    @FXML private Rectangle d1;
	@FXML private Rectangle d2;
	@FXML private Rectangle b1;
	@FXML private Rectangle o10;
	@FXML private Rectangle d3;
	@FXML private Rectangle b2;
	@FXML private Rectangle d4;
	@FXML private Rectangle b3;
	@FXML private Rectangle d5;
	@FXML private Rectangle b4;
	@FXML private Rectangle b5;
	@FXML private Rectangle b6;
	@FXML private Rectangle b7;
	@FXML private Rectangle b8;
	@FXML private Rectangle b9;
	@FXML private Rectangle o1;
	@FXML private Rectangle o2;
	@FXML private Rectangle o3;
	@FXML private Rectangle o4;
	@FXML private Rectangle o5;
	@FXML private Rectangle o6;
	@FXML private Rectangle o7;
	@FXML private Rectangle o8;
	@FXML private Rectangle g1;
	@FXML private Rectangle o9;
	@FXML private Rectangle g2;
	@FXML private Rectangle g3;
	@FXML private Rectangle g4;
	@FXML private Rectangle g5;
	
	@FXML private Button bnSupprimer;
	@FXML private Button bnAnnuler;
	
	@FXML private TextField txtDateHeureRepresentation;
	@FXML private TextField txtEtatPaimement;
	@FXML private TextField txtDateResa;
	@FXML private TextField txtNbBilletVendu;
	@FXML private TextField txtCaTotalResa;
	@FXML private TextField txtCaCategorie;
	
	@FXML private MenuButton selectCategorie;
	@FXML private MenuItem itemSenior;
	@FXML private MenuItem itemAbonne;
	@FXML private MenuItem itemAdulte;
	@FXML private MenuItem itemJeune;
	@FXML private MenuItem itemGroupe;
	
	private Reservation resa;
	private Map<String, Rectangle> listePlaces = new HashMap<String, Rectangle>();
	private ArrayList<ResaLot5> listeResa;
	private double caAdultes;
	private double caAbonne;
	private double caGroupe;
	private double caSenior;
	private double caJeune;
	private int nbBilletsAdultes;
	private int nbBilletsAbonnes;
	private int nbBilletsSeniors;
	private int nbBilletsGroupes;
	private int nbBilletsJeunes;
	
	@FXML void initialize() {
		this.txtNbBilletVendu.setText("0.0");
		this.txtCaCategorie.setText("0.0");
		
		this.listePlaces.put(b1.getId(), b1);
		this.listePlaces.put(b2.getId(), b2);
		this.listePlaces.put(b3.getId(), b3);
		this.listePlaces.put(b4.getId(), b4);
		this.listePlaces.put(b5.getId(), b5);
		this.listePlaces.put(b6.getId(), b6);
		this.listePlaces.put(b7.getId(), b7);
		this.listePlaces.put(b8.getId(), b8);
		this.listePlaces.put(b9.getId(), b9);
		this.listePlaces.put(b10.getId(), b10);
		
		this.listePlaces.put(d1.getId(), d1);
		this.listePlaces.put(d2.getId(), d2);
		this.listePlaces.put(d3.getId(), d3);
		this.listePlaces.put(d4.getId(), d4);
		this.listePlaces.put(d5.getId(), d5);
		
		this.listePlaces.put(g1.getId(), g1);
		this.listePlaces.put(g2.getId(), g2);
		this.listePlaces.put(g3.getId(), g3);
		this.listePlaces.put(g4.getId(), g4);
		this.listePlaces.put(g1.getId(), g5);
		
		this.listePlaces.put(o1.getId(), o1);
		this.listePlaces.put(o2.getId(), o2);
		this.listePlaces.put(o3.getId(), o3);
		this.listePlaces.put(o4.getId(), o4);
		this.listePlaces.put(o5.getId(), o5);
		this.listePlaces.put(o6.getId(), o6);
		this.listePlaces.put(o7.getId(), o7);
		this.listePlaces.put(o8.getId(), o8);
		this.listePlaces.put(o9.getId(), o9);
		this.listePlaces.put(o10.getId(), o10);
	}
	
	public void majPlan() {
		Collection<Rectangle> listeRect = this.listePlaces.values();
		Iterator<Rectangle> it = listeRect.iterator();

		while (it.hasNext()) {
			Rectangle current = it.next();
			if(current.getFill() == Color.ORANGE) {
				current.setFill(Color.DODGERBLUE);
			}
		}
	}
	
	public void set(Reservation r, ArrayList<ResaLot5> listeResa, double caAdultes, double caAbonne, double caGroupe, double caSenior, double caJeune, int nbBilletsAdultes, int nbBilletsAbonnes, int nbBilletsSeniors, int nbBilletsGroupes, int nbBilletsJeunes) {
		this.resa = r;
		this.listeResa = listeResa;
		this.caAdultes = caAdultes;
		this.caAbonne = caAbonne;
		this.caGroupe = caGroupe;
		this.caSenior = caSenior;
		this.caJeune = caJeune;
		this.nbBilletsAdultes = nbBilletsAdultes;
		this.nbBilletsAbonnes = nbBilletsAbonnes;
		this.nbBilletsGroupes = nbBilletsGroupes;
		this.nbBilletsJeunes = nbBilletsJeunes;
		this.nbBilletsSeniors = nbBilletsSeniors;
		
		this.afficherSiegesPris();
		this.afficherSiegeLiberes();
	}
	
	@FXML void clicCategorie(Event e) {
		if(e.getSource() == itemAdulte) {
			this.selectCategorie.setText("Adulte");
			this.txtNbBilletVendu.setText(String.valueOf(this.nbBilletsAdultes));
			this.txtCaCategorie.setText(String.valueOf(caAdultes));
		}else if(e.getSource() == itemAbonne) {
			this.selectCategorie.setText("Abonne");
			this.txtNbBilletVendu.setText(String.valueOf(this.nbBilletsAbonnes));
			this.txtCaCategorie.setText(String.valueOf(caAbonne));
		}else if(e.getSource() == itemSenior) {
			this.selectCategorie.setText("Senior");
			this.txtNbBilletVendu.setText(String.valueOf(this.nbBilletsSeniors));
			this.txtCaCategorie.setText(String.valueOf(caSenior));
		}else if(e.getSource() == itemJeune) {
			this.selectCategorie.setText("Jeune");
			this.txtNbBilletVendu.setText(String.valueOf(this.nbBilletsJeunes));
			this.txtCaCategorie.setText(String.valueOf(caJeune));
		}else if(e.getSource() == itemGroupe) {
			this.selectCategorie.setText("Groupe");
			this.txtNbBilletVendu.setText(String.valueOf(this.nbBilletsGroupes));
			this.txtCaCategorie.setText(String.valueOf(caGroupe));
		}
	}
	
	@FXML void clicAnnuler(ActionEvent event) {
		Main.fermerPlanSalle();
    }
	
	@FXML void clicSupprimer(ActionEvent event) {
		Alert alert = new Alert(
			AlertType.CONFIRMATION,
			"Voulez-vous vraiment supprimer cette réservation ?",
			ButtonType.YES,
			ButtonType.NO
		);
	    alert.setTitle("Confirmation de suppression");
	    Optional<ButtonType> result = alert.showAndWait();
		
	    if(result.get()==ButtonType.YES) {
	    	Main.supprimerReserv(resa.getResa2());
	    } 
	}
	
	 public void afficherSiegesPris() {
		 String place;
		 for(int i =0; i<listeResa.size(); i++) {
			 for(int j=0; j<listeResa.get(i).getResa().getListeBillets().size(); j++){
				 place = listeResa.get(i).getResa().getListeBillets().get(j).getFauteuil().getNumero();
				 if(this.listePlaces.containsKey(place)) {
				 	this.listePlaces.get(place).setFill(Color.RED);
				 }
			 }
		 }
	 }
	
	public void afficherSiegeLiberes() {
		String place;
		for(int i=0; i<resa.getListeBillets().size(); i++) {
			place = resa.getListeBillets().get(i).getFauteuil().getNumero();
			if(this.listePlaces.containsKey(place)) {
				this.listePlaces.get(place).setFill(Color.ORANGE);
			}
		}
	}
	
	public void afficher(String dateHeureRepresentation, String etatPaiement, String dateReservation, double caTotalReservation) {
		this.txtDateHeureRepresentation.setText(String.valueOf(dateHeureRepresentation));
		this.txtEtatPaimement.setText(etatPaiement);
		this.txtDateResa.setText(String.valueOf(dateReservation));
		this.txtCaTotalResa.setText(String.valueOf(caTotalReservation));
	}
}
