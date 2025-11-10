package vue;

import controleur.Main;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class CtrlRechercherResa {
	@FXML
	private TextField txtVille;

	@FXML
	private Button bnRechercher;

	@FXML
	private Button labelAnnuler;

	@FXML
	private TextField txtNom;

	@FXML
	private Label labelErreurSaisieNom;

	@FXML
	private Label labelErreurSaisieVille;

	public void start(Stage fenetre) {
		// liste des caractères autorisés
		labelErreurSaisieNom.setVisible(false);
		labelErreurSaisieVille.setVisible(false);
	}

	@FXML
	void initialize() {
		BooleanBinding vide = Bindings.or(txtNom.textProperty().isEmpty(), txtVille.textProperty().isEmpty());
		bnRechercher.disableProperty().bind(Bindings.when(vide).then(true).otherwise(false));
		
		txtNom.setTooltip(new Tooltip("Saissisez le nom sans accents et avec la première lettre en majuscule"));
		txtVille.setTooltip(new Tooltip("Saissisez la ville en toute lettres sans accents ni caractères spéciaux, avec la première lettre en majuscule"));
	}

	@FXML
	void clicBnRechercher(ActionEvent event) {
		Main.rechercheClient(txtNom.getText(), txtVille.getText());
		txtNom.clear();
		txtVille.clear();
		labelErreurSaisieNom.setVisible(false);
		labelErreurSaisieVille.setVisible(false);
	}

	@FXML
	void clicBnAnnuler(ActionEvent event) {
		Main.fermerAppli();
	}

	@FXML
	void keyReleasedNom(KeyEvent event) {

		if (!this.isFullname(this.txtNom.getText())) {
			labelErreurSaisieNom.setText("Seules les lettres sont autorisées");
			labelErreurSaisieNom.setVisible(true);
		} else {
			labelErreurSaisieNom.setVisible(false);
		}
	}

	@FXML
	void keyReleasedVille(KeyEvent event) {
		if (!this.isFullname(this.txtVille.getText())) {
			labelErreurSaisieVille.setText("Seules les lettres sont autorisées");
			labelErreurSaisieVille.setVisible(true);
		} else {
			labelErreurSaisieVille.setVisible(false);
		}
	}

	public boolean isFullname(String str) {
		String expression = "^[a-zA-Z\\s ]*";
		return str.matches(expression);
	}
}
