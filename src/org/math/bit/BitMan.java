package org.math.bit;

/**
 * Class consist of static method to manipulate bit.
 * 
 * @author sandiwibowo
 *
 */
public class BitMan {
	/**
	 * return either 0 or 1 of byte input at particular position
	 * @param b
	 * @param pos
	 * @return
	 */
	public static String getBit(byte b, byte pos){
		byte one=1;
		int i=(b & one<<pos)>>pos;
		if(i<1){
			return "0";
		}
		else{
			return "1";
		}
		
	}
	/**
	 * return either 0 or 1 of byte input at particular position
	 * @param b
	 * @param pos
	 * @return
	 */public static byte getBitByte(byte b, byte pos){
		byte one=1;
		int i=(b & one<<pos)>>pos;
		if(i<1){
			return 0;
		}
		else{
			return 1;
		}
		
	}
	/**
	 * return long value of arrangement of byte array. Lowest index is higher bit
	 * @param b
	 * @return
	 */
	 public static long byteArrtoInt(byte[] b){
		long res=0;;
		for(int i=0;i<b.length;i++){
			res=(res<<8)|(b[i]&0xff);
		}
		return res;
	}
}
