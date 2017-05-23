package Vues;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.TextStyle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Modeles.Modele_Prof;
import Modeles.Modele_Admin;

public class Vue_Connexion extends JFrame implements ActionListener{
	
		private JTextField tfemail = new JTextField();
		private JPasswordField tfMdp = new JPasswordField();
		private JPanel unPanel = new JPanel();
		private JPanel dePanel = new JPanel();
		private JButton btAnnuler = new JButton("Annuler");
		private JButton btValider = new JButton("Valider");
		
		private JComboBox categorieUser;
		private JLabel lbtitre = new JLabel("Espace Connexion", SwingConstants.CENTER);

		
		public Vue_Connexion() 
		{
			this.setSize(600, 500);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("Castellane - Auto");
			this.setResizable(false);
			

			
			
			
			this.dePanel.setBounds(0,  0, 600, 50);
			Font T = new Font("Serif", Font.PLAIN, 30);
			this.lbtitre.setFont(T);
			this.dePanel.add(this.lbtitre);
			this.dePanel.setVisible(true);
			this.add(this.dePanel);
			
			Font myFont = new Font("Serif", Font.BOLD, 24);
			
			this.unPanel.setBackground(Color.LIGHT_GRAY);
			this.unPanel.setLayout(new GridLayout(9,4,5,5));
			this.unPanel.add(new JLabel());
			this.unPanel.add(new JLabel());
			this.unPanel.add(new JLabel());
			this.unPanel.add(new JLabel());
			this.unPanel.add(new JLabel("Email :", SwingConstants.CENTER));
			this.unPanel.add(this.tfemail);
			this.unPanel.add(new JLabel());
			this.unPanel.add(new JLabel());
			this.unPanel.add(new JLabel("Mot de passe :", SwingConstants.CENTER));
			this.unPanel.add(this.tfMdp);
			this.unPanel.add(new JLabel());
			this.unPanel.add(new JLabel());
			this.btAnnuler.setBackground(Color.white);
			this.btValider.setBackground(Color.white);
			Object[] elements = new Object[]{"admin", "prof"};
			 
			categorieUser = new JComboBox(elements);
			this.unPanel.add(new JLabel("Cat�gorie :", SwingConstants.CENTER));
			this.unPanel.add(categorieUser);
			this.unPanel.add(new JLabel());
			this.unPanel.add(new JLabel());
			this.unPanel.add(this.btAnnuler);
			this.unPanel.add(this.btValider);	
			
			this.unPanel.setVisible(true);
			
			this.add(this.unPanel);
			
			this.btAnnuler.addActionListener(this);
			this.btValider.addActionListener(this);
			
			this.setVisible(true);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
				
			if(e.getSource() == this.btAnnuler)
			{
				this.tfemail.setText("");
				this.tfMdp.setText("");
			}
			else if(e.getSource() == this.btValider)
			{
				String resultat[] ;
				String email = this.tfemail.getText();
				String mdp = new String (this.tfMdp.getPassword());
				String listeSelect = (String) this.categorieUser.getSelectedItem();
				if(listeSelect.equals("prof"))
				{
				 resultat = Modele_Prof.verifConnexionProf(email, mdp);
				}
				else
				{
					 resultat = Modele_Admin.verifConnexion(email, mdp);
				}
				
				
				if(resultat[0]==null)
				{
					JOptionPane.showMessageDialog(this, "Verifier vos identifiants");				
				}
				else if(listeSelect.equals("prof"))
				{

					JOptionPane.showMessageDialog(this, "Bonjour professeur" + "   " + resultat[0] + "   " +resultat[2]);
					new Vue_Prof(resultat[0]);

					this.dispose();
				}
				else if(listeSelect.equals("admin"))
				{
					JOptionPane.showMessageDialog(this, "Bonjour administrateur" + "   " + resultat[1] + "   " +resultat[2]);
					new Vue_Admin();
					this.dispose();
				}
			}
	}

}
