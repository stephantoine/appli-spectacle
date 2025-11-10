package vue;

import java.io.IOException;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.ResaLot5;

public class FenPlanSalleApresSuppr extends Stage{
	CtrlPlanSalleApresSuppr ctrl;
	
	public FenPlanSalleApresSuppr() throws IOException {
		this.setTitle("Fenêtre de confirmation de suppresion");
		this.setResizable(false);
		
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
	}
	
	private Pane creerSceneGraph() throws IOException {
		FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/plan_salle_post_suppresion.fxml"));
        Pane root = loader.load();
        ctrl = loader.getController();
     	return root;
	}
	
	public void set(ArrayList<ResaLot5> listeResa) {
		ctrl.set(listeResa);
	}
	
	public void majPlan() {
		ctrl.majPlan();
	}
}