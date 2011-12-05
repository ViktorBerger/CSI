package hr.fer.csi;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class WinnowingKGram {
	private Vector<KGram> KGrams;
	private int numberOfKGrams;
	private Vector<KGram> winnowingKGrams;
	private Set<KGram> winnowingKGramsSet;
	
	public WinnowingKGram(String sourceCode, int windowSize, int KGramLength){
		numberOfKGrams = 0;
		KGrams = new Vector<KGram>(1200, 500);
		winnowingKGrams = new Vector<KGram>(400, 100);
		
		calculateWinnowingKGrams(sourceCode, windowSize, KGramLength);
	}
	
	// Racuna winnowing kgrame, prica sourceCode ne bitno kakav, duzinu prozara i duzinu KGrama
	public void calculateWinnowingKGrams(String sourceCode, int windowSize, int KGramLength){
		//Prvo potrebno izracunati KGrame, index oznacava do kud se doslo u vektoru kgrama
		//a min, najmanji kgram u jednom prozoru !!!Pogledati algoritam za winnowing!!!
		calculateKGrams(sourceCode, KGramLength);
		int index = 1;
		int brojac = 0;
		KGram tmp;
		KGram min =  getMinKGramFromWindow(0, windowSize);
		winnowingKGrams.add(min);
		
		// Velicina prozora, koliko KGrama se usporedjuje od jednom i uzima najmanji od njih
		// Pogledati algoritam za winnowing da bi se ovo moglo shvatiti... Odnosno mrsko mi pisati, kasnije cu
		while(index + windowSize <= numberOfKGrams){
			brojac++;
			tmp = getMinKGramFromWindow(index, windowSize);
			if(tmp.getHash() < min.getHash() && tmp.getPosition() != min.getPosition()){
				brojac = 0;
				winnowingKGrams.add(tmp);
				min = tmp;
			}
			else if(brojac >= windowSize){
				brojac = 0;
				winnowingKGrams.add(tmp);
				min = tmp;
			}
			index++;
		}
		//Koristi se i set zbog brzine usporedbe
		winnowingKGramsSet = new HashSet<KGram>(winnowingKGrams);
	}
	
	private KGram getMinKGramFromWindow(int index, int windowSize){
		KGram min = KGrams.get(index);
		KGram k;
		for(int i = index+1; i < index+windowSize; i++){
			k = KGrams.get(i);
			if( k.getHash() < min.getHash())
				min = k;
		}
		
		return min;
	}
	
	//Racuna KGrame i sprema ih u Vektor klasa Kgrama (vektor zbog brzine dodavanja, puno KGrama ce biti)
	//takodjer postavalja broj kgrama
	private void calculateKGrams(String sourceCode, int KGramLength){
		int size = sourceCode.length();
		
		for(int index = 0; index + KGramLength < size; index++){
			KGrams.add( new KGram(sourceCode.substring(index, index + KGramLength), index) );
		}
		numberOfKGrams = KGrams.size();
	}
	
	
	// Racuna slicnost, prima vektor winnowing kgrama
	//Nacin racunanja je dobij preskej dva vektora pa njihovu uniju i podijeli presjek/unija
	public double calculateSimilarity( Set<KGram> other){
		int union, intersect;
		long begin, end;
		
		begin = System.nanoTime();
		
		intersect = intersect(winnowingKGrams, other);
		union = union(winnowingKGrams, other);
		end = System.nanoTime();
		//System.out.print("****");
		//System.out.println(end - begin);
		return (double)intersect/union;
		
	}
	
	// racuna presjek dva vektora Spora funkcija, skontati nacin kako ubrzati
	public int intersect(Vector<KGram> v1, Set<KGram> set){
		
		@SuppressWarnings("unchecked")
		Vector<KGram> tmpSet1 =(Vector<KGram>) v1.clone();
	
		tmpSet1.retainAll(set);
		return tmpSet1.size();
	}
	
	//racuna uniju dva vektora --- ovaj nacin jer drugacije nisam znao ili ne moze efikasni
	public int union(Vector<KGram> v1, Set<KGram> set) {
		
		@SuppressWarnings("unchecked")
		Vector<KGram> tmp = (Vector<KGram>) v1.clone();
		
		for(KGram kg : set){
			if(!tmp.contains(kg))
				tmp.add(kg);
		}
		
        return tmp.size();
    }
	
	// Vrati vektor winnowing kgrama, koristeno prilikom izracuna slicnosti
	public Vector<KGram> getWinnowingVector(){
		return winnowingKGrams;
	}
	public Set<KGram> getWinnowingSet(){
		return winnowingKGramsSet;
	}

}
