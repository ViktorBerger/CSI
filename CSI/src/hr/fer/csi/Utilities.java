package hr.fer.csi;

import java.security.MessageDigest;

public class Utilities {

	private Utilities() {	// privatni konstruktor tako da nitko ne stvara instance klase
	
	}

	public static int countLines(String text) {	// vraća broj redaka teksta
		text = text.replace("\n\n", "\n");
		String[] tmp = text.split("\n");
		return tmp.length;
		
	}
	
	public static long countCharacters(String text) {	// broji charactere u stringu
		text = removeBlanks(text);
		return text.length();
	}
	
	public static String removeBlanks(String text) {	// uklanja prazne redove razmake i sli�no 
		text = text.replace(" ", "");
		text = text.replace("\n", "");
		text = text.replace("\t", "");
		text = text.replace("\r", "");
		return text;
	}
	
	
	public static String removeComments(String text) {	// uklanja komentare iz Stringa
		String tmp = text.replaceAll("//.*\n|/\\*(.|\n)*?\\*/", "");
		return tmp;
	}
	
	
	public static String fullyNormalizeText(String text) {
		text = removeComments(text);
		return removeBlanks(text);
	}
		
	public static String[] getComments(String x) {	// NE VALJA
		/** TODO
		 * 
		 * */
		
		String[] tmp = x.split("[^//.*\n|/\\*(.|\n)*?\\*/]");
		return tmp;
		
	}
	
	public static byte[] computeMD5Hash(String text) throws Exception {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
		return md.digest(text.getBytes("UTF8"));
	}
	
	public static byte[] computeSHA1Hash(String text) throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		return md.digest(text.getBytes("UTF8"));
		
	}

}
