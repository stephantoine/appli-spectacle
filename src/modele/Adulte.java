package modele;

public class Adulte extends Tarification{
	static double reduction = 1;
	private String id = "Adulte";
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static void setReduction(double reduction) {
		Adulte.reduction = reduction;
	}

	public static double getReduction() {
		return reduction;
	}
}