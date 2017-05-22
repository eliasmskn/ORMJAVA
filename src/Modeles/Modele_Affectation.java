package Modeles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import Controleurs.Affectation;
import Controleurs.Prof;

public class Modele_Affectation {
	
	
	public static void insertionAffectation(Affectation uneM)
	{
		String requete ="Insert into matiere ("
				+ "id_affectation, id_prof, id_matiere, id_class, id_heure,id_salle) values ("
				+ "'"+uneM.getId_affectation()+"');";
			
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
	
	public static void modificationAffectation(Affectation uneM)
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
	
	public static LinkedList<Affectation> selectall()
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

				int id_affectation = unRes.getInt("id_affectation");
				int id_date = unRes.getInt("id_date");
				int id_prof = unRes.getInt("id_prof");
				int id_matiere = unRes.getInt("id_matiere");
				int id_class = unRes.getInt("id_class");
				int id_heure = unRes.getInt("id_heure");
				int id_salle = unRes.getInt("id_salle");
				Affectation uneM = new Affectation(id_affectation,id_prof, id_matiere,id_class,id_heure,id_salle,id_date);
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
	
	public static Affectation selectwhere(int idmatiere)	
	{
		String requete ="Select * from matiere where id_matiere = '"+idmatiere+"';";
		Affectation uneM = null;
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "root");
		unModele.connexion();
		try{
			java.sql.Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				int id_affectation = unRes.getInt("id_affectation");
				int id_date = unRes.getInt("id_date");
				int id_prof = unRes.getInt("id_prof");
				int id_matiere = unRes.getInt("id_matiere");
				int id_class = unRes.getInt("id_class");
				int id_heure = unRes.getInt("id_heure");
				int id_salle = unRes.getInt("id_salle");
			

				

				uneM = new Affectation(id_affectation,id_prof, id_matiere,id_class,id_heure,id_salle,id_date);
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
		String requete ="delete from affectation where "
						+ " id_affectation = "+cle+";";
		
		String requete2 = "Select count(id_affectation) as nb "
						+ " from matiere where "
						+ " id_affectation = "+cle+";";
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
			JOptionPane.showMessageDialog(null, "Erreure :"+ exp);
		}
		unModele.deconnexion();
		return nb;		
	}

}
