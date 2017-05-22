package Modeles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import Controleurs.Classe;
import Controleurs.Salle;

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
				String niveau = unRes.getString("niveau");
			
				Classe uneC = new Classe(id_classe, nb_eleve, niveau);
				uneListe.add(uneC);
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
				String niveau = unRes.getString("niveau");
				unP = new Classe(id_classe, nb_eleve, niveau);
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
	
	public static void insertionClasse(Classe uneC)
	{
		String requete ="Insert into classe ("
				+ "nb_eleve, niveau "
				+ ") values ("
				+ "'"+uneC.getNb_eleve()
				+ "', '"+uneC.getNiveau()+"');";
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
	
	public static void modificationClasse(Classe uneC)
	{
		String requete ="Update classe"
				+ " set nb_eleve = '" + uneC.getNb_eleve() + "',"
				+ " niveau = " + uneC.getNiveau() 
				+ " where id_classe = " + uneC.getId_classe() + " ;";
			
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
		String requete ="delete from classe where "
						+ " id_classe = "+cle+";";
		
		String requete2 = "Select count(id_classe) as nb "
						+ " from classe where "
						+ " id_classe = "+cle+";";
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
