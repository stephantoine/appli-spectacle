package vue;

import javafx.stage.Stage;
import modele.ResaLot5;
import modele.Reservation;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;

public class FenPlanSalle extends Stage{
	CtrlPlanSalle ctrl;
	
	public FenPlanSalle() throws IOException {
		this.setTitle("Fenêtre de confirmation de suppresion");
		this.setResizable(false);
		
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}
	
	private Pane creerSceneGraph() throws IOException {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/plan_salle.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
     	return root;
	}
	
	public void afficher(String dateHeureRepresentation, String etatPaiement, String dateReservation, double caTotalReservation) {
		ctrl.afficher(dateHeureRepresentation, etatPaiement, dateReservation, caTotalReservation);
	}
	
	public void set(Reservation r, ArrayList<ResaLot5> listeResa, double caAdultes, double caAbonne, double caGroupe, double caSenior, double caJeune, int nbBilletsAdultes, int nbBilletsAbonnes, int nbBilletsSeniors, int nbBilletsGroupes, int nbBilletsJeunes) {
		ctrl.set(r, listeResa, caAdultes, caAbonne, caGroupe, caSenior, caJeune, nbBilletsAdultes, nbBilletsAbonnes, nbBilletsSeniors, nbBilletsGroupes, nbBilletsJeunes);
	}
	
	public void majPlan() {
		ctrl.majPlan();
	}
}