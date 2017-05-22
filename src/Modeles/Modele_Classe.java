package Modeles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import Controleurs.Classe;

public class Modele_Classe {
	public static LinkedList<Classe> selectall()
	{
		String requete ="Select * from classe;";
		LinkedList<Classe> uneListe = new LinkedList<Classe>();
		
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
		unModele.connexion();
		try{
			Statement unStat =  (Statement) unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
			{
				int id_classe = unRes.getInt("id_classe");
				int nb_eleve = unRes.getInt("nb_eleve");
				String specialite = unRes.getString("specialite");
				String niveau = unRes.getString("niveau");
			
				Classe unP = new Classe(id_classe, nb_eleve, specialite, niveau);
				uneListe.add(unP);
			}
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreure :"+ exp);
		}
		unModele.deconnexion();
		return uneListe;		
	}
	
	public static Classe selectwhere(int idclasse)	
	{
		String requete ="Select * from classe where id_classe = '"+idclasse+"';";
		Classe unP = null;
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
		unModele.connexion();
		try{
			java.sql.Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				int id_classe = unRes.getInt("id_classe");
				int nb_eleve = unRes.getInt("nb_eleve");
				String specialite = unRes.getString("specialite");
				String niveau = unRes.getString("niveau");
				unP = new Classe(id_classe, nb_eleve, specialite, niveau);
			}
			
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur :"+ exp);
		}
		unModele.deconnexion();
		return unP;		
	}
}
