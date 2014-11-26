package lesFantastiques.lesFantastiques;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

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

	JFrame fenetre = new JFrame();
	JLabel image=new JLabel(new ImageIcon("img.jpg"));
	JTextField text = new JTextField(660);
	JTextArea area = new JTextArea(660,470);
    Container panel = fenetre.getContentPane();
    JButton actualise = new JButton("ACTUALISER");
    
	String[] mylist= new String[10];
//	String[] resultats = new String[100];
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
            	text.setText("les resultats sur Bing pour la titre : "+titre);
            	text.setHorizontalAlignment(JTextField.CENTER);
            	text.setBackground(Color.CYAN);
            	}      	
        }
    };
 
    public void valueChanged(ListSelectionEvent e) {
/*    	if (e.getValueIsAdjusting()==true) {
    		Object sousou = sujet.getSelectedValue();
     		BingSearchService.rechercheNewsBing(sousou);
			for (AzureSearchNewsResult newBing : BingSearchService.getNewsBing()) {
//				tweet tweet_bing= new tweet();
				String str = "";
				str += "Titre : " + newBing.getTitle();
//				tweet_bing.settextarea_titre(newBing.getTitle());
				str += " - Source : " + newBing.getSource();
//			    tweet_bing.setlabel_source(newBing.getSource());
				str += " - Date : " + newBing.getDate();
//				tweet_bing.setlabel_temps(newBing.getDate());
				str += " - Description : " + newBing.getDescription();
//				tweet_bing.settextarea_description(newBing.getDescription());
				str += " - Url : " + newBing.getUrl();
//	    	    area.setText(str);
				System.out.println(str);

			}
		}*/
		}

    @SuppressWarnings("rawtypes")
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
    	
    	    JPanel card1 = new JPanel();
    	    card1.setLayout(new FlowLayout());
    	    card1.add(actualise);

    	    JPanel card2 = new JPanel();
    	    card2.setLayout(new FlowLayout());
    	    card2.add(text);
    	    
    	    JPanel card3 = new JPanel();
    	    card3.setLayout(new GridLayout(10,1));
//    	    JScrollPane card3scroll=new JScrollPane(card3);
//    	    card3scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            area.setLineWrap(true);
//    	    for(int i=0;i<10;i++){
//    	    	etiquette w = new etiquette();
//    	    	card3scroll.add(w.w);
//    	    }
    	    
    	    
		    panel.setLayout(null);
		    panel.add(card0);
		    card0.setBounds(40, 20, 230, 100);
		    panel.add(sujet);
		    sujet.setBounds(40, 140, 230, 230);
		    panel.add(card1);
		    card1.setBounds(100, 390, 110, 35);
            panel.add(card2);
            card2.setBounds(300, 20, 660, 30);
		    panel.add(card3);
		    card3.setBounds(300, 60, 660, 470);
		
     	    sujet.addListSelectionListener(this);
	        sujet.addMouseListener(mouseListener);
            actualise.addActionListener(this);

            fenetre.setTitle("4F NEWS");
            fenetre.setSize(1000,600);
            fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenetre.setVisible(true);
            fenetre.setLocationRelativeTo(null);
	    }

	public static void main(String[] args){
		windows n = new windows();
	}

}