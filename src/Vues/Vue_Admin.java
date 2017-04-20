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


public class Vue_Admin extends JFrame implements ActionListener
{
	// les panels
	private JPanel panelMenu = new JPanel();
	private JPanel panelTitre = new JPanel();
	private JPanel panelCentral = new JPanel();
	private JPanel paneltitreaccueil = new JPanel();
	
	private JLabel lbtitreaccueil = new JLabel("Page d'accueil");
	private JLabel lbtitre = new JLabel("CASTELLANE - AUTO");
	private JLabel lbmenu = new JLabel("Menu Principal", SwingConstants.CENTER);
	private JButton btGestionSalle = new JButton("Gestion Salles");
	private JButton btGestionCour = new JButton("Gestion Cours");
	private JButton btGestionMatiere = new JButton("Gestion Matieres");
	private JButton btGestionClasse = new JButton("Gestion Classes");
	private JButton btGestionProfesseur = new JButton("Gestion Professeurs");
	private JButton btQuitter = new JButton(new ImageIcon("exit.png"));
	private JLabel uneImage = new JLabel(new ImageIcon("A.png"));
	
	
	
    public Vue_Admin() 
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
		this.btGestionCour.setBackground(Color.white);
		this.panelMenu.add(this.btGestionCour);
		this.btGestionMatiere.setBackground(Color.white);
		this.panelMenu.add(this.btGestionMatiere);
		this.btGestionClasse.setBackground(Color.white);
		this.panelMenu.add(this.btGestionClasse);
		this.btGestionProfesseur.setBackground(Color.white);
		this.panelMenu.add(this.btGestionProfesseur);
		this.btQuitter.setBackground(Color.white);
		this.panelMenu.add(this.btQuitter);
		this.panelMenu.add(new JLabel(""));
		this.panelMenu.setVisible(true);
		this.add(this.panelMenu);
		
		
		// rendre les bouton ecoutable
		
		this.btGestionSalle.addActionListener(this);
		this.btGestionCour.addActionListener(this);
		this.btGestionMatiere.addActionListener(this);
		this.btGestionClasse.addActionListener(this);
		this.btGestionProfesseur.addActionListener(this);
		this.btQuitter.addActionListener(this);
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
		else if(e.getSource() == this.btGestionCour)
		{
			new Vue_GestionCour();
			this.dispose();
		}
		else if(e.getSource() == this.btGestionMatiere)
		{
			new Vue_GestionMatiere();
			this.dispose();
			
		}
		else if(e.getSource() == this.btGestionClasse)
		{
			new Vue_GestionClasse();
			this.dispose();	
		}
		else if(e.getSource() == this.btGestionProfesseur)
		{
			new Vue_GestionProfesseur();
			this.dispose();	
		}
	}
	
}
