package modele;

public class Abonne extends Client{
	public Abonne(String nom, String prenom, String adresse, String tel, String mail, String numero) {
		super(nom, prenom, adresse, tel, mail, numero);
	}
	
	public void afficher() {
		System.out.println("Abonné" + super.toString());
	}
}
