package hr.fer.csi;

import java.io.*;
import java.sql.Date;
import java.security.MessageDigest;

public class Test {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		String s = "";
		
		try {
			File f = new File("datoteke/test.txt");
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String tmp;
			while((tmp = reader.readLine()) != null) {
			s+= tmp;
			s+="\n";
			}
			
			//Date datum = new Date(0,0,1);
			//FileCharacteristics novi = new FileCharacteristics(s, datum, f.getName());
			//System.out.println(s);
		
			/*byte[] checksum = Utilities.computeSHA256Hash(Utilities.fullyNormalizeText(s));
			for (byte b : checksum)
				System.out.print(b);
			System.out.println();
			String da = Utilities.checksumToString(checksum);
			System.out.println(da);*/
			
			
			Date datumDate = new Date(1234);
			
			datumDate.setTime(1305213918000L);
			System.out.println("ASDADSADASDAD");
			System.out.println(datumDate.getDate() + "." + datumDate.getMonth() + "." + (1900 + datumDate.getYear()));
			
			
		} catch(Exception e) {
			
		}
		
		
		
	}

}
