package cfarrell;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class BruteAutoComplete implements AutoComplete {

	//public Iterable<String> error;
	//public String fault = "Problem";
	

	public BruteAutoComplete() throws FileNotFoundException {
		if (Main.URL != null) {
			Main.loadFromFile();
		} else {
			Main.URL = "./wiki.txt"; // default to the built in file
		}
	}

	
		
	@Override
	public double weightOf(String term) throws NullPointerException {

		for (Term t : Main.allterms) {
			if (t.term.startsWith(term))
				return t.weight;
		}
		return 0;
	}

	@Override
	public String bestMatch(String prefix) throws NullPointerException {

//		if (prefix != null) {
			return matches(prefix, 1).iterator().next();
		//}
	//	return fault; // the String error is being used when the prefix is null

	}

	@Override
	public Iterable<String> matches(String prefix, int k) throws NullPointerException {
		ArrayList<String> filterTerms = new ArrayList<String>();
		for (Term t : Main.allterms) {
			if (t.getTerm().startsWith(prefix))
				filterTerms.add(t.getTerm());
		}
		Collections.sort(filterTerms);
		if (filterTerms.size() > k) {
			return filterTerms.subList(0, k);
		}
		return filterTerms;


	}

	public void setURL(String URL) {
		Main.URL = URL;
	}

}
