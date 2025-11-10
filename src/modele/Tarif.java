package modele;

public class Tarif {
	private double pleinTarif;
	private Zone zone;
	private Spectacle spectacle;
	
	public Tarif(double pleinTarif, Spectacle s, Zone z) {
		this.pleinTarif = pleinTarif;
		this.ajouterSpectacle(s);
		this.ajouterZone(z);
	}

	public double getPleinTarif() {
		return pleinTarif;
	}

	public void setPleinTarif(double pleinTarif) {
		this.pleinTarif = pleinTarif;
	}

	public void afficher() {
		System.out.println("-------------");
		System.out.println("Tarif du spectacle " + this.spectacle.getNom() + " pour la zone " + this.zone.getNom() + " : " + this.pleinTarif);
	}
	
	public boolean equals(Tarif other) {
		return this.pleinTarif==other.getPleinTarif();
	}
	
	public void ajouterSpectacle(Spectacle s) {
		if(s != null) {
			this.affecterSpectacle(s);
		} else {
			System.out.println("Le spectacle passé en paramètre est null");
		}
	}
	
	private void affecterSpectacle(Spectacle s) {
		if(this.spectacle == null) {
			this.spectacle = s;
		} else {
			System.out.println("Un spectacle a déjà été attribué pour ce tarif");
		}
	}
	
	public void enleverSpectacle(Spectacle s) {
		if(s != null) {
			this.desaffecterSpectacle(s);
		} else {
			System.out.println("Le spectacle à enlever est null");
		}
	}
	
	private void desaffecterSpectacle(Spectacle s) {
		if(this.spectacle !=null && this.spectacle.equals(s)) {
			this.spectacle = null;
		} else {
			System.out.println("Le spectacle à enlever n'est pas identique à celui attribué au tarif");
		}
	}
	
	public void ajouterZone(Zone z) {
		if(z != null) {
			this.affecterZone(z);
		} else {
			System.out.println("La zone passée en paramètre est null");
		}
	}
	
	private void affecterZone(Zone z) {
		if(this.zone == null) {
			this.zone = z;
			z.ajouterTarif(this);
		} else {
			System.out.println("Une zone a déjà été attribuée pour ce tarif");
		}
	}
	
	public void enleverZone(Zone z) {
		if(z != null) {
			this.desaffecterZone(z);
		} else {
			System.out.println("La zone à enlever est null");
		}
	}
	
	private void desaffecterZone(Zone z) {
		if(this.zone !=null && this.zone.equals(z)) {
			this.zone = null;
		} else {
			System.out.println("La zone à enlever n'est pas identique à celle attribuée au tarif");
		}
	}
}
