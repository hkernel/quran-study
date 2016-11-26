package academy.islam.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import academy.islam.quran.Aaya;
import academy.islam.quran.Quran;

/**
 * Reads the Quran from various input format:
 * - txt
 * - sql
 * - xml
 * - json
 * @author reuse
 *
 */
public class Qr1nReader {
	
	
	public static List<Aaya> readVerses(Quran quran) throws Exception{

		String fileName = "java/resources/QURAN.txt";
		Scanner scan = new Scanner(new FileInputStream(new File(fileName)));
		String line = null;
		List<String> lines = new ArrayList<String>();
		while(scan.hasNext()){
			line = scan.nextLine();
			if(line.startsWith("#")==false)
				lines.add(line);
			else
				System.out.println(line);
		}
		
		System.out.println("size is "+lines.size());
		//return lines;

		quran.buildFromLines(lines);
		////
		//filling the quran structure
		////

		
		System.out.println("\n\n finished proessing : "+quran.getVerses()+" verses");
		return quran.getVerses();
	}
	
	
	public static void readMetaData(Quran q) {
		String fileName = "java/resources/quran-data.xml";
		//read using jaxb?
		Properties pList = q.meta;
	}
	
	
}
