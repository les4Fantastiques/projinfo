package monprojinfo;

import twitter4j.TwitterException;

public class principal {

	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub
		/*recevoirtrends montrend= new recevoirtrends();
		String[] monactu=montrend.prendretrends();*/
		/*for(String i :monactu){
			System.out.println(i);
		}
		System.out.println(monactu.length);*/
		//smallWindows test=new smallWindows();
		//windows test1 = new windows();
		/*mediumWindows fen=new mediumWindows();
        fen.setTitle("Bing");
        fen.setSize(400,260);
        fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fen.pack();
        fen.setVisible(true);
        fen.setLocationRelativeTo(null); */ 
		windows test=new windows();
		BingSearchService bingSearchService = new BingSearchService();
		bingSearchService.search("adrien moleins");
		
	}

}
