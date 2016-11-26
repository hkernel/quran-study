package academy.islam.quran;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import academy.islam.tool.Qr1nReader;

public class Quran {
	
	List<Aaya> verses = new ArrayList<Aaya>();
	Map<Integer, List<Aaya>> map = new HashMap<Integer, List<Aaya>>();
	
	public Properties meta = new Properties();
	//properties
	public String sizeV = "";
	public String sizeC = "";
	
	public Qr1nIndex index = new Qr1nIndex(null);
	
	
	
	public void buildFromLines(List<String> lines){
		List<Aaya> local = new ArrayList<Aaya>();
		int cch = 1; //chapter counter starts with chapter 1
		for(String phrase : lines){
			System.out.println("processing..."+phrase);
			String[] parts = phrase.split(":");
			Integer ich = Integer.parseInt(parts[0]);
			Integer ivs = Integer.parseInt(parts[1]);
			String verse = parts[2];
			if(cch!=ich){ //new chapter
				map.put(cch, local);	//put previous
				cch++; //or ich
				local = new ArrayList<Aaya>();
			}
			verses.add(new Aaya(verse, ivs, ich));
			local.add(new Aaya(verse, ivs, ich));
		}
		
	}
	public Map<Integer, List<Aaya>> getMap(){
		return map;
	}

	public List<Aaya> getVerses() {
		return verses;
	}
	
	public void buildIndex() {
		index.build(this);
	}


	public void printStats(){

		System.out.println("chapter size is : "+map.keySet().size()+" chapters");
		System.out.println("verse size is : "+verses.size()+" verses");
		System.out.println("index size is : "+index.words.size()+" words");
	}

	/* ************************************************************************* */
	/***********************************		SERVICE LAYER ********************/
	/* ************************************************************************* */
	public static class Service{
		
		public static Quran read() throws Exception{
			Quran q = new Quran();
			Qr1nReader.readVerses(q);
			Qr1nReader.readMetaData(q);
			q.buildIndex();
			q.printStats();
			return q;
		}
		
		public static void printAsList(Quran q){
			
		}

		public static void printIndex(Quran q){
			System.out.println("printing workds\n");
			for(String word : q.index.words)
				System.out.println(word);
		}

		public static void printStructure(Quran q) {
			//printing the structure
			////
			for(int i = 110; i<114; i++){
				List<Aaya> vList = q.getMap().get(i);
				System.out.println("Chapter "+i+" , verses: "+vList.size());
				for(Aaya v : vList){
					System.out.println(v.p.IdVerse+" : "+v.line);
				}
			
			}
		
		}
	}


}
