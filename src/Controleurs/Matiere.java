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
		return "\n Id Matière:"+this.id_matiere+
				"\n Libellé Matière :" +this.libelle;
	}

}
