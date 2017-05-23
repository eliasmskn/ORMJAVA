package Vues;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import Controleurs.Affectation;
import Controleurs.Matiere;
import Modeles.Modele_Affectation;
import Modeles.Modele_Matiere;

public class Vue_Prof extends JFrame implements ActionListener 
{
	private JPanel panelMenu = new JPanel();
	private JPanel panelTitre = new JPanel();
	private JPanel panelRechercher = new JPanel();
	private JPanel panelCentral = new JPanel();
	private JPanel paneltitreaccueil = new JPanel();
	private JPanel paneltitrearech = new JPanel();
	
	
	private JLabel lbtitreaccueil = new JLabel("Espace Professeur");
	private JLabel lbtitre = new JLabel("Gestion - Planning");
	private JLabel lbmenu = new JLabel("Menu Principal", SwingConstants.CENTER);
	private JButton btGestionSalle = new JButton("Gestion Salles");
	private JButton btRechercher = new JButton(new ImageIcon("loupe.png"));
	private JButton btQuitter = new JButton(new ImageIcon("exit.png"));
	private JLabel uneImage = new JLabel(new ImageIcon("A.png"));
	
	// panel rechercher
	
	private JLabel lbtitrearech = new JLabel("Recherche de matiere");
	private JButton btOk = new JButton("OK");
	private JComboBox cbxMatiere = new JComboBox<>();
	private JTextArea txtRecherche = new JTextArea();
	
    public Vue_Prof() 
	{
		this.setTitle("Gestion - Planning");
		this.setResizable(false);
		this.setSize(1900, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		// construction du panel titre
		
		Font T = new Font("Serif", Font.BOLD, 40);
		this.panelTitre.setBounds(0, 0, 1900, 100);
		this.panelTitre.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelTitre.setBackground(Color.lightGray);
		this.panelTitre.setLayout(new FlowLayout());
		this.lbtitre.setFont(T);
		this.panelTitre.add(this.lbtitre, SwingConstants.CENTER);
		this.panelTitre.setVisible(true);
		this.add(this.panelTitre);
		
		//Construction du panel titre acceuil
		
		Font TA= new Font("Serif", Font.BOLD, 30);
		this.paneltitreaccueil.setBounds(930, 200, 350, 70);
		this.paneltitreaccueil.setBorder(BorderFactory.createLineBorder(Color.black));
		this.paneltitreaccueil.setBackground(Color.lightGray);
		this.paneltitreaccueil.setLayout(new FlowLayout());
		this.lbtitreaccueil.setFont(TA);
		this.paneltitreaccueil.add(this.lbtitreaccueil, SwingConstants.CENTER);
		this.paneltitreaccueil.setVisible(true);
		this.add(this.paneltitreaccueil);
		

		// construction du panel Central
		
		this.panelCentral.setBounds(300, 100, 1600, 900);
		this.panelCentral.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelCentral.setBackground(Color.white);
		this.panelCentral.setLayout(null);
		this.uneImage.setBounds(500, 150, 600, 600);
		this.panelCentral.add(this.uneImage);
		this.panelCentral.setVisible(true);
		this.add(this.panelCentral);
		
		
		
		// construction du panel menu
		
		Font M = new Font("Serif", Font.BOLD, 30);
		this.panelMenu.setBounds(0, 100, 300, 900);
		this.panelMenu.setBorder(BorderFactory.createLineBorder(Color.black));
		this.panelMenu.setBackground(Color.lightGray);
		this.panelMenu.setLayout(new GridLayout(8, 1));
		this.lbmenu.setFont(M);
		this.panelMenu.add(this.lbmenu);
		this.btGestionSalle.setBackground(Color.white);
		this.panelMenu.add(this.btGestionSalle);
		this.btQuitter.setBackground(Color.white);
		this.panelMenu.add(this.btQuitter);
		this.panelMenu.add(new JLabel(""));
		this.panelMenu.setVisible(true);
		this.add(this.panelMenu);
		
		
		
		
		
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
		this.cbxMatiere.setBounds(375, 50, 200, 20);
		this.panelRechercher.add(this.cbxMatiere);
		this.btOk.setBounds(580, 50, 100, 20);
		this.btOk.setBackground(Color.white);
		this.panelRechercher.add(this.btOk);
		this.txtRecherche.setBounds(375, 100, 310, 300);
		this.panelRechercher.add(this.txtRecherche, SwingConstants.CENTER);
		
		this.panelRechercher.setVisible(false);
		this.add(this.panelRechercher);
		
		
		// rendre les bouton ecoutable
		
		this.btGestionSalle.addActionListener(this);
		this.btQuitter.addActionListener(this);
	}
	
    private void remplirCBX() 
	{
		// remplire le comboBox
		
		LinkedList<Affectation> uneListe = Modele_Affectation.selectall();
		this.cbxMatiere.removeAllItems();
		for(Affectation uneM : uneListe)
		{
			this.cbxMatiere.addItem(uneM.getDate()+" - "+uneM.getId_classe());
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btQuitter)
		{
			if(JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application ?","Quitter", JOptionPane.OK_CANCEL_OPTION)== 0)
			{
				this.dispose();
			}
		}
		else if(e.getSource() == this.btGestionSalle)
		{
			new Vue_GestionSalle();
			this.dispose();
		}
		else if(e.getSource() == this.btRechercher)
		{
			this.remplirCBX();
			this.panelRechercher.setVisible(true);
			this.paneltitrearech.setVisible(true);
			
		}
		else if(e.getSource() == this.btOk)
		{
			
			String chaine = this.cbxMatiere.getSelectedItem().toString();
			String tab[] = chaine.split(" - "); // explode
			Matiere uneM = Modele_Matiere.selectwhere(Integer.parseInt(tab[0]));
			this.txtRecherche.setText(uneM.toString());
			this.txtRecherche.setEditable(false);
		}
	}
	
}
