package lesfantastiques.lesfantastiques;


import net.billylieurance.azuresearch.AzureSearchNewsQuery;
import net.billylieurance.azuresearch.AzureSearchNewsResult;
import net.billylieurance.azuresearch.AzureSearchResultSet;
/**
 * récupérer les résultats de cherche sur Bing
 * 
 * @author YISHUO & Adrien
 */


public class BingSearchService {
	private static final String Api_Key = "XXMMDkj1V6lkgwusChQmhxFAeIKVrY+k9d1TQcP3L/U";
	static AzureSearchNewsQuery aq = new AzureSearchNewsQuery();
	static AzureSearchResultSet<AzureSearchNewsResult> newsBing;

	public BingSearchService() {
		aq.setAppid(Api_Key);
		aq.setMarket("fr-fr");
	}

	public void rechercheNewsBing(String search) {
		//aq.setAppid(Api_Key);
		aq.setQuery(this.replaceString(search));
		aq.doQuery();
		newsBing = aq.getQueryResult();
	}

	public static AzureSearchResultSet<AzureSearchNewsResult> getNewsBing() {
		return newsBing;
	}

	public void setNewsBing(AzureSearchResultSet<AzureSearchNewsResult> newsBing) {
		BingSearchService.newsBing = newsBing;
	}
	public  String replaceString(String monstring){
		
		monstring = monstring.replaceAll("Ã©", "e");
		monstring = monstring.replaceAll("Ã¨","e");
		monstring = monstring.replaceAll("â€™","'");
		monstring = monstring.replaceAll("ÃŽ","Î");
		monstring = monstring.replaceAll("Ã¢","â");
		monstring = monstring.replaceAll("â€“","-");
		monstring = monstring.replaceAll("Ã§", "ç");
		monstring = monstring.replaceAll("Ã","a");
		monstring = monstring.replaceAll("a¹", "ù");
		monstring = monstring.replaceAll("a¯","ï");
		monstring = monstring.replaceAll("a®","î");
		monstring = monstring.replaceAll("aª","ê");
		monstring = monstring.replaceAll("a‰", "É");
    	monstring = monstring.replaceAll("Å“", "œ");
    	monstring = monstring.replaceAll("#","");
    	monstring = monstring.replaceAll("'", " ");

    	
    	
		return monstring;
	}
/*	public static void main(String[] args){
		BingSearchService aaa = new BingSearchService();
		aaa.rechercheNewsBing("nabila");
		for (AzureSearchNewsResult newBing : BingSearchService.getNewsBing()) {
//			tweet tweet_bing= new tweet();
			String str = "";
			str += "Titre : " + newBing.getTitle();
//			tweet_bing.settextarea_titre(newBing.getTitle());
			str += " - Source : " + newBing.getSource();
//		    tweet_bing.setlabel_source(newBing.getSource());
			str += " - Date : " + newBing.getDate();
//			tweet_bing.setlabel_temps(newBing.getDate());
			str += " - Description : " + newBing.getDescription();
//			tweet_bing.settextarea_description(newBing.getDescription());
			str += " - Url : " + newBing.getUrl();
//    	    area.setText(str);
			System.out.println(str);
		}
	}*/
}

