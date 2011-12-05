package hr.fer.csi;

import java.sql.Date;

public class FileCharacteristics {
	private String fileName;
	private String author;
	private Date dateModified;	
	private byte[] checksum;	
	private String sourceCode;
	private String sourceCodeFN;
	private int lineNumber;
	private long characterNumber;	
	private String[] comments;	// ne koristi se trenutno
	
	FileCharacteristics(String source, long date, String name) {
		setSourceCode(source);
		setDateModified(date);
		
		String[] tmp = name.split("/");
		setFileName(tmp[tmp.length - 1]);
		setAuthor(tmp[tmp.length - 2]);
	}
	
	public void doAll() {
		setSourceCodeFN(Utilities.fullyNormalizeText(this.sourceCode));
		setLineNumber(Utilities.countLines(getSourceCodeFN()));
		setCharacterNumber(Utilities.countCharacters(getSourceCodeFN()));
		try {
			setChecksum(Utilities.computeSHA256Hash(getSourceCodeFN()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getFileSize() {
		/** TODO
		 * 
		 */
	}
	
	public void setFileName(String name) {
		this.fileName = name;
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public void setDateModified(long date) {
		Date tmp = new Date(date);
		this.dateModified = tmp; 
		/** TODO
		 * 
		 */
	}
	
	public Date getDateModified() {
		return this.dateModified;
	}
	
	public void setChecksum(byte[] checksum) {
		this.checksum = checksum;
	}
	
	public byte[] getChecksum() {
		return this.checksum;
	}
	
	public void setSourceCode(String source) {
		this.sourceCode = source;
	}
	
	public String getSourceCode() {
		return this.sourceCode;
	}
	
	public void setSourceCodeFN(String source) {
		this.sourceCodeFN = source;
	}
	
	public String getSourceCodeFN() {
		return this.sourceCodeFN;
	}
	
	public void setLineNumber(int ln) {
		this.lineNumber = ln;
	}
	
	public int getLineNumber() {
		return this.lineNumber;
	}
	
	public void setCharacterNumber(long charNum) {
		this.characterNumber = charNum;
	}
	
	public long getCharacterNumber() {
		return this.characterNumber;
	}
	
	public void setComments(String[] comments) {
		this.comments = comments;
	}
	
	public String[] getComments() {
		return this.comments;
	}
	
}
