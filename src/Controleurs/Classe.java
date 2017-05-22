package Controleurs;

public class Classe 
{
	int id_classe;
	int nombreEleve;
	String specialite, niveau;
	
	public Classe()
	{
		id_classe = 0;
		nombreEleve = 0;
		specialite = "";
		niveau = "";
		
	}
	
	public Classe(int id_classe, int nombreEleve, String specialite, String niveau)
	{
		this.id_classe = id_classe;
		this.nombreEleve = nombreEleve;
		this.specialite = specialite;
		this.niveau = niveau;
	}

	public int getId_classe() {
		return id_classe;
	}

	public void setId_classe(int id_classe) {
		this.id_classe = id_classe;
	}

	public int getNombreEleve() {
		return nombreEleve;
	}

	public void setNombreEleve(int nombreEleve) {
		this.nombreEleve = nombreEleve;
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
