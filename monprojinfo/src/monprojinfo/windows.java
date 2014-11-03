package monprojinfo;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import monprojinfo.mediumWindows;
import twitter4j.TwitterException;
	/**
	 * 
	 * @author yishuo
	 * 
	 *
	 */
public class windows implements ActionListener, ListSelectionListener{ 
	/**
	 * initialisation de la fenetre
	 */
	JFrame fenetre = new JFrame();
	JLabel bienvenue = new JLabel("bienvenue a tous!");
    Container panel = fenetre.getContentPane();
    
    JButton actualiser = new JButton("ACTUALISER");
    JButton fermer = new JButton("FERMER");
    
	//String[] mylist= new String[10];
	/**
	 * 
	 * @return tableau des trends
	 * @throws TwitterException
	 * @author Adrien
	 * appelle la classe recevoirtrends et sa méthode prendretrends
	 */
	public String[] gettrends() throws TwitterException{
		recevoirtrends montrend = new recevoirtrends();
		String[] mylist=montrend.prendretrends();
	    return mylist;
	}
	
	/**
	 * @author Yishuo
	 * fait une action lorsque l'utilisateur appuie sur un bouton
	 */
	public void actionPerformed(ActionEvent a) {
    	if(a.getSource() == this.actualiser){
    		//ajouter une action d'actualise
    		fenetre.dispose();
    		try {
				this.giveresult();
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(a.getSource() == this.fermer){
    		System.exit(0);
    	}   	  
    }
	
	
	/**
	 * @author Yishuo
	 * ajoute une action lorsque l'utilisateur appuie sur une tendance
	 */
    MouseListener mouseListener = new MouseAdapter() {
        public void mouseClicked(MouseEvent mouseEvent) {
            JList<?> list = (JList<?>) mouseEvent.getSource();
			List<?> selectedvalues = list.getSelectedValuesList();
            //System.out.println(selectedvalues.size());
			System.out.println(selectedvalues);
			
            mediumWindows windows1 = new mediumWindows();	
            windows1.pack();
        	windows1.setVisible(true);	
            
        }
    };
    /**
     * @author Yishuo
     * 
     */
    public void valueChanged(ListSelectionEvent e) {
    	
    }
    /**
     * constructeur
     * @param void
     * @throws TwitterException
     * appelle la méthode de création de l'interface
     */
	public windows() throws TwitterException{
		this.giveresult();
	}
	/**
	 * 
	 * @throws TwitterException
	 * crée l'interface principale et affiche les tendances
	 */
	private void giveresult() throws TwitterException{
    	
		//récupération des tendances dans une JList + ajout d'un titre à cette liste
    	JList<String> sujet = new JList<String>(this.gettrends());
    	sujet.setBorder(BorderFactory.createTitledBorder("Les sujets tendance aujourd'hui : "));
    	
    	//ajout de l'image de fond de la fenetre
    	fenetre.setContentPane(panel); 
    	ImageIcon background = new ImageIcon("background.jpg");//charge l'image
        JLabel imgLabel = new JLabel(background);//mettre l'image du fond dans le label 
        imgLabel.setSize(fenetre.getWidth(), fenetre.getHeight());//definition de la taille de l'image
        imgLabel.setBounds(0,0,background.getIconWidth(), background.getIconHeight());
        panel = (JPanel) fenetre.getContentPane();
		((JComponent) panel).setOpaque(false);
		fenetre.getLayeredPane().setLayout(null);
    	fenetre.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		
    	// programmation du style du titre "Bienvenue à tous"
    	JPanel card0 = new JPanel();
    	card0.setLayout(new BorderLayout());
    	card0.add(bienvenue,BorderLayout.CENTER);
    	bienvenue.setHorizontalAlignment(SwingConstants.CENTER);
    	bienvenue.setFont(new Font("NEW ROMAIN",Font.BOLD,28));
    	
    	//ajout des boutons actualiser et fermer
    	JPanel card1 = new JPanel();
    	card1.setLayout(new FlowLayout());
    	card1.add(actualiser);
    	card1.add(fermer);
    	
    	//définition des placements de chaque JPanel
		panel.setLayout(null);
		panel.add(card0);
		card0.setBounds(40, 20, 260, 30);
		panel.add(sujet);
		sujet.setBounds(70, 50, 200, 230);
		panel.add(card1);
		card1.setBounds(70, 280, 200, 30);
		
		//ajout des actions.
	    //sujet.addListSelectionListener(this);
	    sujet.addMouseListener(mouseListener);
        actualiser.addActionListener(this);
        fermer.addActionListener(this);
        
        //création du style de la fenetre
        fenetre.setTitle("MY INFORMATION");
        fenetre.setSize(360,370);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //fenetre.pack();
        fenetre.setVisible(true);
        fenetre.setLocationRelativeTo(null); 

    }


}