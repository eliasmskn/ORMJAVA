package Controleurs;

public class Planning {
	String nom, classe, salle, matiere;
	DatePPE date;
	HeurePPE duree;
	
	public Planning(String nom, String classe, String salle, String matiere, DatePPE date, HeurePPE duree) {
		super();
		this.nom = nom;
		this.classe = classe;
		this.salle = salle;
		this.matiere = matiere;
		this.date = date;
		this.duree = duree;
	}
	
	public String toString()
	{
		return "\n nom Professeur:"+this.nom+
				"\n Classe :" +this.classe+
				"\n Salle :"+this.salle+
				"\n Matiere :"+this.matiere+
				"\n date :"+this.date+
				"\n duree :"+this.duree;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getSalle() {
		return salle;
	}
	public void setSalle(String salle) {
		this.salle = salle;
	}
	public String getMatiere() {
		return matiere;
	}
	public void setMatiere(String matiere) {
		this.matiere = matiere;
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
