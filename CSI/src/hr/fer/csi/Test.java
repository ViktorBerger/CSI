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
			String x[] = Utilities.getComments(s);
			for (int i = 0; i < x.length; i++) 
				System.out.println(x[i].toString());
		} catch(Exception e) {
			
		}
		
		
	}

}
