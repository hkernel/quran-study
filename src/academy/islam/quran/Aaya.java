package academy.islam.quran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aaya {

	public Qr1nLoci p = new Qr1nLoci() ;
	public String line;
	List<String> words = new ArrayList<String>();
	
	public Aaya(String verse, Integer ivs) {
		line = verse;
		p.idVerse = ivs;

		String[] parts = line.split("\\s");
		Collections.addAll(words, parts);
	}
	
	public Aaya(String verse, Integer ivs, Integer ich) {
		this(verse, ivs);
		p.idChapter = ich;
	}
 
	
}
