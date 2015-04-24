package org.stream.input;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * read binary file and save it into byte array
 * @author sandiwibowo
 *
 */
public class StreamByte {
	byte[] byteIn;
	public byte[] getByteIn() {
		return byteIn;
	}
	String namefile;
	int byteSize;
	/**
	 * read file from path and slice them into byte array
	 * @param s
	 */
	public StreamByte(String s){
		try{
			FileInputStream fis=new FileInputStream(s);
			this.byteSize=fis.available();
			this.byteIn=new byte[byteSize];	
            fis.read(byteIn);
            fis.close(); 
		}
		catch(IOException e){
			System.out.println("file not found");
		}
		
		
	}
}
