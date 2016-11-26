package academy.islam;

import java.util.List;

import academy.islam.quran.Aaya;
import academy.islam.quran.Qr1nIndex;
import academy.islam.quran.Quran;
import academy.islam.tool.Qr1nReader;

public class Launcher {

	public static void main(String[] args) throws Exception{
		Quran q =  Quran.Service.read();
		
		//Quran.Service.printStructure(q);
		
	}
}
