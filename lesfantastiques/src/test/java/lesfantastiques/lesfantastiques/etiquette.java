package lesfantastiques.lesfantastiques;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;



public class etiquette {
	JTextArea contenu = new JTextArea();
	public etiquette(){
		
	}
	
//	public void renvoyerpanel(){
	public Component renvoyerpanel(){
	    JPanel d = new JPanel();
	    d.setSize(660, 70);
	    d.setLayout(new GridLayout(1,1));
//	    contenu.setLineWrap(true);
	    d.add(contenu);
		JPanel w = new JPanel();
		w.add(d);
		w.setSize(660, 70);
		w.setVisible(true);
		return w;
	}

}