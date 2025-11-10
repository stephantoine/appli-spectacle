package vue;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;


public class FenListeReservations extends Stage {
	
	public FenListeReservations() throws IOException {
		this.setTitle("Liste des réservations");
		Scene laScene = new Scene(creerSceneGraph());
		this.setScene(laScene);
		this.setResizable(false);
	}

	private Pane creerSceneGraph() throws IOException {
     	FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/listeReservations.fxml"));
        Pane root = loader.load();
        loader.getController();
     	return root;
	}
}