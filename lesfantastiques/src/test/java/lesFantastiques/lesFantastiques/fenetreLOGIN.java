package lesFantastiques.lesFantastiques;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
 
/**
 * la fenêtre pour LOGIN
 * 
 * @author YISHUO
 */
public class fenetreLOGIN implements ActionListener {
	JPanel jl0 = new JPanel();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JLabel jl1 = new JLabel();
    JLabel jl2 = new JLabel("USERNAME :");
    JLabel jl3 = new JLabel("PASSWORD :");
    JButton inscrire = new JButton("s'inscrire");
    JButton login = new JButton("LOGIN");

    public fenetreLOGIN() {
        
    }
 
    public Component init() {
        jl0.setLayout(null);       
        jl0.setSize(1000,100);
        jl0.setVisible(true);
        
        jl2.setBounds(20, 20, 80, 20);
        username = new JTextField();
        username.setBounds(100, 20, 150, 20);
        
        jl3.setBounds(300, 20, 80, 20);
        password = new JPasswordField();
        password.setBounds(380, 20, 150, 20);
        
        inscrire.setBounds(600, 70, 90, 20);
        inscrire.addActionListener(this);

        login.setBounds(600, 20, 90, 20);
        login.addActionListener(this);
     
        jl1.add(jl2);
        jl1.add(jl3);
        jl1.add(inscrire);
        jl1.add(login);
        jl0.add(jl1);
        jl0.add(username);
        jl0.add(password);
        return jl0;
    }
    
    public void actionPerformed(ActionEvent f) {
/*    	if(f.getSource() == this.login){
    		try {
				@SuppressWarnings("unused")
				testInternet test = new testInternet();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				fenetreLOGIN.dispose();
			}	
    	}
    	if(f.getSource() == this.inscrire){
    		//ajouter l'action du button d'inscrire
    	}
  */
    }
 
/*  public static void main(String[] args) {
        fenetreLOGIN lesfantastiques = new fenetreLOGIN();
    }
 */
}