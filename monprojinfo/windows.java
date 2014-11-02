package bing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import twitter4j.TwitterException;

public class windows implements ActionListener, ListSelectionListener{ 
	JFrame fenetre = new JFrame();
	JLabel bienvenue = new JLabel("bienvenue a tous!");
    Container panel = fenetre.getContentPane();
    
    JButton actualise = new JButton("ACTUALISER");
    JButton ferme = new JButton("FERMER");
    
	String[] mylist= new String[10];
	
	public String[] trends(String[] mylist) throws TwitterException{
		recevoirtrends montrend = new recevoirtrends();
	    String[] monactu = montrend.prendretrends();
	    int a=0;
	    for(String i :monactu){
			mylist[a]=i;
			a++;
	    }
	    return mylist;
	}
	
	public void actionPerformed(ActionEvent a) {
    	if(a.getSource() == this.actualise){
    		//ajouter une action d'actualise
    	}
    	if(a.getSource() == this.ferme){
    		System.exit(0);
    	}   	  
    }
	
	
	
    MouseListener mouseListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent mouseEvent) {
            JList list = (JList) mouseEvent.getSource();
            Object[] selectedvalues = list.getSelectedValues();
//            System.out.println(selectedvalues.length);
            for (int i = 0; i < selectedvalues.length; i++) {
            	mediumWindows windows1 = new mediumWindows();	
            	windows1.pack();
        		windows1.setVisible(true);	
            }
        }
    };
 
    public void valueChanged(ListSelectionEvent e) {
    	
    }
    @SuppressWarnings("rawtypes")
	public windows(){
    	try {
			this.mylist=this.trends(mylist);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
//    	int backh = fenetre.getHeight();
//    	int backw = fenetre.getWidth();
	
    	JList sujet = new JList(mylist);
    	sujet.setBorder(BorderFactory.createTitledBorder("Les sujetstendance aujourd'hui : "));
    	
    	//ajouter du fond de la fenetre
    	fenetre.setContentPane(panel); 
    	ImageIcon background = new ImageIcon("background.jpg");
        JLabel imgLabel = new JLabel(background);//mettre l'image du fond dans le label 
        imgLabel.setSize(fenetre.getWidth(), fenetre.getHeight());

        imgLabel.setBounds(0,0,background.getIconWidth(), background.getIconHeight());
        panel = (JPanel) fenetre.getContentPane();
		((JComponent) panel).setOpaque(false);
		fenetre.getLayeredPane().setLayout(null);
    	fenetre.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
    	

    	JPanel card0 = new JPanel();
    	card0.setLayout(new BorderLayout());
    	card0.add(bienvenue,BorderLayout.CENTER);
    	bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
    	bienvenue.setFont(new Font("NEW ROMAIN",Font.BOLD,28));
    	
    	JPanel card1 = new JPanel();
    	card1.setLayout(new FlowLayout());
    	card1.add(actualise);
    	card1.add(ferme);
		panel.setLayout(null);
		panel.add(card0);
		card0.setBounds(40, 20, 260, 30);
		panel.add(sujet);
		sujet.setBounds(70, 50, 200, 230);
		panel.add(card1);
		card1.setBounds(70, 280, 200, 30);
		
	    sujet.addListSelectionListener(this);
	    sujet.addMouseListener(mouseListener);
        actualise.addActionListener(this);
        ferme.addActionListener(this);
        fenetre.setTitle("MY INFORMATION");
        fenetre.setSize(360,370);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setLocationRelativeTo(null); 

    }

	public static void main(String[] args) {
	
        @SuppressWarnings("unused")
		windows test=new windows();
        
    }

}