package Vues;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Vue_GestionProfesseur extends JFrame implements ActionListener 
{		
			//Les Pannels
			
			private JPanel panelTitre = new JPanel();
			private JPanel panelMenu = new JPanel();
			private JPanel paneldefaut = new JPanel();
			private JPanel panelLister = new JPanel();
			private JPanel panelAjouter = new JPanel();
			private JPanel panelModifier = new JPanel();
			private JPanel panelSupprimer = new JPanel();
			private JPanel panelRechercher = new JPanel();
			private JPanel panelQuitter = new JPanel();
			private JPanel paneltitreajout = new JPanel();
			private JPanel paneltitremodif = new JPanel();
			private JPanel paneltitrelister = new JPanel();
			private JPanel paneltitreasupp = new JPanel();
			private JPanel paneltitrearech = new JPanel();
			private JPanel panelaffichemoniteur = new JPanel();
			private JPanel paneltitreaffichemoniteur = new JPanel();
			
			private JLabel lbTitre = new JLabel("Espace Admin");
			private JLabel lbMenu = new JLabel("Menu gestion planning");
			private JLabel uneImage = new JLabel(new ImageIcon("staff.png"));
			private JButton btLister = new JButton(new ImageIcon("list.png"));
			private JButton btModifier = new JButton(new ImageIcon("edit.png"));
			private JButton btAjouter = new JButton(new ImageIcon("add.png"));
			private JButton btSupprimer = new JButton(new ImageIcon("delete.png"));
			private JButton btRechercher = new JButton(new ImageIcon("loupe.png"));
			private JButton btQuitter = new JButton(new ImageIcon("exit.png"));
			
			// constructiuon des objet du Ajouter
			private JLabel lbtitreajout = new JLabel("Ajout d'un professeur");
			private JTextField tfIdprof = new JTextField();
			private JTextField tfNom = new JTextField();
			private JTextField tfPrenom = new JTextField();
			private JTextField tfIdentifiant= new JTextField();
			private JTextField tfMdp = new JTextField();
			private JButton btEnregistrer = new JButton("Enregistrer");
			private JButton btAnnuler = new JButton("Annuler");
			
			
			// constructiuon des objet du panel modifier
				private JLabel lbtitremodif = new JLabel("Modification d'un professeur");
				private JTextField tfIdprof1 = new JTextField();
				private JTextField tfNom1 = new JTextField();
				private JTextField tfPrenom1 = new JTextField();
				private JTextField tfIdentifiant1 = new JTextField();
				private JTextField tfMdp1 = new JTextField();
				private JButton btMaj = new JButton("Mettre à jour");
				private JButton btAnnuler1 = new JButton("Annuler");
				
				
			// panel lister
			private JLabel lbtitrelister = new JLabel("Liste des professeurs");
			private JButton btFermer = new JButton("Fermer");
			private JTable uneTable = null;
			
			
			// panel rechercher
			
			private JLabel lbtitrearech = new JLabel("Recherche de professeur");
			private JButton btOk = new JButton("OK");
			private JComboBox cbxMoniteurs = new JComboBox<>();
			private JTextArea txtRecherche = new JTextArea();
				
			// panel supprimer
			
			private JLabel lbtitreasupp = new JLabel("Suppression d'un professeur");
			private JButton btSupp = new JButton("Supprimer");
			private JTextField tfCle = new JTextField();
			private JLabel lbResultat = new JLabel("Resultat :");
			
			 public Vue_GestionProfesseur() 
			{
				this.setTitle("Gestion des professeurs ");
				this.setResizable(false);
				this.setSize(1900, 1000);
				this.setBackground(Color.white);
				this.setLocationRelativeTo(null);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setLayout(null);
				
				// construction du panel titre
				
				Font T = new Font("Serif", Font.BOLD, 40);
				this.panelTitre.setBounds(0, 5, 1900, 105);
				this.panelTitre.setBorder(BorderFactory.createLineBorder(Color.black));
				this.panelTitre.setBackground(Color.lightGray);
				this.panelTitre.setLayout(new FlowLayout());
				this.lbTitre.setFont(T);
				this.panelTitre.add(this.lbTitre, SwingConstants.CENTER);
				this.panelTitre.setVisible(true);
				this.add(this.panelTitre);
				
				
//				// construction du panel titre Affiche moniteur
//				
						Font TA = new Font("Serif", Font.PLAIN, 30);
//						this.paneltitreaffichemoniteur.setBounds(650, 250, 350, 50);
//						this.paneltitreaffichemoniteur.setBackground(Color.lightGray);
//						this.paneltitreaffichemoniteur.setLayout(new FlowLayout());
//						this.paneltitreaffichemoniteur.add(this.lbtitreaffichemon);
//						this.paneltitreaffichemoniteur.setVisible(true);
				
				
//				
//				// construction du panel Affiche Moniteur
//				
//						this.panelaffichemoniteur.setBounds(520, 350, 600, 450);
//						this.panelaffichemoniteur.setBorder(BorderFactory.createLineBorder(Color.black));
//						this.panelaffichemoniteur.setBackground(Color.LIGHT_GRAY);
//						this.panelaffichemoniteur.setLayout(null);
//						this.panelaffichemoniteur.setVisible(true);
				
				
				// construction du panel Central par defaut
				
				
				this.paneldefaut.setBounds(251, 106, 1650, 895);
				this.paneldefaut.setBorder(BorderFactory.createLineBorder(Color.black));
				this.paneldefaut.setBackground(Color.white);
				this.paneldefaut.setLayout(null);
				this.uneImage.setBounds(750, 20, 200, 200);
				this.paneldefaut.add(this.uneImage);
				this.paneldefaut.setVisible(true);
//				this.paneldefaut.add(this.panelaffichemoniteur);
//				this.paneldefaut.add(this.paneltitreaffichemoniteur, SwingConstants.CENTER);
				this.add(this.paneldefaut);
				
				
				
				
				
				
				
				
				
				// construction du panel menu
				
				this.panelMenu.setBounds(0, 100, 250, 900);
				this.panelMenu.setBorder(BorderFactory.createLineBorder(Color.black));
				this.panelMenu.setBackground(Color.LIGHT_GRAY);
				this.panelMenu.setLayout(new GridLayout(8, 1));
				Font M = new Font("Serif", Font.BOLD, 25);
				this.lbMenu.setFont(M);
				this.panelMenu.add(this.lbMenu, SwingConstants.CENTER);
				this.btLister.setBackground(Color.white);
				this.panelMenu.add(this.btLister);
				this.btModifier.setBackground(Color.white);
				this.panelMenu.add(this.btModifier);
				this.btAjouter.setBackground(Color.white);
				this.panelMenu.add(this.btAjouter);
				this.btRechercher.setBackground(Color.white);
				this.panelMenu.add(this.btRechercher);
				this.btSupprimer.setBackground(Color.white);
				this.panelMenu.add(this.btSupprimer);
				this.btQuitter.setBackground(Color.white);
				this.panelMenu.add(this.btQuitter);
				this.panelMenu.add(new JLabel(""));
				this.panelMenu.setVisible(true);
				this.add(this.panelMenu);
				
				// rendre les bouton ecoutable
				
				this.btAjouter.addActionListener(this);
				this.btModifier.addActionListener(this);
				this.btLister.addActionListener(this);
				this.btRechercher.addActionListener(this);
				this.btSupprimer.addActionListener(this);
				this.btQuitter.addActionListener(this);
				this.btAnnuler.addActionListener(this);
				this.btEnregistrer.addActionListener(this);
				this.btMaj.addActionListener(this);
				this.btFermer.addActionListener(this);
				this.btOk.addActionListener(this);
				this.btSupp.addActionListener(this);
				
				
				// construction du panel titre Ajout
				
				Font TAF = new Font("Serif", Font.PLAIN, 30);
				this.paneltitreajout.setBounds(900, 180, 350, 50);
				this.paneltitreajout.setBackground(Color.lightGray);
				this.paneltitreajout.setLayout(new FlowLayout());
				this.lbtitreajout.setFont(TA);
				this.paneltitreajout.add(this.lbtitreajout, SwingConstants.CENTER);
				this.add(this.paneltitreajout);
				this.paneltitreajout.setVisible(false);
						
				
				// construction panel ajouter
				
				this.panelAjouter.setBounds(470, 300, 1200, 600);
				this.panelAjouter.setBorder(BorderFactory.createLineBorder(Color.black));
				this.panelAjouter.setLayout(new GridLayout(15, 2));
				this.panelAjouter.add(new JLabel());
				this.panelAjouter.add(new JLabel());
				this.panelAjouter.add(new JLabel());
				this.panelAjouter.add(new JLabel());
				this.panelAjouter.add(new JLabel("Nom Professeur :", SwingConstants.CENTER));
				this.panelAjouter.add(this.tfNom);	
				this.panelAjouter.add(new JLabel("Prenom Professeur :", SwingConstants.CENTER));
				this.panelAjouter.add(this.tfPrenom);
				this.panelAjouter.add(new JLabel("Adresse Professeur:", SwingConstants.CENTER));
				this.panelAjouter.add(this.tfIdentifiant);	
				this.panelAjouter.add(new JLabel("Identifiant Professeur :", SwingConstants.CENTER));
				this.panelAjouter.add(new JLabel("Mdp Professeur :", SwingConstants.CENTER));
				this.panelAjouter.add(this.tfMdp);
				this.panelAjouter.add(new JLabel());
				this.panelAjouter.add(new JLabel());
				
				this.btAnnuler.setBackground(Color.white);
				this.panelAjouter.add(this.btAnnuler);
				this.btEnregistrer.setBackground(Color.white);
				this.panelAjouter.add(this.btEnregistrer);
				
				this.panelAjouter.setVisible(false);
				this.add(this.panelAjouter);
				
				
				
				// construction du panel titre Modif
				
				Font TM = new Font("Serif", Font.PLAIN, 30);
				this.paneltitremodif.setBounds(900, 180, 350, 50);
				this.paneltitremodif.setBackground(Color.lightGray);
				this.paneltitremodif.setLayout(new FlowLayout());
				this.lbtitremodif.setFont(TM);
				this.paneltitremodif.add(this.lbtitremodif, SwingConstants.CENTER);
				this.add(this.paneltitremodif);
				this.paneltitremodif.setVisible(false);
								
						
				// construction panel ajouter
				
				this.panelModifier.setBounds(470, 300, 1200, 600);
				this.panelModifier.setBorder(BorderFactory.createLineBorder(Color.black));
				this.panelModifier.setLayout(new GridLayout(15, 2));
				this.panelModifier.add(new JLabel());
				this.panelModifier.add(new JLabel());
				this.panelModifier.add(new JLabel("Num Professeur :", SwingConstants.CENTER));
				this.panelModifier.add(this.tfIdprof1);
				this.panelModifier.add(new JLabel("Nom Professeur :", SwingConstants.CENTER));
				this.panelModifier.add(this.tfNom1);	
				this.panelModifier.add(new JLabel("Prenom Professeur :", SwingConstants.CENTER));
				this.panelModifier.add(this.tfPrenom1);
				this.panelModifier.add(new JLabel("Adresse Professeur:", SwingConstants.CENTER));
				this.panelModifier.add(this.tfIdentifiant);	
				this.panelModifier.add(new JLabel("Telephone Professeur :", SwingConstants.CENTER));
				this.panelModifier.add(new JLabel("Mdp Professeur :", SwingConstants.CENTER));
				this.panelModifier.add(this.tfMdp1);
				this.panelModifier.add(new JLabel());
				this.panelModifier.add(new JLabel());
					
				this.btAnnuler1.setBackground(Color.white);
				this.panelModifier.add(this.btAnnuler1);
				this.btMaj.setBackground(Color.white);
				this.panelModifier.add(this.btMaj);
						
				this.panelModifier.setVisible(false);
				this.add(this.panelModifier);
						
				

				// construction du panel titre lister
				
				Font TL = new Font("Serif", Font.PLAIN, 30);
				this.paneltitrelister.setBounds(900, 180, 350, 50);
				this.paneltitrelister.setBackground(Color.lightGray);
				this.paneltitrelister.setLayout(new FlowLayout());
				this.lbtitrelister.setFont(TL);
				this.paneltitrelister.add(this.lbtitrelister, SwingConstants.CENTER);
				this.add(this.paneltitrelister);
				this.paneltitrelister.setVisible(false);
				
				
				
				// construction panel lister
				
				this.panelLister.setBounds(470, 300, 1200, 600);
				this.panelLister.setBorder(BorderFactory.createLineBorder(Color.black));
				this.panelLister.setLayout(null);
				this.btFermer.setBounds(520, 450, 140, 30);
				this.btFermer.setBackground(Color.white);
				this.panelLister.add(this.btFermer);	
				this.panelLister.setVisible(false);
				this.add(this.panelLister);
				
				
			// construction du panel titre rechercher
				
				Font TR = new Font("Serif", Font.PLAIN, 30);
				this.paneltitrearech.setBounds(900, 180, 350, 50);
				this.paneltitrearech.setBackground(Color.lightGray);
				this.paneltitrearech.setLayout(new FlowLayout());
				this.lbtitrearech.setFont(TR);
				this.paneltitrearech.add(this.lbtitrearech, SwingConstants.CENTER);
				this.add(this.paneltitrearech);
				this.paneltitrearech.setVisible(false);
				
					
				// construction panel rechercher
				
				this.panelRechercher.setBounds(570, 300, 1000, 500);
				this.panelRechercher.setBorder(BorderFactory.createLineBorder(Color.black));
				this.panelRechercher.setLayout(null);
				this.cbxMoniteurs.setBounds(375, 50, 200, 20);
				this.panelRechercher.add(this.cbxMoniteurs);
				this.btOk.setBounds(580, 50, 100, 20);
				this.btOk.setBackground(Color.white);
				this.panelRechercher.add(this.btOk);
				this.txtRecherche.setBounds(375, 100, 310, 300);
				this.panelRechercher.add(this.txtRecherche, SwingConstants.CENTER);
				
				this.panelRechercher.setVisible(false);
				this.add(this.panelRechercher);
				
				
				// construction du panel titre rechercher
					
					Font TS = new Font("Serif", Font.PLAIN, 30);
					this.paneltitreasupp.setBounds(900, 180, 350, 50);
					this.paneltitreasupp.setBackground(Color.lightGray);
					this.paneltitreasupp.setLayout(new FlowLayout());
					this.lbtitreasupp.setFont(TS);
					this.paneltitreasupp.add(this.lbtitreasupp, SwingConstants.CENTER);
					this.add(this.paneltitreasupp);
					this.paneltitreasupp.setVisible(false);
					
				  
				// construction panel supprimer
				
				this.panelSupprimer.setBounds(570, 300, 1000, 500);
				this.panelSupprimer.setBorder(BorderFactory.createLineBorder(Color.black));
				this.panelSupprimer.setLayout(null);
				this.tfCle.setBounds(375, 50, 200, 20);
				this.panelSupprimer.add(this.tfCle);
				this.btSupp.setBounds(580, 50, 100, 20);
				this.btSupp.setBackground(Color.white);
				this.panelSupprimer.add(this.btSupp);
				this.lbResultat.setBounds(375, 100, 310, 150);
				this.panelSupprimer.add(this.lbResultat);
				
				this.panelSupprimer.setVisible(false);
				this.add(this.panelSupprimer);
				
				this.setVisible(true);
				
			}
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			
			}



