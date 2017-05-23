package Modeles;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import Controleurs.Affectation;
import Controleurs.DatePPE;
import Controleurs.HeurePPE;
import Controleurs.Prof;

public class Modele_Affectation {
	
	
	public static void insertionAffectation(Affectation uneA)
	{
		String requete ="Insert into affectation ("
				+ "id_prof, id_matiere, id_classe, id_salle, date, duree) values ("
				+ "'"+uneA.getId_prof()
				+ "', '"+uneA.getId_matiere()+"','"+uneA.getId_classe()
				+ "', '"+uneA.getId_salle()+"','"+uneA.getDate()
				+ "', '"+uneA.getDuree()+"');";
			
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
	
	
	
	public static void modificationAffectation(Affectation uneA)
	{
		String requete ="Update affectation"
				+ " set id_prof = '" + uneA.getId_prof() + "',"
				+ " id_matiere = '" + uneA.getId_matiere() + "',"
				+ " id_classe = '" + uneA.getId_classe() + "',"
				+ " id_salle = '" + uneA.getId_salle() + "',"
				+ " date = '" + uneA.getDate() + "',"
				+ " duree = '" + uneA.getDuree() + "'"
				+ " where id_affectation = " + uneA.getId_affectation() + " ;";
			
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
		String requete ="Select * from affectation;";
		LinkedList<Affectation> uneListe = new LinkedList<Affectation>();
		
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
		unModele.connexion();
		try{
			Statement unStat =  (Statement) unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
			{

				int id_affectation = unRes.getInt("id_affectation");
				int id_prof = unRes.getInt("id_prof");
				int id_matiere = unRes.getInt("id_matiere");
				int id_classe = unRes.getInt("id_classe");
				int id_salle = unRes.getInt("id_salle");
				DatePPE date = new DatePPE(unRes.getDate("date"), "yyyy-MM-dd");
				HeurePPE duree = new HeurePPE(unRes.getTime("duree"), "HH:mm:ss");
				Affectation uneA = new Affectation(id_affectation, id_prof, id_matiere, id_classe, id_salle, date, duree);

				uneListe.add(uneA);
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
	
	public static Affectation selectwhere(int id_affectation)	
	{
		String requete ="Select * from affectation where id_affectation = '"+id_affectation+"';";
		Affectation uneA = null;
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
		unModele.connexion();
		try{
			java.sql.Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
				if(unRes.next())
				{
					int id_prof = unRes.getInt("id_prof");
					int id_matiere = unRes.getInt("id_matiere");
					int id_classe = unRes.getInt("id_classe");
					int id_salle = unRes.getInt("id_salle");
					DatePPE date = new DatePPE(unRes.getDate("date"), "yyyy-MM-dd");
					HeurePPE duree = new HeurePPE(unRes.getTime("duree"), "HH:mm:ss");
					uneA = new Affectation(id_affectation, id_prof, id_matiere, id_classe, id_salle, date, duree);
				}
			
			unStat.close();
		   }
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur :"+ exp);
		}
		unModele.deconnexion();
		return uneA;		
	}
	
	
	
	public static Affectation selectwhereprof(int id_prof)	
	{
		String requete ="Select * from affectation where id_prof = '"+id_prof+"';";
		Affectation uneA = null;
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
		unModele.connexion();
		try{
			java.sql.Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
				if(unRes.next())
				{
					int id_affectation = unRes.getInt("id_affectation");
					int id_matiere = unRes.getInt("id_matiere");
					int id_classe = unRes.getInt("id_classe");
					int id_salle = unRes.getInt("id_salle");
					DatePPE date = new DatePPE(unRes.getDate("date"), "yyyy-MM-dd");
					HeurePPE duree = new HeurePPE(unRes.getTime("duree"), "HH:mm:ss");
					uneA = new Affectation(id_affectation, id_prof, id_matiere, id_classe, id_salle, date, duree);
				}
			
			unStat.close();
		   }
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur :"+ exp);
		}
		unModele.deconnexion();
		return uneA;		
	}
	
	
	
	
	public static int delete(String cle)	
	{
		String requete ="delete from affectation where "
						+ " id_affectation = "+cle+";";
		
		String requete2 = "Select count(id_affectation) as nb "
						+ " from affectation where "
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
