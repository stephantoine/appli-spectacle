package modele;

public class Senior extends Tarification{
	static double reduction = 0.75;
	private String id = "Senior";
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static void setReduction(double reduction) {
		Senior.reduction = reduction;
	}

	public static double getReduction() {
		return reduction;
	}
}