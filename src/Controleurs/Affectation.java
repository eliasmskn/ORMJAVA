package Controleurs;

public class Affectation {
	int id_affectation;
	int id_prof;
	int id_matiere;
	int id_class;
	int id_heure;
	int id_salle;
	int id_date;
	public int getId_date() {
		return id_date;
	}
	public void setId_date(int id_date) {
		this.id_date = id_date;
	}
	public int getId_class() {
		return id_class;
	}
	public void setId_class(int id_class) {
		this.id_class = id_class;
	}
	public int getId_heure() {
		return id_heure;
	}
	public void setId_heure(int id_heure) {
		this.id_heure = id_heure;
	}
	public int getId_salle() {
		return id_salle;
	}
	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	}
	public Affectation(int id_affectation, int id_prof, int id_matiere, int id_class, int id_heure, int id_salle, int id_date) {
		super();
		this.id_affectation = id_affectation;
		this.id_date=id_date;
		this.id_prof = id_prof;
		this.id_matiere = id_matiere;
		this.id_class = id_class;
		this.id_heure = id_heure;
		this.id_salle = id_salle;
	}
	public int getId_affectation() {
		return id_affectation;
	}
	public void setId_affectation(int id_affectation) {
		this.id_affectation = id_affectation;
	}
	public int getId_prof() {
		return id_prof;
	}
	public void setId_prof(int id_prof) {
		this.id_prof = id_prof;
	}
	public int getId_matiere() {
		return id_matiere;
	}
	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
	}
	
	

}
