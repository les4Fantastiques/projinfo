package lesFantastiques.lesFantastiques;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import javax.swing.*;

public class etiquette {
	JTextArea contenu = new JTextArea(2,57);
    URI lien ;
	public etiquette(){
		
	}
	public void setURL(URI b){
		this.lien = b;
		
	}
	public URI getURL(){
		return this.lien;
	}
	public Component renvoyerpanel(){
	    JPanel d = new JPanel();
	    d.setLayout(new GridLayout(1,1));
	    contenu.setLineWrap(true);
	    contenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//w.setBorder(BorderFactory.createLineBorder(Color.RED));
				contenu.setBackground(Color.BLUE);
			    }
			@Override
			public void mouseExited(MouseEvent e) {
				//w.setBorder(null);
				contenu.setBackground(Color.WHITE);
				}
			public void mouseClicked(MouseEvent w){
				System.out.println("执行鼠标点击动作");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.browse(getURL());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 

			});
	    d.add(contenu);
	    final JPanel w = new JPanel();
	    w.add(d);
		w.setVisible(true);
		return w;
	}
	
}
