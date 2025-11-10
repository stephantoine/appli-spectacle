package modele;

public class Billet {
	private String numero;
	private Fauteuil fauteuil;
	private Reservation reservation;
	private Tarification tarif;
	
	public Billet(String n, Fauteuil f, Reservation r, Tarification t) {
		this.numero = n;
		this.ajouterFauteuil(f);
		this.ajouterReservation(r);
		this.ajouterTarif(t);
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String toString() {
		return "Billet numéro : " + this.numero;
	}
	
	public void afficher() {
		System.out.println(this.toString());
		if(this.fauteuil != null) {
			this.fauteuil.afficher();
		}
	}
	
	public Fauteuil getFauteuil() {
		return fauteuil;
	}

	public void setFauteuil(Fauteuil fauteuil) {
		this.fauteuil = fauteuil;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	public Tarification getTarification() {
		return this.tarif;
	}

	public void setTarification(Tarification tarif) {
		this.tarif = tarif;
	}
	
	public boolean equals(Billet other) {
		boolean res = false;
		if(this.numero == other.getNumero()) {
			res = true;
		}
		return res;
	}
	
	public void ajouterFauteuil(Fauteuil f) {
		if(f != null) {
			this.affecterFauteuil(f);
		} else {
			System.out.println("Le fauteuil passé en paramètre est null");
		}
	}
	
	private void affecterFauteuil(Fauteuil f) {
		if(this.fauteuil == null) {
			this.fauteuil = f;
		} else {
			System.out.println("Un fauteuil a déjà été attribué pour ce billet");
		}
	}
	
	public void enlevlibelleerFauteuil(Fauteuil f) {
		if(f != null) {
			this.desaffecterFauteuil(f);
		} else {
			System.out.println("Le fauteuil à enlever est null");
		}
	}
	
	private void desaffecterFauteuil(Fauteuil f) {
		if(this.fauteuil !=null && this.fauteuil.equals(f)) {
			this.fauteuil = null;
		} else {
			System.out.println("Le fauteuil à enlever n'est pas identique à celui attribué par le billet");
		}
	}
	
	public void ajouterReservation(Reservation r) {
		if(r != null) {
			this.affecterReservation(r);
		} else {
			System.out.println("La réservation lepassée en paramètre est null");
		}
	}
	
	private void affecterReservation(Reservation r) {
		if(this.reservation == null) {
			this.reservation = r;
			r.ajouterUnNouveauBillet(this);
		} else {
			System.out.println("Une réservation a déjà été attribué pour ce billet");
		}
	}
	
	public void enleverReservation(Reservation r) {
		if(r != null) {
			this.desaffecterReservation(r);
		} else {
			System.out.println("Le fauteuil à enlever est null");
		}
	}
	
	private void desaffecterReservation(Reservation r) {
		if(this.reservation !=null && this.reservation.equals(r)) {
			this.reservation = null;
		} else {
			System.out.println("La réservation à enlever n'est pas identique à celle auquel le billet est attribuée");
		}
	}
	
	
	public void ajouterTarif(Tarification t) {
		if(t != null) {
			this.affecterTarif(t);
		} else {
			System.out.println("Le tarif passé en paramètre est null");
		}
	}
	
	private void affecterTarif(Tarification t) {
		if(this.tarif == null) {
			this.tarif = t;
			t.ajouterBillet(this);
		} else {
			System.out.println("Un tarif a déjà été attribué pour ce billet");
		}
	}

	public void enleverTarif(Tarification t) {
		if(t != null) {
			this.desaffecterTarif(t);
		} else {
			System.out.println("Le tarif à enlever est null");
		}
	}
	
	private void desaffecterTarif(Tarification t) {
		if(this.tarif !=null && this.tarif.equals(t)) {
			this.tarif = null;
		} else {
			System.out.println("Le tarif à enlever n'est pas identique à celui auquel le billet est attribué");
		}
	}
}
