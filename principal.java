package monprojinfo;

import twitter4j.TwitterException;

public class principal {

	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub
		recevoirtrends montrend= new recevoirtrends();
		String[] monactu=montrend.prendretrends().split(" ");
		for(String i :monactu){
			System.out.println(i);
		}
		
	}

}
