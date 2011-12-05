package hr.fer.csi;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
	private List<WinnowingKGram> allWinnowing = new ArrayList<WinnowingKGram>();
	private List<FileCharacteristics> allFiles = new ArrayList<FileCharacteristics>();

public void doAll(){

	UnzipFile unzipFile = new UnzipFile();
	
	// putanja do zip file potrebno staljati "\\" dvostruke backslasheve
	allFiles = unzipFile.getListOfFileCharacteristics("c:\\nesto.zip");
	
	for(FileCharacteristics fc : allFiles){
		fc.doAll();
		allWinnowing.add(new WinnowingKGram(fc.getSourceCodeFN(), 6, 5));
	}
	
	double slic = 0;
	
	for(int i = 0; i < allWinnowing.size(); i++){
		for(int j = i+1; j < allWinnowing.size(); j++){
			
			slic = allWinnowing.get(i).calculateSimilarity(allWinnowing.get(j).getWinnowingSet());

			if( slic > 0.80 ){
				
				System.out.printf("%s ****** %s = %f\n", 
						allFiles.get(i).getFileName(),
						allFiles.get(j).getFileName(),
						slic
						);
			}
		}
	}

}

public static void main(String args[]){
	MainClass test = new MainClass();
	long begin, end;
	
	begin = System.nanoTime();
	test.doAll();
	end = System.nanoTime();
	System.out.println(end - begin);
}

}
