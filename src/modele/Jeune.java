package modele;

public class Jeune extends Tarification{
	static double reduction = 0.70;
	private String id = "Jeune";
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static void setReduction(double reduction) {
		Jeune.reduction = reduction;
	}

	public static double getReduction() {
		return reduction;
	}
}
