package hr.fer.csi;

public class KGram {
	private String KGram;
	private int hash;
	private int position;
	
	public KGram(String kg, int position){
		setKGram(kg);
		setHash();
		setPosition( position );
		
	}
	
	private void setPosition(int i){
		position = i;
	}

	public int getPosition(){
		return position;
	}
	
	private void setKGram(String kg){
		KGram = kg;
	}
	
	private void setHash(){
		hash = KGram.hashCode();
	}
	
	public String getKGram(){
		return KGram;
	}
	
	public int getHash(){
		return hash;
	}
	
	public String getKGramString(){
		return KGram;
	}
	
	// Koristi se jer je potrebno za racunanje presjeka, to je funkcija koja se koristi
	// da se provjeri istovjetnosti klasa
	public int hashCode(){
		return hash;
	}
	
	// String reprezentacija objekta je hash code, String se moze dobit preko getKGramString
	public String toString(){
		return String.format("%d", hash);
	}
	
	//TKoristi za usporedbu jesu li dva objekta jednaka
	public boolean equals(Object obj){
		if(obj == null) 
			return false;
		KGram other = (KGram)obj;
		
		if(this.hash == other.hash)
			return true;
		else
			return false;
	}
	
	
}
