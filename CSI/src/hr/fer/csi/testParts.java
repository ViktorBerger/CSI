
/*

Parts that can be made different

public static String readTextFile(InputStream inputStream) {
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(
					inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuilder stringBuilder = new StringBuilder();
			
			String oneLine = bufferedReader.readLine();
			while (oneLine != null) {
				stringBuilder.append(oneLine + "\n");
				oneLine = bufferedReader.readLine();
			}
			bufferedReader.close();
			return stringBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(inputStream);
			System.err.println(e);
			return "";
		}
	}





public static String readTextFile(InputStream inputStream) {
	try {
		char cbuf[] = new char[1000];
		
		InputStreamReader inputStreamReader = new InputStreamReader(
				inputStream);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader, 8192);
		StringBuilder stringBuilder = new StringBuilder();

		while (bufferedReader.read(cbuf) != -1) {
			stringBuilder.append(cbuf);
			cbuf = new char[1000];
		}
		bufferedReader.close();
		return stringBuilder.toString();
	} catch (Exception e) {
		e.printStackTrace();
		System.err.println(inputStream);
		System.err.println(e);
		return "";
	}
}




*******************Dio za uniju koji se moze na dva nacina*****************
// racuna presjek dva vektora
	public int intersect(Vector<KGram> v1, Vector<KGram> v2){

		@SuppressWarnings("unchecked")
		Vector<KGram> tmp = (Vector<KGram>) v1.clone();
		int brojac = 0;

		
		for(KGram kg : v2){
			if(tmp.remove(kg))
				brojac++;
		}
		System.out.println("intersect: " + brojac);
		return brojac;
	}
	
	//racuna uniju dva vektora --- ovaj nacin jer drugacije nisam znao ili ne moze efikasnije
	public int union(Vector<KGram> v1, Vector<KGram> v2) {
		
		@SuppressWarnings("unchecked")
		Vector<KGram> tmp = (Vector<KGram>) v1.clone();
		int brojac = v2.size();
		
		System.out.println("PocetnoUnija: " + tmp.size());

		for(KGram kg : v2){
			tmp.remove(kg);	
		}
		brojac += tmp.size();
		System.out.println("unija: " + brojac);
        return brojac;
    }
    
    ************************* i intersect je inznad ************************************

//opet dio za intersect
 * 	public int intersect(Vector<KGram> v1, Vector<KGram> v2){
		

		
		@SuppressWarnings("unchecked")
		Vector<KGram> tmp = (Vector<KGram>) v1.clone();
		long begin, end;
		
		begin = System.nanoTime();
		tmp.retainAll(v2);
		
		end = System.nanoTime();
		System.out.println(end - begin);
		
		return tmp.size();
	}
 */



