package Modeles;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import Controleurs.Prof;
import Modeles.Modele;

public class Modele_Prof 
{		

		
			public static String [] verifConnexionProf(String identifiant, String mdp)
			{
				String resultat [] = new String[3];
				String requete = "Select count(identifiant) as nb, nom, prenom"
						+ " from professeur where identifiant ='"+identifiant
						+"' and mdp ='"+mdp+"';";
				Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
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
						resultat [1] = unRes.getString("nom");
						resultat [2] = unRes.getString("prenom");
					}
				}
				catch(SQLException exp)
				{
					System.out.println("Erreur de la requette : " + requete +" | Message :"+ exp);
				}
				unModele.connexion();
				return resultat;
			}
			
			
			
			public static int sendIdProf(String identifiant, String mdp)
			{
				int resultat = 0;
				String requete = "Select id_prof"
						+ " from professeur where identifiant ='"+identifiant
						+"' and mdp ='"+mdp+"';";
				Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
				unModele.changerPilot();
				unModele.connexion();
				try
				{
					Statement unStat = (Statement) unModele.getMaConnexion().createStatement();
					ResultSet unRes = unStat.executeQuery(requete);
					unRes.next();
					int id_prof = unRes.getInt("id_prof");
					
					resultat = id_prof;
				}
				catch(SQLException exp)
				{
					System.out.println("Erreur de la requette : " + requete +" | Message :"+ exp);
				}
				unModele.connexion();
				return resultat;
			}
			
			
			
			public static LinkedList<Prof> selectall()
			{
				String requete ="Select * from professeur;";
				LinkedList<Prof> uneListe = new LinkedList<Prof>();
				
				Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
				unModele.connexion();
				try{
					Statement unStat =  (Statement) unModele.getMaConnexion().createStatement();
					
					ResultSet unRes = unStat.executeQuery(requete);
					
					while(unRes.next())
					{
						int id_prof = unRes.getInt("id_prof");
						String nom = unRes.getString("nom");
						String prenom = unRes.getString("prenom");
						String identifiant = unRes.getString("identifiant");
						String mdp = unRes.getString("mdp");
						Prof unP = new Prof(id_prof, nom, prenom, identifiant, mdp);
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
			
			public static Prof selectwhere(int id_prof)	
			{
				String requete ="Select * from professeur where id_prof = '"+id_prof+"';";
				Prof unP = null;
				Modele unModele = new Modele("127.0.0.1", "gestion_planning", "root", "");
				unModele.connexion();
				try{
					java.sql.Statement unStat =  unModele.getMaConnexion().createStatement();
					
					ResultSet unRes = unStat.executeQuery(requete);
					
					if(unRes.next())
					{
						String nom = unRes.getString("nom");
						String prenom = unRes.getString("prenom");
						String identifiant = unRes.getString("identifiant");
						String mdp = unRes.getString("mdp");
						unP = new Prof(id_prof, nom, prenom, identifiant, mdp);
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
			
			public static void insertionProf(Prof unP)
			{
				String requete ="Insert into professeur ("
						+ "nom, prenom, "
						+ "identifiant, mdp"
						+ ") values ("
						+ "'"+unP.getNom()
						+ "', '"+unP.getPrenom()+"','"+unP.getIdentifiant()
						+ "', '"+unP.getMdp()+"');";
				
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
			
			public static void modificationProf(Prof unP)
			{
				String requete ="Update professeur"
						+ " set nom = '" + unP.getNom() + "',"
						+ " prenom = '" + unP.getPrenom() + "', "
						+ " identifiant = '" + unP.getIdentifiant() + "', "
						+ " mdp = '" + unP.getMdp() + "' "
						+ " where id_prof = '" + unP.getId_prof() + "' ;";
					
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
				String requete ="delete from professeur where "
								+ " id_prof = "+cle+";";
				
				String requete2 = "Select count(id_prof) as nb "
								+ " from professeur where "
								+ " id_prof = "+cle+";";
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
