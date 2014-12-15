package lesFantastiques.lesFantastiques;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

import twitter4j.TwitterException;
/**
 * windows principal quand on ne connecte pas l'Internet
 * 
 * @author YISHUO
 */
public class windowsFaut implements ActionListener{ 
	JFrame fenetre = new JFrame();
	JLabel image=new JLabel(new ImageIcon("img.jpg"));
	JLabel deconnecte = new JLabel(new ImageIcon("deconnecte.jpg"));
//	JTextArea area1 = new JTextArea("Vous devez être connecté à Internet !");
	JTextArea area = new JTextArea();
    Container panel = fenetre.getContentPane();
    JTextField text2 = new JTextField("Vous n’êtes pas connecté à Internet.");
    
    JButton actualise = new JButton("ACTUALISER");
    
    JList sujetFaut = new JList();
    
		
	public void actionPerformed(ActionEvent a) {
    	if(a.getSource() == this.actualise){
    		fenetre.dispose();
    		try {
				testInternet test2 = new testInternet();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}	  
    }
 
    @SuppressWarnings("rawtypes")
	public windowsFaut(){ 	
//          ajouter du fond de la fenetre
    	    fenetre.setContentPane(panel); 
    	    ImageIcon background = new ImageIcon("background.jpg");
            JLabel imgLabel = new JLabel(background);//mettre l'image du fond dans le label 

            imgLabel.setBounds(0,0,background.getIconWidth(), background.getIconHeight());
		    ((JComponent) panel).setOpaque(false);
		    fenetre.getLayeredPane().setLayout(null);
    	    fenetre.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
    	    
         	JPanel card0 = new JPanel();
        	card0.setLayout(new BorderLayout());
        	card0.add(image);

    	    JPanel card1 = new JPanel();
    	    card1.setOpaque(false);
    	    card1.setLayout(new FlowLayout());
    	    area.setOpaque(false);
    	    card1.add(area);
//    	    area.setLineWrap(true);
    	    
    	    JPanel card2 = new JPanel();
    	    card2.setLayout(new BorderLayout());
        	card2.add(deconnecte);
        	
        	sujetFaut = windows.sujet;
        	sujetFaut.setBorder(BorderFactory.createTitledBorder(" Les trends du moment : "));
		    panel.setLayout(null);
		    panel.add(card0);
		    card0.setBounds(40, 20, 230, 100);
	        panel.add(sujetFaut);
	        sujetFaut.setBounds(40, 140, 230, 210);
		    panel.add(actualise);
		    actualise.setBounds(40, 400, 110, 25);
		    panel.add(card2);
		    card2.setBounds(160, 400, 110, 25);
		    panel.add(card1);
		    card1.setBounds(300, 20, 660, 500);
		    panel.add(text2);
		    text2.setBounds(500, 250, 210, 20);
            actualise.addActionListener(this);
            fenetre.setTitle("4F NEWS");
            fenetre.setSize(1000,600);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//          fenetre.pack();
            fenetre.setVisible(true);
            fenetre.setLocationRelativeTo(null);
        
	    }
}