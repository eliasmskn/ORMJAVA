package Modeles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import Controleurs.Prof;

public class Modele_Matiere {
	
	
	public static void insertionMatiere(Matiere uneM)
	{
		String requete ="Insert into matiere ("
				+ "libelle) values ("
				+ "'"+uneM.getlibelle()+"');";
			
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
		unModele.connexion();
		try{
			java.sql.Statement unStat =  unModele.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur de la requete :"+ exp +requete);
		}
		unModele.deconnexion();
				
	}
	
	public static void modificationMatiere(Matiere uneM)
	{
		String requete ="Update matiere"
				+ " set libelle = '" + uneM.getlibelle() + "'
				+ " where id_matiere = '" + uneM.getId_matieref() + "' ;";
			
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
		unModele.connexion();
		try{
			java.sql.Statement unStat =  unModele.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur de la requete :"+ exp +requete);
		}
		unModele.deconnexion();
				
	}
	
	public static LinkedList<Matiere> selectall()
	{
		String requete ="Select * from matiere;";
		LinkedList<Prof> uneListe = new LinkedList<Prof>();
		
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "root");
		unModele.connexion();
		try{
			Statement unStat =  (Statement) unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
			{
				int id_matiere = unRes.getInt("id_matiere");
				String libelle = unRes.getString("libelle");
				Prof uneM = new Matiere(id_matiere, libelle);
				uneListe.add(uneM);
			}
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur :"+ exp);
		}
		unModele.deconnexion();
		return uneListe;		
	}
	
	public static Matiere selectwhere(int id_matiere)	
	{
		String requete ="Select * from matiere where id_matiere = '"+id_matiere+"';";
		Matiere uneM = null;
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "root");
		unModele.connexion();
		try{
			java.sql.Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				String libelle = unRes.getString("libelle");
				uneM = new Matiere(id_matiere, libelle);
			}
			
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur :"+ exp);
		}
		unModele.deconnexion();
		return uneM;		
	}
	
	public static int delete(String cle)	
	{
		String requete ="delete from matiere where "
						+ " id_matiere = "+cle+";";
		
		String requete2 = "Select count(id_matiere) as nb "
						+ " from matiere where "
						+ " id_matiere = "+cle+";";
		int nb = 0;
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
		unModele.connexion();
		try{
			java.sql.Statement unStat =  unModele.getMaConnexion().createStatement();			
			ResultSet  unRes = unStat.executeQuery(requete2);
			unRes.next();
			nb =  unRes.getInt("nb");
			unStat.execute(requete);
			unStat.close();
				
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur :"+ exp);
		}
		unModele.deconnexion();
		return nb;		
	}

}
