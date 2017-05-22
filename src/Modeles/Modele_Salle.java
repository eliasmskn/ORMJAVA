package Modeles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import Controleurs.Prof;
import Controleurs.Salle;

import com.mysql.jdbc.Statement;

public class Modele_Salle 
{
	

	
	
	public static LinkedList<Salle> selectall()
	{
		String requete ="Select * from salle;";
		LinkedList<Salle> uneListe = new LinkedList<Salle>();
		
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
		unModele.connexion();
		try{
			Statement unStat =  (Statement) unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			while(unRes.next())
			{
				int id_salle = unRes.getInt("id_salle");
				String num_salle = unRes.getString("numero_salle");
				int capacite = unRes.getInt("capacite");
				Salle uneS = new Salle(id_salle, num_salle, capacite);
				uneListe.add(uneS);
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
	
	public static Salle selectwhere(int id_salle)	
	{
		String requete ="Select * from salle where id_salle = '"+id_salle+"';";
		Salle uneS = null;
		Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
		unModele.connexion();
		try{
			java.sql.Statement unStat =  unModele.getMaConnexion().createStatement();
			
			ResultSet unRes = unStat.executeQuery(requete);
			
			if(unRes.next())
			{
				String num_salle = unRes.getString("numero_salle");
				int capacite = unRes.getInt("capacite");
				uneS = new Salle(id_salle, num_salle, capacite);
			}
			
			unStat.close();
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "Erreur :"+ exp);
		}
		unModele.deconnexion();
		return uneS;		
	}
	
	public static void insertionSalle(Salle uneS)
	{
		String requete ="Insert into salle ("
				+ "numero_salle, capacite "
				+ ") values ("
				+ "'"+uneS.getNum_salle()
				+ "', "+uneS.getCapacite()+");";
		System.out.println(requete);
			
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
	
	public static void modificationSalle(Salle uneS)
	{
		String requete ="Update salle"
				+ " set numero_salle = '" + uneS.getNum_salle() + "',"
				+ " capacite = " + uneS.getCapacite() 
				+ " where id_salle = " + uneS.getId_salle() + " ;";
			
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
	
	
	
	public static int delete(String cle)	
	{
		String requete ="delete from salle where "
						+ " id_salle = "+cle+";";
		
		String requete2 = "Select count(id_salle) as nb "
						+ " from salle where "
						+ " id_salle = "+cle+";";
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
