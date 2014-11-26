package lesFantastiques.lesFantastiques;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
/**
 * windows principal quand on ne connecte pas l'Internet
 * 
 * @author YISHUO
 */
public class windowsFaut implements ActionListener{ 
	JFrame fenetre = new JFrame();
	JLabel image=new JLabel(new ImageIcon("img.jpg"));
	JTextArea area1 = new JTextArea("Vous devez être connecté à Internet !");
	JTextArea area = new JTextArea();
    Container panel = fenetre.getContentPane();
    
    JButton actualise = new JButton("ACTUALISER");
		
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
    	    area1.setBorder(BorderFactory.createTitledBorder(" Les trends du moment : "));
    	
//          ajouter du fond de la fenetre
    	    fenetre.setContentPane(panel); 
    	    ImageIcon background = new ImageIcon("background.jpg");
            JLabel imgLabel = new JLabel(background);//mettre l'image du fond dans le label 
//          imgLabel.setSize(fenetre.getWidth(), fenetre.getHeight());

            imgLabel.setBounds(0,0,background.getIconWidth(), background.getIconHeight());
//            panel = (JPanel) fenetre.getContentPane();
		    ((JComponent) panel).setOpaque(false);
		    fenetre.getLayeredPane().setLayout(null);
    	    fenetre.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
    	

         	JPanel card0 = new JPanel();
        	card0.setLayout(new BorderLayout());
        	card0.add(image);
//    	    card0.add(bienvenue,BorderLayout.CENTER);
//    	    bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
//    	    bienvenue.setFont(new Font("NEW ROMAIN",Font.BOLD,20));
    	
    	    JPanel card1 = new JPanel();
    	    card1.setLayout(new FlowLayout());
    	    card1.add(actualise);

    	    JPanel card2 = new JPanel();
    	    card2.setOpaque(false);
    	    card2.setLayout(new FlowLayout());
    	    area.setOpaque(false);
    	    card2.add(area);
//    	    area.setLineWrap(true);
    	    
		    panel.setLayout(null);
		    panel.add(card0);
		    card0.setBounds(40, 20, 230, 100);
		    panel.add(area1);
		    area1.setBounds(40, 140, 230, 230);
		    panel.add(card1);
		    card1.setBounds(100, 390, 110, 35);
		    panel.add(card2);
		    card2.setBounds(300, 20, 660, 500);
		    
            actualise.addActionListener(this);
            fenetre.setTitle("MY INFORMATION");
            fenetre.setSize(1000,600);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//          fenetre.pack();
            fenetre.setVisible(true);
            fenetre.setLocationRelativeTo(null);
        
	    }
}