package modele;

public class Abonné extends Tarification{
	static double reduction = 0.70;
	private String id = "Abonne";
	
	public static double getReduction() {
		return reduction;
	}

	public static void setReduction(double reduction) {
		Abonné.reduction = reduction;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

