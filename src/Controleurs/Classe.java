package Controleurs;

public class Classe 
{
	int id_classe;
	int nb_eleve;
	String specialite, niveau;
	
	public Classe()
	{
		id_classe = 0;
		nb_eleve = 0;
		specialite = "";
		niveau = "";
		
	}
	
	public Classe(int id_classe, int nb_eleve, String specialite, String niveau)
	{
		this.id_classe = id_classe;
		this.nb_eleve = nb_eleve;
		this.specialite = specialite;
		this.niveau = niveau;
	}

	public int getId_classe() {
		return id_classe;
	}

	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}


	public int getNb_eleve() {
		return nb_eleve;
	}

	public void setNb_eleve(int nb_eleve) {
		this.nb_eleve = nb_eleve;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	
}
