package Controleurs;

public class Prof 
{
	int id_prof;
	String nom, prenom;
	String identifiant, mdp;
	
	public Prof()
	{
		id_prof = 0;
		nom = "";
		prenom = "";
		identifiant = "";
		mdp = "";
	}
	
	public Prof(int id_prof, String nom, String prenom, String identifiant, String mdp)
	{
		this.id_prof = id_prof;
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.mdp = mdp;
	}
	
	public String toString()
	{
		return "\n Id Professeur:"+this.id_prof+
				"\n Nom Professeur :" +this.nom+
				"\n Prenom Professeur :"+this.prenom+
				"\n Identifiant Professeur :"+this.identifiant+
				"\n Mdp Professeur :"+this.mdp;
	}

	public int getId_prof() {
		return id_prof;
	}

	public void setId_prof(int id_prof) {
		this.id_prof = id_prof;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
}
