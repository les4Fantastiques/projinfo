package monprojinfo;


import java.util.ArrayList;
import java.util.Iterator;

import net.billylieurance.azuresearch.AbstractAzureSearchQuery.AZURESEARCH_FORMAT;
import net.billylieurance.azuresearch.AzureSearchResultSet;
import net.billylieurance.azuresearch.AzureSearchWebQuery;
import net.billylieurance.azuresearch.AzureSearchWebResult;

public class BingSearchService {
	/**
	 * @author Adrien
	 * @param sujet de la recherche
	 * @return ArrayList<String[]> tableau de tableaux contenant titre,url, displayurl et description
	 */
	// Update your Account ID - https://datamarket.azure.com/account.
	private static final String ACCOUNT_KEY = "XXMMDkj1V6lkgwusChQmhxFAeIKVrY+k9d1TQcP3L/U";

	public ArrayList<String[]> search(String searchParam) {
		String[] retour = new String[4];
		ArrayList<String[]> tata = new ArrayList<String[]>();
		AzureSearchWebQuery aq = new AzureSearchWebQuery();

		aq.setAppid(ACCOUNT_KEY);

		aq.setFormat(AZURESEARCH_FORMAT.XML);

		// searchParam is the field containing the keyword to be searched.
		aq.setQuery(searchParam);

		aq.doQuery();

		AzureSearchResultSet<AzureSearchWebResult> azureSearchResultSet = aq
				.getQueryResult();
		
		
		
		for (Iterator<AzureSearchWebResult> iterator = azureSearchResultSet
				.iterator(); iterator.hasNext();) {
			AzureSearchWebResult result = (AzureSearchWebResult) iterator
					.next();

			// Populate the data from result object in to your custom objects.

			System.out.println(result.getTitle());
			//System.out.println(result.getUrl());
			//System.out.println(result.getDisplayUrl());
			//System.out.println(result.getDescription());
			retour[0] = result.getTitle();
			retour[1] = result.getUrl();
			retour[2] = result.getDisplayUrl();
			retour[3] = result.getDescription();
			tata.add(retour);
			//System.out.println(tata.size());
			
			
		}
		for(int i = 0;i<tata.size();i++){
			for(int j = 0;j<tata.get(i).length;j++){
				System.out.println(tata.get(i)[j]);
			}
		}
		/*for (String[] j : tata){
			for (String i : j){
				//System.out.println(i);
				System.out.println(i);
			}
			System.out.println(tata.size());
		}*/
		
		return tata;
	}

	public static void main(String[] args) {
		BingSearchService bingSearchService = new BingSearchService();
		bingSearchService.search("adrien moleins");
	}

}
