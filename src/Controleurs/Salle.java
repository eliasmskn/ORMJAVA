package Controleurs;

public class Salle {

	int id_salle, capacite;
	String num_salle;
	
	public Salle() 
	{
		id_salle = 0;
		num_salle = " ";
		capacite = 0;
	}
	
	public Salle (int id_salle, String num_salle, int capacite)
	{
		this.id_salle = id_salle;
		this.num_salle = num_salle;
		this.capacite = capacite;
	}
	
	public String toString()
	{
		return "\n Id Salle:"+this.id_salle+
				"\n Num Salle :" +this.num_salle+
				"\n Capacite :"+this.capacite;
	}

	public int getId_salle() {
		return id_salle;
	}

	public void setId_salle(int id_salle) {
		this.id_salle = id_salle;
	}

	public String getNum_salle() {
		return num_salle;
	}

	public void setNum_salle(String num_salle) {
		this.num_salle = num_salle;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
	
	
	
}
