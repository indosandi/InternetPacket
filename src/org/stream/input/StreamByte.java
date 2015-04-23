package org.stream.input;

import java.io.FileInputStream;
import java.io.IOException;

public class StreamByte {
	byte[] byteIn;
	public byte[] getByteIn() {
		return byteIn;
	}
	String namefile;
	int byteSize;
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
