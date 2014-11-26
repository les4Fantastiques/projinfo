package lesFantastiques.lesFantastiques;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class etiquette {
	public JPanel w ;

	JTextArea description = new JTextArea(660,100);
	JButton entre = new JButton();
	JButton sauvregarde = new JButton();
	
	
	public void actionPerformed(ActionEvent c) {
    	if(c.getSource() == this.entre){
    		//l'action de la fenentre     		    		
    	}	  
    	if(c.getSource() == this.sauvregarde){
    		//l'action de la fenetre
    	}
    }
	
	public JPanel etiquette(){		
		JPanel d = new JPanel();
		d.setLayout(new GridLayout(1,1));
		d.add(description);		
		JPanel b = new JPanel();
		b.setLayout(new GridLayout(1,2));
		b.add(entre);
		b.add(sauvregarde);
//		entre.addActionListener(this);
//		sauvregarde.addActionListener(this);
		
		JPanel w = new JPanel(); 
		w.add(d);
		d.setBounds(0, 2, 660, 100);
		w.add(b);
		b.setBounds(0, 102, 660, 30);		
		return w;
	}
}
