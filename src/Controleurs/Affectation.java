package Controleurs;
import Controleurs.DatePPE;

public class Affectation {
	
	int id_affectation;
	int id_prof;
	int id_matiere;
	int id_classe;
	int id_salle;
	DatePPE date;
	HeurePPE duree;	
	
	public Affectation()
	{
		id_affectation = 0;
		id_prof = 0;
		id_matiere = 0;
		id_classe = 0;
		id_salle = 0;
		date = new DatePPE("yyyy-MM-dd");
		duree = new HeurePPE("HH:mm:ss");
		
	}
	
	public Affectation(int id_affectation, int id_prof, int id_matiere, int id_classe, int id_salle, DatePPE date, HeurePPE duree)
	{
		this.id_affectation = id_affectation;
		this.id_prof = id_prof;
		this.id_matiere = id_matiere;
		this.id_classe = id_classe;
		this.id_salle = id_salle;
		this.date = date;
		this.duree = duree;
	}
	
	public String toString()
	{
		return "\n Id Affectation :"+this.id_affectation+
				"\n Id Professeur :"+this.id_prof+
				"\n Id Matiere :"+this.id_matiere+
				"\n Id Classe :"+this.id_classe+
				"\n Id Salle :"+this.id_salle+
				"\n Date :"+this.date+
				"\n Duree :"+this.duree;
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

	public int getId_classe() {
		return id_classe;
	}

	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}

	public int getId_salle() {
		return id_salle;
	}

	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	}

	public DatePPE getDate() {
		return date;
	}

	public void setDate(DatePPE date) {
		this.date = date;
	}

	public HeurePPE getDuree() {
		return duree;
	}

	public void setDuree(HeurePPE duree) {
		this.duree = duree;
	}
	
	
	
	

}
