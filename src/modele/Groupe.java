package modele;

public class Groupe extends Tarification{
	static double reduction = 0.85;
	private String id = "Groupe";
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static void setReduction(double reduction) {
		Groupe.reduction = reduction;
	}

	public static double getReduction() {
		return reduction;
	}
}