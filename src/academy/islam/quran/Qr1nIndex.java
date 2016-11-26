package academy.islam.quran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Probably lucene index
 * 
 * @author reuse
 *
 */
public class Qr1nIndex {

	public List<String> words = new ArrayList<String>();
	List<Qr1nLoci> locations = new ArrayList<Qr1nLoci>();
	Map<String, List<Qr1nLoci>> index = new HashMap<String, List<Qr1nLoci>>();
	
	//@INJECTION
	private Quran quran_;
	
	public Qr1nIndex(Quran quran){
		this.quran_ = quran;
	}
	public void build(){
		System.out.println("Building index....");
		//for each verse, pick up the words
		for(Aaya v : quran_.getVerses()){
			map(v.words);
			words.addAll(v.words);
		}
	}
	private void map(String input, Aaya v){
		List<Qr1nLoci> locis = index.get(input);		//try to find me
		Qr1nLoci loci = new Qr1nLoci(v);
		if(locis == null){
			locis = new ArrayList<Qr1nLoci>();
			locis.add(loci);
		}
	}
	public void build(Quran quran) {
		quran_ = quran;
		build();
	}

}
