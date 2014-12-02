package lesfantastiques.lesfantastiques;

import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
/**
 * 
 * @author Adrien
 * @param void
 * 
 */
public class recevoirtrends {

	
	public recevoirtrends() {
		super();
	}
	/**
	 * 
	 * @return String tab
	 * @throws TwitterException
	 * va s'autentifier avec un compte d�velopper 
	 * et r�cuperer les trends
	 */
	public String[] prendretrends() throws TwitterException{
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("a84MufddmoRWDh78YnYbrWGFv")
    	  .setOAuthConsumerSecret("LmQQLpWIqlIsjGScOzZPnkREaVi941Wy9bGk7z84wzbgDX87gE")
    	  .setOAuthAccessToken("2839944004-bXR2jT0I6UsN6SM5Xku0qPPxQ5MfxdyeSHdRrR5")
    	  .setOAuthAccessTokenSecret("1KSoPqW04ueahEwPzVl8sqLTA2WbDCbVaApsNKfUPOCFk");
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
    	Trends montrend = twitter.getPlaceTrends(1);
    	Trend malistedetrend[] =montrend.getTrends();//transforme en un tableau de 10trends
    	String[] mastringlist= new String[10];/*le tableau de chaines de caract�res*/
    	
    	
    	for (int i=0;i<10;i=i+1){//on remplit le tableau de string
    		mastringlist[i]=malistedetrend[i].getName();
    	}
    	
    	return mastringlist;
    	
    }

}
