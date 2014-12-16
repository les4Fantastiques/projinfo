package lesFantastiques.lesFantastiques;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.billylieurance.azuresearch.AzureSearchNewsResult;
import twitter4j.TwitterException;
/**
 * windows principal
 * 
 * @author YISHUO
 */

public class windows implements ActionListener, ListSelectionListener { 
	JLabel jl2 = new JLabel("Identifiant :");
	JLabel jl3 = new JLabel("Mot de passe :");
	JButton inscrire = new JButton("S'inscrire");
	JButton login = new JButton("Se connecter");
	JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
	
	
	
	JFrame fenetre = new JFrame();
	JLabel image = new JLabel(new ImageIcon("img.jpg"));
	JLabel connecte = new JLabel(new ImageIcon("connecte.jpg"));
	JLabel debut = new JLabel("CLiquez sur une trend pour voir les BingNews correspondantes.");
	JTextField text = new JTextField(660);
	JTextField suggestion = new JTextField();
    Container panel = fenetre.getContentPane();
    JButton actualise = new JButton("ACTUALISER");
    JPanel card3 = new JPanel();
    JScrollPane card3Scroll = new JScrollPane(card3);
    
	public static String[] mylist= new String[10];
	String titre = null;

	public String[] trends(String[] mylist) throws TwitterException{
		recevoirtrends montrend = new recevoirtrends();
	    String[] monactu = montrend.prendretrends();
	    int a=0;
	    for(String i : monactu){
			mylist[a]=i;
			a++;
	    }
	    return mylist;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static
	JList sujet = new JList(mylist);
	public void actionPerformed(ActionEvent a) {
    	if(a.getSource() == this.actualise){
    		fenetre.dispose();
    		try {
				
				testInternet test1 = new testInternet();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}	  
    }
	
	MouseListener mouseListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent mouseEvent) {
			JList list = (JList) mouseEvent.getSource();
			Object[] selectedvalues = list.getSelectedValues();
            for (int i = 0; i < selectedvalues.length; i++) {
            	titre = selectedvalues[i].toString();
            	text.setText("Voici les BingNews pour "+titre);
            	text.setHorizontalAlignment(JTextField.CENTER);
            	text.setBackground(Color.WHITE);
            	}      	
        }
    };
/*    MouseListener mouseWeb = new MouseAdapter(){
    	public void mouseClickedWeb(MouseEvent mouseEventWeb){
    		mouseEventWeb.getSource();
    		System.out.println("尼玛");
    	}
    };
*/    
 	public void valueChanged(ListSelectionEvent e) {
 		card3Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 		card3Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
 		if(e.getValueIsAdjusting()==true){
    		if (e.getSource() == sujet && sujet.getSelectedValue() != null){
    	    BingSearchService aaa = new BingSearchService();
		    aaa.rechercheNewsBing(sujet.getSelectedValue().toString());
		    card3.removeAll();//supprimer tous les components sur le precedent card3
		    int rows1 = 0;
		    int rows2 = 0;
		    for (AzureSearchNewsResult newBing : BingSearchService.getNewsBing()) {	
		    	rows1 += 1;
		    }//obtenir la nombre des resultats sur Bing 
		    card3.setLayout(new GridLayout(rows1, 1));
		    for (AzureSearchNewsResult newBing : BingSearchService.getNewsBing()) {	
		    	etiquette d1 = new etiquette(); 
				String str = "";
		    	str +=  newBing.getTitle()+"\n"+"\n";
			    str +=  newBing.getSource() + ", ";
			    str +=  newBing.getDate();
			    System.out.println(str);
			    JPanel resultatChaque = new JPanel();
			    resultatChaque.setLayout(new FlowLayout(FlowLayout.LEFT));
			    Component resultatlist = d1.renvoyerpanel();
//			    resultatlist.addMouseListener(mouseWeb);
			    resultatChaque.add(resultatlist);
			    card3.add(resultatChaque);
			    d1.contenu.append(str);
			    try {
					URI w = new URI(newBing.getUrl());
					d1.setURL(w);
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    rows2 += 1;
			    if(rows2 == 10){
			    	break;
			    }			    	
			    }    
		    System.out.println(rows2);
		    if(rows1 == 0){
		    	suggestion.setText("Aucun Bingnews correspondant.");
		    	suggestion.setHorizontalAlignment(JTextField.CENTER);
				card3.add(suggestion);		    	
		    }
    		}
 		}
       	}

	public windows(){
    	try {
			this.mylist=this.trends(mylist);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
            
    	    sujet.setBorder(BorderFactory.createTitledBorder(" Les trends du moment : "));
    
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
    	
    	    JPanel card2 = new JPanel();
    	    card2.setLayout(new BorderLayout());
    	    card2.add(text);
    	    
    	    JPanel card3 = new JPanel();
    	    card3.setLayout(new BorderLayout());
        	card3.add(connecte);
    	        	    
		    panel.setLayout(null);
		    
            panel.add(jl2);
            jl2.setBackground(Color.WHITE);
            jl2.setBounds(60, 20, 80, 20);
            panel.add(username);
            username.setBounds(140, 20, 150, 20);
            panel.add(jl3);
            jl3.setBackground(Color.WHITE);
            jl3.setBounds(320, 20, 100, 20);
            panel.add(password);
            password.setBounds(420, 20, 150, 20);
            panel.add(login);
            login.setBounds(620, 20, 110, 20);
            panel.add(inscrire);
            inscrire.setBounds(780, 20, 110, 20);

            
		    panel.add(card0);
		    card0.setBounds(40, 80, 230, 100);
		    panel.add(sujet);
		    sujet.setBounds(40, 200, 230, 210);
		    panel.add(actualise);
		    actualise.setBounds(40, 480, 110, 25);
            panel.add(card2);
            card2.setBounds(300, 80, 660, 30);
		    panel.add(card3);
		    card3.setBounds(160, 480, 110, 25);
		    panel.add(card3Scroll);
		    card3Scroll.setBounds(300, 120, 660, 470);
		
     	    sujet.addListSelectionListener(this);
	        sujet.addMouseListener(mouseListener);
            actualise.addActionListener(this);

            fenetre.setTitle("4F NEWS");
            fenetre.setSize(1000,660);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setVisible(true);
            fenetre.setLocationRelativeTo(null);
	    }
/*	public static void main(String[] args){
		windows n = new windows();
	}
*/
}