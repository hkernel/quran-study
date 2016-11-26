package academy.islam.quran;

public class Qr1nLoci {

	public Qr1nLoci(){
		
	}
	public Qr1nLoci(Aaya v, String word) {
		idChapter = v.p.idChapter;
		idVerse = 0;
	}
	public Integer idChapter 	= -1;
	public Integer idVerse 		= -1;
	public Integer idWord 		= -1;
	public Integer letterV 		= -1;	//arrayIdV
	public Integer letterW 		= -1;	//arrayIdW
}	
