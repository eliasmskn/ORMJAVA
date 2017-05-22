package Controleurs;

public class Matiere {

	int id_matiere;
	String libelle;
	
	public Matiere()
	{
		id_matiere = 0;
		libelle = "";
	}
	
	public Matiere(int id_matiere, String libelle)
	{
		this.id_matiere = id_matiere;
		this.libelle = libelle;
	}
	
	public String toString()
	{
		return "\n Id Matiere:"+this.id_matiere+
				"\n Libelle Matiere :" +this.libelle;
	}

	public int getId_matiere() {
		return id_matiere;
	}

	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	

}
