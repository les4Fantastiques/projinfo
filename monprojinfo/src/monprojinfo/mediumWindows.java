package monprojinfo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import twitter4j.TwitterException;
import monprojinfo.smallWindows;
 
public class mediumWindows extends JFrame implements ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
    //changer le nom de button aux sujets tendances. 
    JTextField a1 = new JTextField("ACTUALITE");
    JTextField a2 = new JTextField("ECONOMIE");
    JTextField a3 = new JTextField("MILITAIRE");
    JTextField a4 = new JTextField("SPORT");
    JTextField a5 = new JTextField("TECHNIQUE");
    JTextField a6 = new JTextField("CULTURE");
    JTextField a7 = new JTextField("LIFESTYLE");
    JTextField a8 = new JTextField("MADAME");
    JButton actualise = new JButton("ACTUALISER");
    JButton ferme = new JButton("FERMER");
 
    public mediumWindows(){
    	JFrame fenetre = new JFrame();
    	Container pane = fenetre.getContentPane();
    	
    	JPanel card1 = new JPanel();
    	card1.setLayout(new FlowLayout());
    	card1.add(actualise);
    	card1.add(ferme);
		
		pane.setLayout(new GridLayout(10,1));
		pane.add(a1);
		pane.add(a2);
		pane.add(a3);
		pane.add(a4);
		pane.add(a5);
		pane.add(a6);
		pane.add(a7);
		pane.add(a8);
		pane.add(card1);
        this.add(pane);
        a1.addActionListener(this);
        a2.addActionListener(this);
        a3.addActionListener(this);
        a4.addActionListener(this);
        a5.addActionListener(this);
        a6.addActionListener(this);
        a7.addActionListener(this);
        a8.addActionListener(this);
        actualise.addActionListener(this);
        ferme.addActionListener(this);
        //ajouter le action de plus de buttons
    }

	/*public static void main(String[] args) {
        mediumWindows fen=new mediumWindows();
        fen.setTitle("Bing");
        fen.setSize(400,260);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.pack();
        fen.setVisible(true);
        fen.setLocationRelativeTo(null);  
    }*/
    @Override
    public void actionPerformed(ActionEvent a) {
    	@SuppressWarnings("unused")
		int aretourner=-1;
    	if(a.getSource() == this.a1){
    		smallWindows windows1 = new smallWindows();	
    		windows1.pack();
			windows1.setVisible(true);	
    	}
    	if(a.getSource() == this.a2){
    		smallWindows windows2 = new smallWindows();	
    		windows2.pack();
			windows2.setVisible(true);	
    	}
    	if(a.getSource() == this.a3){
    		smallWindows windows3 = new smallWindows();	
    		windows3.pack();
			windows3.setVisible(true);	
    	}
    	if(a.getSource() == this.a4){
    		smallWindows windows4 = new smallWindows();
    		windows4.pack();
			windows4.setVisible(true);	
    	}
    	if(a.getSource() == this.a5){
    		smallWindows windows5 = new smallWindows();	
    		windows5.pack();
			windows5.setVisible(true);	
    	}
    	if(a.getSource() == this.a6){
    		smallWindows windows6 = new smallWindows();	
    		windows6.pack();
			windows6.setVisible(true);	
    	}
    	if(a.getSource() == this.a7){
    		smallWindows windows7 = new smallWindows();	
    		windows7.pack();
			windows7.setVisible(true);	
    	}
    	if(a.getSource() == this.a8){
    		smallWindows windows8 = new smallWindows();
    		windows8.pack();
			windows8.setVisible(true);
			this.dispose();
    	}
    	if(a.getSource() == this.actualise){
    		//ajouter une action d'actualise
    		this.dispose();
    		try {
				windows test=new windows();
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	if(a.getSource() == this.ferme){
    		this.dispose();
    	}   
    	//return aretourner;
       
    }
}