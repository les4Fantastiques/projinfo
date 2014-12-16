package lesFantastiques.lesFantastiques;

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
		aq.setQuery(search);
		aq.doQuery();
		newsBing = aq.getQueryResult();
	}

	public static AzureSearchResultSet<AzureSearchNewsResult> getNewsBing() {
		return newsBing;
	}

	public void setNewsBing(AzureSearchResultSet<AzureSearchNewsResult> newsBing) {
		this.newsBing = newsBing;
	}
/*	public static void main(String[] args){
		BingSearchService aaa = new BingSearchService();
	    aaa.rechercheNewsBing("niha");
		int i = 0;		
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
			i += 1;
			if(i == 4){
				break;
			}
		}
		if(i==0){
			System.out.println("meiyou");
		}
		
		
	}
*/
}

