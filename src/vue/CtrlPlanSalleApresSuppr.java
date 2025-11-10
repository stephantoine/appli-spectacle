package vue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import controleur.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import modele.ResaLot5;

public class CtrlPlanSalleApresSuppr {
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
	
	@FXML private Button bnFermer;
	
	private Map<String, Rectangle> listePlaces = new HashMap<String, Rectangle>();
	private ArrayList<ResaLot5> listeResa;
	
	@FXML void initialize() {
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
	
	public void set(ArrayList<ResaLot5> listeResa) {
		this.listeResa = listeResa;
		this.afficherSiegesPris();
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
	
	public void majPlan() {
		Collection<Rectangle> listeRect = this.listePlaces.values();
		Iterator<Rectangle> it = listeRect.iterator();

		while (it.hasNext()) {
			Rectangle current = it.next();
			if(current.getFill() == Color.RED) {
				current.setFill(Color.DODGERBLUE);
			}
		}
	}
	
	@FXML void clicFermer(ActionEvent event) {
		Main.fermerPlanSalleApresSuppr();
    }
}
