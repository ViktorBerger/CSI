package hr.fer.csi;

import java.sql.Date;

public class FileCharacteristics {
	private String fileName;
	private Date dateCreated;
	private byte[] checksum;	
	private String sourceCode;
	private String sourceCodeFN;
	private int lineNumber;
	private int characterNumber;	// je li potrebno uop�e?
	private String[] comments;	// srediti regex, je li potrebno uop�e?
	
	// Promjeno long treba nesto da se taj date pretvori u normalno sql date
	FileCharacteristics(String source, long date, String name) {
		this.sourceCode = source;
		setFileName(name);
	}
	
	// Ime cudan nacin dobivanja :D
		private void setFileName(String name){
			String parts[] = name.split("/");
			int size = parts.length;
			fileName = String.format("%s_%s", parts[size-2], parts[size-1] );
		}
	
	
	public void doAll() {
		this.sourceCodeFN = Utilities.fullyNormalizeText(this.sourceCode);
		this.lineNumber = Utilities.countLines(this.sourceCode);
		try {
			this.checksum = Utilities.computeMD5Hash(this.sourceCode);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getFileSize() {
		/** TODO
		 * 
		 */
	}
	
	public String getFileName() {
		return this.fileName;
	}
	public Date getDateCreated() {
		return this.dateCreated;
	}
	public byte[] getChecksums() {
		return this.checksum;
	}
	public String getSourceCode() {
		return this.sourceCode;
	}
	public String getSourceCodeFN() {
		return this.sourceCodeFN;
	}
	public int getLineNumber() {
		return this.lineNumber;
	}
	public int characterNumber() {
		return this.characterNumber;
	}
	public String[] getComments() {
		return this.comments;
	}
	
}
