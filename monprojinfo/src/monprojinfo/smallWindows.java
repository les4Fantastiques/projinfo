package monprojinfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class smallWindows extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
    JTextArea area = new JTextArea("hello, every one!",50,40);
    JButton sauvegarde = new JButton("SAUVEGARDER");
    JButton ferme = new JButton("FERMER");
	JLabel image=new JLabel(new ImageIcon("img.jpg"));

    public smallWindows(){
    	JFrame fenetre = new JFrame();
    	Container pane = fenetre.getContentPane();

	
 	    JPanel card0 = new JPanel();
 	    card0.add(image);
 	    
    	JPanel card1 = new JPanel();
    	card1.add(area);
    	
    	JPanel card2 = new JPanel();
    	card2.setLayout(new FlowLayout());
		card2.add(sauvegarde);
		card2.add(ferme);
		
		pane.setLayout(new GridLayout(3,1));
		pane.add(card0);
		pane.add(card1);
		pane.add(card2);
        this.add(pane);
        sauvegarde.addActionListener(this);
        ferme.addActionListener(this);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
        fenetre.pack();
        fenetre.setVisible(true);
    }
    
	public static void main(String[] args) {
		smallWindows test=new smallWindows();
        test.setSize(400,300);
        test.setLocationRelativeTo(null);
        
    }
    @Override
    public void actionPerformed(ActionEvent a){
		if (a.getSource() == this.sauvegarde){
			//ajouter une action	
		}
		
		if (a.getSource() == this.ferme){
			this.dispose();
		}
    }	

}
