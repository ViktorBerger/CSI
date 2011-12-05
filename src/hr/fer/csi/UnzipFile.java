package hr.fer.csi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnzipFile {
			
	public List<FileCharacteristics> getListOfFileCharacteristics(String path) {
		
		List<FileCharacteristics> allFiles = new ArrayList<FileCharacteristics>();
		
		// Deklariraj i inicijaliziraj zipFile
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(path);
		} 
		catch (IOException e2) {
			e2.printStackTrace();
		}
		
		// Enumeration svih fajlova u tome zipu, <? extends> ogranicenje na ulaz
		Enumeration<? extends ZipEntry> enumEntry = zipFile.entries();

		// pojedini file u zipu
		ZipEntry zipEntry;
		
		// Ulazni stream za odredjeni file
		InputStream in;

		while (enumEntry.hasMoreElements()) {
			zipEntry = enumEntry.nextElement();
			
			if (!zipEntry.isDirectory()) {
				try {
					in = zipFile.getInputStream(zipFile.getEntry(zipEntry.getName()));
					
					allFiles.add(new FileCharacteristics(readTextFile(in), zipEntry.getTime(), zipEntry.getName()));

				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}
		
		return allFiles;

	}

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

	

}
