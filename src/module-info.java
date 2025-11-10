/**
 * 
 */
/**
 * @author jbrisson
 *
 */
module Reservator {
	requires javafx.base; 
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens controleur to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
	opens modele to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
	opens vue to javafx.base, javafx.controls, javafx.fxml, javafx.graphics;
}