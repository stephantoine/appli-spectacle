package vue;

import java.io.IOException;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class FenRechercherResa extends Stage {
	
	public FenRechercherResa() throws IOException {
		this.setTitle("Rechercher une réservation ");
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
		this.setMinWidth(645);
		this.setMinHeight(450);

	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/maquette_recherche_resa.fxml"));
        Pane root = loader.load();
        loader.getController();
     	return root;
	}
}