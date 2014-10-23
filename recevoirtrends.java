package monprojinfo;

import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class recevoirtrends {

	
	public recevoirtrends() {
		super();
	}
	
	public String prendretrends() throws TwitterException{
		//public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("a84MufddmoRWDh78YnYbrWGFv")
    	  .setOAuthConsumerSecret("LmQQLpWIqlIsjGScOzZPnkREaVi941Wy9bGk7z84wzbgDX87gE")
    	  .setOAuthAccessToken("2839944004-bXR2jT0I6UsN6SM5Xku0qPPxQ5MfxdyeSHdRrR5")
    	  .setOAuthAccessTokenSecret("1KSoPqW04ueahEwPzVl8sqLTA2WbDCbVaApsNKfUPOCFk");
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
    	Trends montrend =  twitter.getPlaceTrends(1);//609125);
    	Trend malistedetrend[] =montrend.getTrends();
    	String tabareturn = "";
    	//int nb =0;
    	
    	for(Trend i :malistedetrend){
    	//System.out.println(i.getName());
    	tabareturn=tabareturn +i.getName()+" ";
    	}
    	
//    	ResponseList<Location> malocation = twitter.getAvailableTrends();
//    	ResponseList<Location> malocation = twitter.getAvailableTrends();
//    	 for (Location location : malocation) {
//             System.out.println(location.getName() + " (woeid:" + location.getWoeid() + ")");
//         }
    	//for (int i=0;i<10;i=i+1){
    		//System.out.println(malistedetrend[i].getName());
    		//tabareturn[i]=malistedetrend[i].getName();
    		//System.out.println(tabareturn[i]);
    	//}
    	
    	return tabareturn;
    	
    	}

}
