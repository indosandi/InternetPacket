package org.math.bit;

public class BitMan {
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
	public static byte getBitByte(byte b, byte pos){
		byte one=1;
		int i=(b & one<<pos)>>pos;
		if(i<1){
			return 0;
		}
		else{
			return 1;
		}
		
	}public static long byteArrtoInt(byte[] b){
		long res=0;;
//		res=b[0]&0xff;
		for(int i=0;i<b.length;i++){
			res=(res<<8)|(b[i]&0xff);
		}
//		System.out.println(Long.toBinaryString(res));
//		for(int i=0;i<b.length;i++){
//		 int temp=(int)b[b.length-i-1];
//		 if(temp<0){
//			 temp=128-temp;
//		 }
//		 res+=256^(i)*temp;
//		 System.out.println(i);
//		}
		return res;
	}
}
