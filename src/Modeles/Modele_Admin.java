package Modeles;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Modele_Admin {
	

		public static String [] verifConnexion(String email, String mdp)
		{
			String resultat [] = new String[3];
			String requete = "Select count(mailadmin) as nb, nomadmin, prenomadmin"
					+ " from admin where mailadmin ='"+email
					+"' and mdpadmin ='"+mdp+"';";
			Modele unModele = new Modele("127.0.0.1", "gestion_planning", "elias", "");
			unModele.changerPilot();
			unModele.connexion();
			try
			{
				Statement unStat = (Statement) unModele.getMaConnexion().createStatement();
				ResultSet unRes = unStat.executeQuery(requete);
				unRes.next();
				int nb = unRes.getInt("nb");
				if(nb>0)
				{
					
					resultat [0] = nb+"";
					resultat [1] = unRes.getString("nomadmin");
					resultat [2] = unRes.getString("prenomadmin");
				}
			}
			catch(SQLException exp)
			{
				System.out.println("Erreur de la requette : " + requete +" | Message :"+ exp);
			}
			unModele.connexion();
			return resultat;
		}


}
